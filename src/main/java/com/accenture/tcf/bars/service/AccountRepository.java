package com.accenture.tcf.bars.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.tcf.bars.domain.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	Account findByCustomerId(int id);
}
