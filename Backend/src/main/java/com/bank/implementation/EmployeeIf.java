package com.bank.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bank.dto.EmployeeDto;
import com.bank.entities.Customer;
import com.bank.entities.Employee;
import com.bank.exception.ResourceNotFoundException;
import com.bank.repo.CustomerRepo;
import com.bank.repo.EmployeeRepo;
import com.bank.serviceinterface.EmployeeServiceIf;
@Service
@Transactional
public class EmployeeIf implements EmployeeServiceIf {
	
	public EmployeeIf() {
		// TODO Auto-generated constructor stub
		System.out.println("In employee Impl");
	}
	@Autowired
	private CustomerRepo cs;
	@Autowired
	private PasswordEncoder passEnco;
	@Autowired
	private ModelMapper map;
	@Autowired
	private EmployeeRepo emp;
	@Override
	public String addEmp(Employee e) {
		// TODO Auto-generated method stub
		e.setPassword(passEnco.encode(e.getPassword()));
		emp.save(e);
		return "Employee Added";
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> list=emp.findAll();
		return list;
	}

	@Override
	public String updateEmp(Employee b) {
		//Employee d=map.map(b, Employee.class);
		emp.save(b);
		return "Employee updated";
	}

	@Override
	public String deleteEmp(Long id) {
		// TODO Auto-generated method stub
		emp.deleteById(id);
		return "Employee deleted";
	}

	@Override
	public Employee getById(Long id) {
		// TODO Auto-generated method stub
		Employee e=emp.findByEmpId(id);
		return e;
	}

	@Override
	public String addEmpDto(EmployeeDto e) {
		// TODO Auto-generated method stub
		Employee d=map.map(e, Employee.class);
		d.setPassword(passEnco.encode(d.getPassword()));
		emp.save(d);
		return "Added";
	}

	@Override
	public List<Customer> serachCustomer() {
		// TODO Auto-generated method stub
		return cs.findAll();
	}

}
