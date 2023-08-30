package com.bank.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.entities.Account;
import com.bank.repo.AccountRepo;
import com.bank.serviceinterface.AccountServiceIf;
@Service
@Transactional
public class AccountImpl implements AccountServiceIf{
	
	@Autowired
	private AccountRepo ar;
	public AccountImpl() {
		// TODO Auto-generated constructor stub
		System.out.println("In account Impl ");
	}

	@Override
	public String addAccount(Account a) {
		// TODO Auto-generated method stub
		ar.save(a);
		return "Account Added";
	}

	@Override
	public String updateCustomer(Account c) {
		// TODO Auto-generated method stub
		ar.save(c);
		return "Account updated";
	}

	@Override
	public List<Account> getAccount() {
		// TODO Auto-generated method stub
		return ar.findAll();
	}

	@Override
	public String deleteAccount(Long id) {
		// TODO Auto-generated method stub
		ar.deleteById(id);
		return "Account deleted";
	}

	@Override
	public Account getActId(Long id) {
		// TODO Auto-generated method stub
		Account a=ar.findByAccountId(id);
		return a;
	}

	@Override
	public String deposit(double amount,Long id) {
		// TODO Auto-generated method stub
		String mes="amount should be greater than zero";
		Account acc=getActId(id);
		if(amount > 0) {
			double balance=amount+acc.getBalance();
			acc.setBalance(balance);
			mes="Amount Deposited successfully";
		}
			
		return mes;
	}

	@Override
	public String withDraw(double amount,Long id) {
		// TODO Auto-generated method stub
		String mes="Insufficient balance";
		Account acc=getActId(id);
		if((acc.getBalance()) > 0 && (amount < acc.getBalance()) ) {
			double balance=acc.getBalance()-amount;
			acc.setBalance(balance);
			mes="Amount withdraw successfully";
		}
			
		return mes;
	}

	@Override
	public String moneyTransfer(double amount, Long sender, Long receiver) {
		// TODO Auto-generated method stub
		
		Account send=getActId(sender);
		Account rec=getActId(receiver);
		if((amount > 0) && (sender!=receiver)) {
			send.setBalance(send.getBalance()-amount);
			rec.setBalance(rec.getBalance()+amount);
			return "Money Transfer successfull";
		}else
		return "Invalid data";
	}

}
