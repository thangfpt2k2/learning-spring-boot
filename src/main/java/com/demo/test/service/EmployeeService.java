package com.demo.test.service;

import java.util.List;
import java.util.Optional;

import com.demo.test.model.Employee;

public interface EmployeeService {
	
	List<Employee> getEmployee(); 
	
	Employee saveEmployee(Employee employee);
	
	Optional<Employee> getEmployeeById(Long id);
	
	void deleteEmployee(Long id);
	
	Employee updateEmployee(Employee employee);
	
	Optional<Employee> getEmpByName(String name);
}
