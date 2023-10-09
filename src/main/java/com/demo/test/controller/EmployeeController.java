package com.demo.test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.demo.test.model.Employee;
import com.demo.test.response.ResponseObject;
import com.demo.test.service.EmployeeService;



@RestController
@RequestMapping("/employees")
@PreAuthorize("hasRole('ADMIN')")
public class EmployeeController {
	@Autowired
	private EmployeeService eService;

	@GetMapping()
	@PreAuthorize("hasAnyAuthority('admin:read')")
	 List<Employee> getEmployees() {
		return eService.getEmployee();
	}
	@GetMapping("/{id}")
	 ResponseEntity<ResponseObject> getEmployee(@PathVariable Long id) {
		Optional<Employee> e = eService.getEmployeeById(id);
		if(e.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(
			new ResponseObject("OK", "Query employee successfully",e)		
			);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
					new ResponseObject("FAILED", "Not found employee with " +id,null)	
			);
		}
	}
	
	@DeleteMapping()
	@PreAuthorize("hasAnyAuthority('admin:delete')")
	 ResponseEntity<ResponseObject> deleteEmployee(@RequestParam Long id) {
		Optional<Employee> e = eService.getEmployeeById(id);
		if(e.isPresent()) {
			eService.deleteEmployee(id);
			return ResponseEntity.status(HttpStatus.OK).body(
				new ResponseObject("OK","Delete employee successfully","")
			);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
					new ResponseObject("FAILED", "Not found employee with " +id,"")	
			);
		}
	}
	
	@PostMapping()
	@PreAuthorize("hasAnyAuthority('admin:create')")
	 ResponseEntity<ResponseObject> saveEmployee(@RequestBody Employee employee) {
		Optional<Employee> e = eService.getEmpByName(employee.getFullname());
		if(e.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
					new ResponseObject("FAILED","Employee have exist","")
			);
		}else {
			eService.saveEmployee(employee);
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseObject("FAILED","Create employee successfuly","")
			);
		}
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasAnyAuthority('admin:update')")
	ResponseEntity<ResponseObject> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		Optional<Employee> e = eService.getEmployeeById(id);
		if(e.isPresent()) {
			eService.saveEmployee(employee);
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseObject("FAILED","Update employee successfuly","")
			);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
					new ResponseObject("FAILED","Not found employee to update","")
			);
		}
	}
	@GetMapping("/byname")
	@PreAuthorize("hasAnyAuthority('admin:read')")
	ResponseEntity<ResponseObject> getEmployee(@RequestParam String name) {
		Optional<Employee> e = eService.getEmpByName(name);
		if(e.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(
				new ResponseObject("OK","Query employee successfully",e)
			);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
					new ResponseObject("FAILED", "Not found employee with " + name,"")	
			);
		}
		
	}
	
}
