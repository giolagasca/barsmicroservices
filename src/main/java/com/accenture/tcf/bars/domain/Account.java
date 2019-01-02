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

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Account {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "account_id")
	private Integer id;
	private String accountName;
	private Date dateCreated;
	private boolean isActive;
	private String lastEdited;
	private int customerId;	
}
