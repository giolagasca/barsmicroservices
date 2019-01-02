package com.accenture.tcf.bars.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request {
	
	private int billingCycle;
	private String startDate;
	private String endDate;

}
