package com.emp.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.entity.EmployeeEntity;
import com.emp.model.Employee;
import com.emp.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(Employee employee) {

		EmployeeEntity employeeEntity = new EmployeeEntity();
		
		BeanUtils.copyProperties(employee, employeeEntity);
		employeeRepository.save(employeeEntity);
		return employee;
	}
    
	@Override
	public List<Employee> viewAllEmployees() {
		List<EmployeeEntity> employeeEntities = employeeRepository.findAll(); 
		
		List<Employee> employees = employeeEntities.stream().map(emp -> new Employee(emp.getId(), emp.getFull_name(), emp.getAddress(), emp.getEmail_id())).collect(Collectors.toList()); 
		return employees; 
		
	}

	@Override
	public boolean deleteEmployee(Long id) {
		EmployeeEntity employee = employeeRepository.findById(id).get(); 
		employeeRepository.delete(employee);
		return true; 
	}
	
	

}
