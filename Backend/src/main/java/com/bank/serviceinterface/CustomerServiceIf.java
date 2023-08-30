package com.bank.serviceinterface;

import java.util.List;

import com.bank.entities.AccountType;
import com.bank.entities.Customer;

public interface CustomerServiceIf {

	String addCustomer(Customer c);
	String updateCustomer(Customer c);
	List<Customer> getCustomer();
	String deleteCustomer(Long id);
	Customer getCustId(Long id);
	
}
