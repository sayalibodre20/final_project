package com.bank.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.entities.Bank;

public interface BankRepo extends JpaRepository<Bank, Long> {

	Bank findByBranchCode(Long id);
}
