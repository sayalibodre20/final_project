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
import com.bank.entities.Account;
import com.bank.serviceinterface.AccountServiceIf;

@RestController
@RequestMapping("/customer/account")
public class AccountController {
	@Autowired
	private AccountServiceIf cs;

	public AccountController() {
		// TODO Auto-generated constructor stub
		System.out.println("in Account controller Impl");
	}

	@GetMapping("/getData")
	public List<?> getAllEmp() {

		List<?>accList= cs.getAccount();
		return accList;
	}

	@PostMapping("/insertAccount")
	public ResponseEntity<?> insertEmp(@RequestBody Account b) {
		return new ResponseEntity<>(cs.addAccount(b), HttpStatus.CREATED);
	}

//	@PostMapping("/insertEmp/dto")
//	public ResponseEntity<?> insertEmp(@RequestBody EmployeeDto b) {
//		return new ResponseEntity<>(bs.addEmpDto(b), HttpStatus.CREATED);
//	}
	@PutMapping("/updateAccount")
	public ResponseEntity<?> updateEmp(@RequestBody Account b) {
		return new ResponseEntity<>(cs.updateCustomer(b), HttpStatus.OK);
	}
//deposit amount
	@PutMapping("/updateAccount/deposit")
	public ResponseEntity<?> depositAmount(@RequestParam double amount,@RequestParam long id) {
		return new ResponseEntity<>(cs.deposit(amount, id), HttpStatus.OK);
	}
	//withdraw
	@PutMapping("/updateAccount/withdraw")
	public ResponseEntity<?> withDrawAmount(@RequestParam double amount,@RequestParam long id) {
		return new ResponseEntity<>(cs.withDraw(amount, id), HttpStatus.OK);
	}
	//money transfer
	@PutMapping("/updateAccount/transfer")
	public ResponseEntity<?> transfer(@RequestParam double amount,@RequestParam long sender_accno,@RequestParam long receiver_accno) {
		return new ResponseEntity<>(cs.moneyTransfer(amount, sender_accno, receiver_accno), HttpStatus.OK);
	}
	@GetMapping("/AccountId")
	public ResponseEntity<?> getByEmpId(@RequestParam Long b) {
		return new ResponseEntity<>(cs.getActId(b), HttpStatus.FOUND);
	}
	
	
	@DeleteMapping("/deleteAccount/{id}")
	public ApiResponse deleteAcc(@PathVariable Long id) {
		return new ApiResponse(cs.deleteAccount(id));
	}

}
