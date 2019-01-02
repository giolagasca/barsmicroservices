package com.accenture.tcf.bars.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.tcf.bars.domain.Account;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountRepository repository;

	@Override
	public Optional<Account> findById(int id) {
		return repository.findById(id);
	}

}
