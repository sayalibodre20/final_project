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
import com.bank.dto.EmployeeDto;
import com.bank.entities.Employee;
import com.bank.serviceinterface.EmployeeServiceIf;

@RestController
@RequestMapping(value="/employee")
public class EmployeeController {
	@Autowired
	private EmployeeServiceIf bs;

	public EmployeeController() {
		// TODO Auto-generated constructor stub
		System.out.println("Bank Controller");
	}

	@GetMapping("/allEmployee")
	public List<Employee> getAllEmp() {
		List<Employee> list = bs.getAllEmployee();
		return list;
	}

	@PostMapping("/insertEmp")
	public ResponseEntity<?> insertEmp(@RequestBody Employee b) {
		return new ResponseEntity<>(bs.addEmp(b), HttpStatus.CREATED);
	}
	@PostMapping("/insertEmp/dto")
	public ResponseEntity<?> insertEmp(@RequestBody EmployeeDto b) {
		return new ResponseEntity<>(bs.addEmpDto(b), HttpStatus.CREATED);
	}
	@PutMapping("/updateEmp")
	public ResponseEntity<?> updateEmp(@RequestBody Employee b) {
		return new ResponseEntity<>(bs.updateEmp(b), HttpStatus.OK);
	}
	@GetMapping("/EmpId")
	public ResponseEntity<?> getByEmpId(@RequestParam Long b) {
		return new ResponseEntity<>(bs.getById(b), HttpStatus.FOUND);
	}
	@DeleteMapping("/delete/{id}")
	public ApiResponse deleteEmp(@PathVariable Long id) {
		return new ApiResponse(bs.deleteEmp(id));
	}
}
