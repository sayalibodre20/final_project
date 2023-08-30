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
import com.bank.dto.BankDto;
import com.bank.entities.Bank;
import com.bank.serviceinterface.BranchServiceIf;

@RestController
@RequestMapping("/employee/Bank")
public class BankController {
	@Autowired
	private BranchServiceIf bs;

	public BankController() {
		// TODO Auto-generated constructor stub
		System.out.println("Bank Controller");
	}

	@GetMapping("/branch")
	public List<?> getAllBank() {
		List<?> list = bs.getAllBrances();
		return list;
	}

	@PostMapping("/insert")
	public ResponseEntity<?> insertBranch(@RequestBody Bank b) {
		return new ResponseEntity<>(bs.addBranch(b), HttpStatus.CREATED);
	}
	
	@PostMapping("/insert/dto")
	public ResponseEntity<?> insertBranchDto(@RequestBody BankDto b) {
		return new ResponseEntity<>(bs.addBranchDto(b), HttpStatus.CREATED);
	}
	@PutMapping("/update")
	public ResponseEntity<?> updateBranch(@RequestBody Bank b) {
		return new ResponseEntity<>(bs.updateBank(b), HttpStatus.OK);
	}
	@GetMapping("/branchcode")
	public ResponseEntity<?> getByBranchId(@RequestParam Long b) {
		return new ResponseEntity<>(bs.getByid(b), HttpStatus.FOUND);
	}
	@DeleteMapping("/delete/{id}")
	public ApiResponse delete(@PathVariable Long id) {
		return new ApiResponse(bs.deleteBranch(id));
	}
}
