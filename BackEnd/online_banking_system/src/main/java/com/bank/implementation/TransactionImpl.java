package com.bank.implementation;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.entities.Transaction;
import com.bank.exception.ResourceNotFoundException;
import com.bank.repo.TransactionRepo;
import com.bank.serviceinterface.TransactionRepoIf;

@Service
@Transactional
public class TransactionImpl implements TransactionRepoIf {

	@Autowired
	private TransactionRepo transactionRepoInstance;
	
	@Override
	public List<Transaction> getAllTransactionList() {
		
		List<Transaction> list=transactionRepoInstance.findAll();
		return list;
	}

	@Override
	public String addTransaction(Transaction tobj) {
	transactionRepoInstance.save(tobj);

	return "branch added successfully!!!";
	}

	@Override
	public String updateTransaction(Transaction tobj) {
		
		transactionRepoInstance.save(tobj);
		
		return "transcation updated successfully!!";
	}

	@Override
	public String deleteTransaction(Long accountid) {
		transactionRepoInstance.deleteById(accountid);
		return "Transaction deleted successfully!!";
	}

	@Override
	public Optional<Transaction> getById(Long id) {
		
		return transactionRepoInstance.findById(id);
		
		}
	

}
