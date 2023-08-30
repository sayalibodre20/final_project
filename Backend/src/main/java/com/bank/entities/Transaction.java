package com.bank.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data

@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreType
public class Transaction {

	     @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private BigDecimal amount;
	    private BigDecimal newBalanace;
	    private BigDecimal Oldbalance;
	    private LocalDate date;
	    @ManyToOne
	    @JoinColumn(name="account_id")
	    private Account account;
	    
	  
}
