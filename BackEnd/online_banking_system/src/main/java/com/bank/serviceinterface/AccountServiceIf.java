package com.bank.serviceinterface;

import java.util.List;
import java.util.Optional;

import com.bank.entities.Account;

public interface AccountServiceIf {
	String addAccount(Account a);
	String updateCustomer(Account c);
	List<Account> getAccount();
	String deleteAccount(Long id);
	Account getActId(Long id);
	String deposit(double amount,Long id);
	String withDraw(double amount,Long id);
	String moneyTransfer(double amount,Long sender,Long receiver);
	
}
