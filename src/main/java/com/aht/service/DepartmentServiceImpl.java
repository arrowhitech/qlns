package com.aht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aht.entities.Department;
import com.aht.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public Department findOne(Long id) {
		return departmentRepository.getOne(id);
	}
	public List<Department> findAll() {
		
		return departmentRepository.findAll();
	}	
	public Department createDepartment(Department department) {
		return departmentRepository.save(department);
	}
	public void deleteDepartment(Long id) {
		departmentRepository.deleteById(id);
	}
	public void updateDepartment(Department department) {
		departmentRepository.save(department);
	}

}
