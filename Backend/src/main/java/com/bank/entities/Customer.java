package com.bank.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties(value = "accountlist")
public class Customer {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CustomerId")
	private Long customerId;
	@Column(name = "Full_Name",length = 50)
	private String name;
	@Column(name = "Email",nullable = false,unique = true)
	private String email;
	@Column(name = "contact",length =20,nullable = false,unique = true)
	private long contact;
	@Column(name = "AddharNo",length =12,nullable = false,unique = true)
	private long addharNo;
	@Column(name = "Address",length =50,nullable = false)
	private String adddress;
	@Column(name = "BirthDate",nullable = false)
	private LocalDate birthDate;
	@Column(name = "pincode",nullable = false)
	private int pincode;
	@Column(name = "Password",nullable = false)
	private String password;
	
	
	@ManyToOne
	@JoinColumn(name = "BranchId",nullable = false)
	private Bank branchId;
	@OneToMany(mappedBy = "customerId",cascade = CascadeType.ALL,orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Account> accountlist=new ArrayList<Account>();
	
	
	
	//helper methods
	public void addAccount(Account a) {
		accountlist.add(a);
		a.setCustomerId(this);
		
	
	}
	public void removeAccount(Account a) {
		accountlist.remove(a);
		a.setCustomerId(null);
	}
	
	

}
