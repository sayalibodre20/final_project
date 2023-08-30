package com.bank.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties({"list","accounts"})
public class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="Branch_code" ,length = 7)
	private Long branchCode;
	@Column(length = 50)
	private String location;
	@Column(name = "Pincode")
	private int pinCode;
	@OneToMany(mappedBy = "branchCode",cascade = CascadeType.ALL,orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Employee> list=new ArrayList<Employee>();
	
	@OneToMany(mappedBy = "branchId",cascade = CascadeType.ALL,orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Customer> accounts=new ArrayList<Customer>();
	
	//add helper method to assign bank bbranch code to employee
	public void addEmp(Employee e) {
		list.add(e);
		e.setBranchCode(this);
		
	}
	public void addAccount(Customer a) {
		accounts.add(a);
		a.setBranchId(this);	
	}
	//add helper method to remove an employee
		public void removeEmp(Employee e) {
			list.remove(e);
			e.setBranchCode(null);
		}
		public void removeAccount(Customer a) {
			accounts.remove(a);
			a.setBranchId(null);	
		}
}
