package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dto.ApiResponse;
import com.bank.entities.Customer;
import com.bank.serviceinterface.CustomerServiceIf;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerServiceIf cs;
	public CustomerController() {
		// TODO Auto-generated constructor stub
		System.out.println("in customer controller Impl");
	}
	
	@GetMapping("/allCustomer")
	public List<Customer> getAllEmp() {
		List<Customer> list = cs.getCustomer();
		return list;
	}

	@PostMapping("/insertCustomer")
	public ResponseEntity<?> insertEmp(@RequestBody Customer b) {
		return new ResponseEntity<>(cs.addCustomer(b), HttpStatus.CREATED);
	}
//	@PostMapping("/insertEmp/dto")
//	public ResponseEntity<?> insertEmp(@RequestBody EmployeeDto b) {
//		return new ResponseEntity<>(bs.addEmpDto(b), HttpStatus.CREATED);
//	}
	@PutMapping("/updateCustomer")
	public ResponseEntity<?> updateEmp(@RequestBody Customer b) {
		return new ResponseEntity<>(cs.updateCustomer(b), HttpStatus.OK);
	}
	@GetMapping("/Custid")
	public ResponseEntity<?> getByEmpId(@RequestParam Long b) {
		return new ResponseEntity<>(cs.getCustId(b), HttpStatus.FOUND);
	}
	@DeleteMapping("/deleteCustomer/{id}")
	public ApiResponse deleteCust(@PathVariable Long id) {
		return new ApiResponse(cs.deleteCustomer(id));
	}

}
