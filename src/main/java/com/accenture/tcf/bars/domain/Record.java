package com.accenture.tcf.bars.domain;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Record {
	
	private int billingCycle;
	private Date startDate;
	private Date endDate;
	private String accountName;
	private String firstName;
	private String lastName;
	private double amount;

}
