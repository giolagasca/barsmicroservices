package com.accenture.tcf.bars.service;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.accenture.tcf.bars.domain.Account;

@Component
public interface AccountService {
	Optional<Account> findById(int id);
}
