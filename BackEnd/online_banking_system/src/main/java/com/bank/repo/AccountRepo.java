package com.bank.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.entities.Account;

public interface AccountRepo extends JpaRepository<Account, Long> {

	Account findByAccountId(Long id);
}
