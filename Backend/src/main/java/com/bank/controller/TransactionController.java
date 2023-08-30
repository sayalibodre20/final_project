package com.bank.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.entities.Transaction;
import com.bank.serviceinterface.TransactionRepoIf;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
@RestController
@RequestMapping("customer/account/Transaction")
public class TransactionController {

	@Autowired
	private TransactionRepoIf transactionRepoInstance;
	public TransactionController() {
		super();
		System.out.println("Transaction Controller");
	}
	
	@GetMapping
	public List<?> getAllTransaction()
	{
		List<?> list=transactionRepoInstance.getAllTransactionList();
		return list;
	}
	
	@PostMapping("insertMoney")
	public ResponseEntity<?> addTransactions(@RequestBody Transaction t)
	{
		return new ResponseEntity<>(transactionRepoInstance.addTransaction(t),HttpStatus.CREATED);
	}

	@GetMapping("/{account_no}")
	
	public ResponseEntity<Transaction> getByAccoutNumber(@PathVariable Long account_no)
	{
		Optional<Transaction> transactionOptional=transactionRepoInstance.getById(account_no);
		
		if(transactionOptional.isPresent())
		{
			return ResponseEntity.ok(transactionOptional.get());
		}
		else
		{
			
		return ResponseEntity.notFound().build();	
		}
		
		
			}
	
}
