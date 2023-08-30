package com.bank.serviceinterface;

import java.util.List;
import java.util.Optional;

import com.bank.entities.Transaction;
import com.bank.repo.TransactionRepo;

public interface TransactionRepoIf {

	List<Transaction> getAllTransactionList();
	
	String addTransaction(Transaction tobj);
	
	String updateTransaction(Transaction tobj);
	
	String deleteTransaction(Long accountid);
	
	Optional<Transaction> getById(Long id);
}
