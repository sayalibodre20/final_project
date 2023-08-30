package com.bank.serviceinterface;

import java.util.List;

import com.bank.dto.EmployeeDto;
import com.bank.entities.Customer;
import com.bank.entities.Employee;

public interface EmployeeServiceIf {
	
	String addEmp(Employee e);
	List<Employee> getAllEmployee();
	String updateEmp(Employee b);
	String deleteEmp(Long id);
	Employee getById(Long id);
	String addEmpDto(EmployeeDto e);
	List<Customer> serachCustomer();
}
