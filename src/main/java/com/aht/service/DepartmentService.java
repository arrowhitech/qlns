package com.aht.service;

import java.util.List;

import com.aht.entities.Department;

public interface DepartmentService {
	public Department findOne(Long id) ;
	public List<Department> findAll() ;
	public Department createDepartment(Department department) ;
	public void deleteDepartment(Long id) ;
	public void updateDepartment(Department department) ;
}
