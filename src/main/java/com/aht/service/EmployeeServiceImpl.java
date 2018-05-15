package com.aht.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aht.entities.Employee;
import com.aht.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService{
  
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee findOne(Long id) {
		return employeeRepository.getOne(id);
	}
	public List<Employee> findAll() {
		
		return employeeRepository.findAll();
	}	
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}
	public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
}
