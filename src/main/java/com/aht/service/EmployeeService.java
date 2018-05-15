package com.aht.service;

import java.util.List;

import com.aht.entities.Employee;

public interface EmployeeService {
	public Employee findOne(Long id) ;
	public List<Employee> findAll() ;
	public Employee createEmployee(Employee employee) ;
	public void deleteEmployee(Long id);
	public void updateEmployee(Employee employee) ;
}
