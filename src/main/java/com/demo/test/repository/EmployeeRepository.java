package com.demo.test.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.test.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	@Query("SELECT employee FROM Employee employee WHERE employee.fullname = ?1")
	Optional<Employee> findEmployeeByName(String fullname);
}
