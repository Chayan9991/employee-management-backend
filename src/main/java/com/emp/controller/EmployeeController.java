package com.emp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.model.Employee;
import com.emp.services.EmployeeService;

@CrossOrigin(originPatterns = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService; 
	
	@PostMapping(path="/addEmp")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee); 
	}
	
	@GetMapping(path="/getEmp")
	public List<Employee> viewAllEmployees(){
		return employeeService.viewAllEmployees(); 
	}
	
	@DeleteMapping(path="/deleteEmp/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id){
		boolean deleted = false; 
		deleted = employeeService.deleteEmployee(id); 
		Map<String, Boolean> response = new HashMap(); 
		response.put("deleted", deleted); 
		return ResponseEntity.ok(response); 
	}
	

}
