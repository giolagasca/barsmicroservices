package com.accenture.tcf.bars.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.tcf.bars.domain.Account;
import com.accenture.tcf.bars.domain.Billing;
import com.accenture.tcf.bars.domain.Customer;
import com.accenture.tcf.bars.domain.Record;
import com.accenture.tcf.bars.domain.Request;
import com.accenture.tcf.bars.exception.BarsException;
import com.accenture.tcf.bars.service.AccountService;
import com.accenture.tcf.bars.service.BillingService;
import com.accenture.tcf.bars.service.CustomerService;

@RestController
public class BarsController {
	
	@Autowired
	BillingService billingService;
	@Autowired
	AccountService accountService;
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/")
	public List<Billing> eyy() {
		return billingService.findAllBillings();
	}
	
	@PostMapping("/success")
	public List<Record> displayRecords(List<Request> requests, String fileType) throws BarsException, ParseException {
		List<Record> records = new ArrayList<>();
		SimpleDateFormat sdf;
		String regex = "([0-9]{2})/([0-9]{2})/([0-9]{4})";
		if("csv".equals(fileType)) {
			sdf = new SimpleDateFormat("MM/dd/yyyy");
		}
		else if("txt".equals(fileType)) {
			sdf = new SimpleDateFormat("MMddyyyy");
		}
		else {
			throw new BarsException(BarsException.NO_SUPPORTED_FILE);
		}
		for(Request request: requests) {
			if(request.getBillingCycle() < 0 || request.getBillingCycle() > 12)
				throw new BarsException(BarsException.BILLING_CYCLE_NOT_ON_RANGE);
			int billingCycle = request.getBillingCycle();
			if(!(request.getStartDate().matches(regex))) 
				throw new BarsException(BarsException.INVALID_START_DATE_FORMAT);
			Date startDate = sdf.parse(request.getStartDate());
			if(!(request.getEndDate().matches(regex))) 
				throw new BarsException(BarsException.INVALID_START_DATE_FORMAT);
			Date endDate = sdf.parse(request.getEndDate());
			Billing billing = billingService.findByBillingCycleAndStartDateAndEndDate(
					billingCycle, startDate, endDate);
			Account account = accountService.findById(billing.getAccountId()).orElseThrow(() -> new BarsException(BarsException.NO_RECORDS_TO_READ));
			Customer customer = customerService.findById(account.getCustomerId()).orElseThrow(() -> new BarsException(BarsException.NO_RECORDS_TO_READ));
			
			records.add(new Record(billingCycle, startDate, 
					endDate,account.getAccountName(),customer.getFirstName(),
					customer.getLastName(),billing.getAmount()));
		}
		return records;
	}
}
