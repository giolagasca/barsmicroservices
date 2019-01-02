package com.accenture.tcf.bars.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.tcf.bars.domain.Billing;

@Service
public class BillingServiceImpl implements BillingService {
	
	@Autowired
	BillingRepository repository;

	@Override
	public Optional<Billing> findById(int id) {
		return repository.findById(id);
	}
	
	
	@Override
	public Billing findByBillingCycleAndStartDateAndEndDate(int billingCycle, Date startDate, Date endDate) {
		return repository.findByBillingCycleAndStartDateAndEndDate(billingCycle, startDate, endDate);
	}

	@Override
	public List<Billing> findAllBillings() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Billing updateBilling(Billing billing) {
		//Optional<Billing> theBilling = repository.findById(billing.getId());
		
		return null;
	}

	@Override
	public void deleteBilling(Billing billing) {
		repository.delete(billing);
		
	}

}
