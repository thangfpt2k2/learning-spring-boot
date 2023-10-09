package com.demo.test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.demo.test.model.Employee;
import com.demo.test.repository.EmployeeRepository;

@Service
public class EmployeeServiceImplement implements EmployeeService {

	@Autowired
	private EmployeeRepository eRepository;
	@Override
	public List<Employee> getEmployee() {
		return eRepository.findAll();
	}
	
	@Override
	public Employee saveEmployee(Employee employee) {
		return eRepository.save(employee);
	}
	@Override
	public Optional<Employee> getEmployeeById(Long id) {
		Optional<Employee> employee = eRepository.findById(id);
		return employee;
	}
	
	@Override
	public void deleteEmployee(Long id) {
		eRepository.deleteById(id);
	}
	
	@Override
	public Employee updateEmployee(Employee employee) {
		return eRepository.save(employee);
	}
	
	@Override
	public Optional<Employee> getEmpByName(String name) {
		Optional<Employee> e = eRepository.findEmployeeByName(name);
		return e;
	}
}
