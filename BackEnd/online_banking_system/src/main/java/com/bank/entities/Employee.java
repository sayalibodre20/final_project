package com.bank.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EmpId")
	private Long empId;
	@Column(name = "Employee_Name",length = 25)
	private String employeeName; 
	@Column(name = "email",unique = true)
	private String email;
	@Enumerated(EnumType.STRING)
	private Role role;
	@Column(name = "password",nullable = false)
	private String password;
	@ManyToOne//(fetch = FetchType.EAGER)
	@JoinColumn(name = "Branch_code",nullable = false)
	private Bank branchCode;
	public Employee(String employeeName, Role role,String password, Bank branchCode) {
		super();
		this.employeeName = employeeName;
		this.role = role;
		this.password=password;
		this.branchCode = branchCode;
	}
	
}

	
