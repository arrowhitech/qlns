package com.aht.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aht.entities.Department;
import com.aht.service.DepartmentService;




@RestController
public class DepartmentController {

	

	
	@Autowired private DepartmentService departmentService;
	

	@GetMapping("/departments")
	public ResponseEntity<List<Department>> getAll(){
		
		return new ResponseEntity<List<Department>>(departmentService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/department")
	public ResponseEntity<List<Department>> getAllUser(){
		
		return new ResponseEntity<List<Department>>(departmentService.findAll(), HttpStatus.OK);
	}
	
	
	@GetMapping("/departments/{id}")
	public ResponseEntity<Department> getOne(@PathParam(value = "id") Long id){
		return new ResponseEntity<Department>(departmentService.findOne(id),HttpStatus.OK);
	}
	
	@PostMapping("/department")
	public ResponseEntity<String> create(@RequestBody Department department){
		departmentService.createDepartment(department);
		return new ResponseEntity<String>("created!",HttpStatus.OK);
	}

	@DeleteMapping("/departments/{id}")
	public ResponseEntity<String> delete(@PathParam(value = "id") Long id){
		departmentService.deleteDepartment(id);
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	}
	@PutMapping("/departments")
	public ResponseEntity<String> update(@RequestBody Department department){
		departmentService.updateDepartment(department);
		return new ResponseEntity<String>("updated",HttpStatus.OK);
	}
}
