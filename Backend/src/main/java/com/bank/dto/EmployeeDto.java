package com.bank.dto;

import com.bank.entities.Bank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeeDto {
	private Long empId;
	private String employeeName;
	private String email;
	private String role;
	private String password;
	private Bank branchCode;
}
