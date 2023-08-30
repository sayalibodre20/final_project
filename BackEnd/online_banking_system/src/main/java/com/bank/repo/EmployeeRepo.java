package com.bank.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.entities.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	Employee findByEmpId(Long id);
//	@Query("select e from Employee e")
//	List<Employee> getAll();
	Employee findByEmail(String email);
}
