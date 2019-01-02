package com.accenture.tcf.bars.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Billing {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "billing_id")
	private Integer id;
	private int billingCycle;
	private Date billingMonth;
	private double amount;
	private Date startDate;
	private Date endDate;
	private String lastEdited;
	private int accountId;
}
