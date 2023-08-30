package com.bank.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.entities.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {
	
	Optional<Transaction> findById(Long accountid);

}
