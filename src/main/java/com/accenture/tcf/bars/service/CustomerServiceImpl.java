package com.accenture.tcf.bars.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.tcf.bars.domain.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository repository;

	@Override
	public Optional<Customer> findById(int id) {
		return repository.findById(id);
	}

}
