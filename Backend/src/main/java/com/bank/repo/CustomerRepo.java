package com.bank.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bank.entities.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

	Customer findByCustomerId(Long id);

	@Modifying
	@Query("delete from Customer c where c.customerId=:id")
	void deleteId(Long id);
	Customer findByEmail(String email);
}
