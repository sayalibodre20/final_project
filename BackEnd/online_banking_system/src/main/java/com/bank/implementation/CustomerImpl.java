package com.bank.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bank.entities.AccountType;
import com.bank.entities.Customer;
import com.bank.repo.CustomerRepo;
import com.bank.serviceinterface.CustomerServiceIf;
@Service
@Transactional
public class CustomerImpl implements CustomerServiceIf{

	@Autowired
	private CustomerRepo cr;
	//encrypted password
	@Autowired
	private PasswordEncoder passEnco;
	public CustomerImpl() {
		// TODO Auto-generated constructor stub
		System.out.println("in customer Impl");
	}
	@Override
	public String addCustomer(Customer c) {
		// TODO Auto-generated method stub
		c.setPassword(passEnco.encode(c.getPassword()));
		cr.save(c);
		return "Customer Added";
	}

	@Override
	public String updateCustomer(Customer c) {
		// TODO Auto-generated method stub
		cr.save(c);
		return "Customer updated";
	}

	@Override
	public List<Customer> getCustomer() {
		// TODO Auto-generated method stub
		return cr.findAll();
	}

	@Override
	public String deleteCustomer(Long id) {
		// TODO Auto-generated method stub
		cr.deleteId(id);
		return "Customer deleted";
	}

	@Override
	public Customer getCustId(Long id) {
		// TODO Auto-generated method stub
		Customer c=cr.findByCustomerId(id);
		return c;
	}
	
}
