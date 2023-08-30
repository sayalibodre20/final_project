package com.bank.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.bank.entities.Customer;
import com.bank.entities.Employee;
import com.bank.repo.CustomerRepo;
import com.bank.repo.EmployeeRepo;

public class CustomerDetailsService implements UserDetailsService {

	@Autowired
	private EmployeeRepo empRepo;
	@Autowired
	private CustomerRepo custRepo;
	//cvombining login of customer in single class
	
	 @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        Employee employee = empRepo.findByEmail(username);
	        if (employee != null) {
	            return new EmployeePrincipal(employee);
	        }

	        Customer customer = custRepo.findByEmail(username);
	        if (customer != null) {
	            return new CustomerPrincipal(customer);
	        }

	        throw new UsernameNotFoundException("User not found");
	    }

}
