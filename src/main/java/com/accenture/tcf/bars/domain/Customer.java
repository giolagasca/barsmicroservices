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
public class Customer {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private Integer id;
	private String firstName;
	private String lastName;
	private String address;
	private boolean status;
	private Date dateCreated;
	private String lastEdited;
	
}
