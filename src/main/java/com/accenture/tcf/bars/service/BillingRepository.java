package com.accenture.tcf.bars.service;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.tcf.bars.domain.Billing;

@Repository
public interface BillingRepository extends JpaRepository<Billing, Integer> {
	Billing findByAccountId(int id);
	Billing findByBillingCycleAndStartDateAndEndDate(int billingCycle, Date startDate, Date endDate);

}
