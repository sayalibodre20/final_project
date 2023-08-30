package com.bank.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreType
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Account_No")
	private Long accountId;
	@Enumerated(EnumType.STRING)
	@Column(name = "Account_type",length = 25)
	private AccountType type;
	@Column(name = "Balance",length = 25)
	private double balance;
	@ManyToOne
	@JoinColumn(name = "customerId",nullable = false)
	private Customer customerId;
	
	
	@OneToMany(mappedBy = "account",orphanRemoval=true,cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Transaction> transactions=new ArrayList<>();
	
	public boolean addTransaction(Transaction transactionobj)
	{
		transactions.add(transactionobj);
		transactionobj.setAccount(this);
		return true;
		
	}
	public void removeTransaction(Transaction transactionobj)
	{
		transactions.remove(transactionobj);
		transactionobj.setAccount(null);
	}
	

}
