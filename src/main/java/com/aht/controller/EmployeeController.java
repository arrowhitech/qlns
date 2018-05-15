package com.aht.controller;

import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aht.entities.Employee;
import com.aht.service.EmployeeService;




@RestController
public class EmployeeController  {

	
	
	@Autowired private EmployeeService employeeService;

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAll(){
		
		return new ResponseEntity<List<Employee>>(employeeService.findAll(), HttpStatus.OK);
	}
	
	
	
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getOne(@PathParam(value = "id") Long id){
		return new ResponseEntity<Employee>(employeeService.findOne(id),HttpStatus.OK);
	}
	
	@PostMapping("/employees")
	public ResponseEntity<String> create(@RequestBody Employee employee){
		employeeService.createEmployee(employee);
		return new ResponseEntity<String>("created!",HttpStatus.OK);
	}


	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<String> delete(@PathParam(value = "id") Long id){
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	}
	@PutMapping("/employees")
	public ResponseEntity<String> update(@RequestBody Employee employee){
		employeeService.updateEmployee(employee);
		return new ResponseEntity<String>("updated",HttpStatus.OK);
	}
}
