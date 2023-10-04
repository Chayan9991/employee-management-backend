package com.emp.services;

import java.util.List;

import com.emp.model.Employee;

public interface EmployeeService {

	Employee createEmployee(Employee employee);
	List<Employee> viewAllEmployees();
	boolean deleteEmployee(Long id); 
	
}
