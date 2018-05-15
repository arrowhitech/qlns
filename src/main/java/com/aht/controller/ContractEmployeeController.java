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

import com.aht.entities.ContractEmployee;
import com.aht.service.ContractEmployeeService;


@RestController
public class ContractEmployeeController {

	

	
	@Autowired private ContractEmployeeService contractEmployeeService;
	
	@GetMapping("/contractempls")
	public ResponseEntity<List<ContractEmployee>> getAll(){
		
		return new ResponseEntity<List<ContractEmployee>>(contractEmployeeService.findAll(), HttpStatus.OK);
	}
	
	
	@GetMapping("/contractempls/{id}")
	public ResponseEntity<ContractEmployee> getOne(@PathParam(value = "id") Long id){
		return new ResponseEntity<ContractEmployee>(contractEmployeeService.findOne(id),HttpStatus.OK);
	}
	
	@PostMapping("/contractempls")
	public ResponseEntity<String> create(@RequestBody ContractEmployee contractEmployee){
		contractEmployeeService.createContractEmployee(contractEmployee);
		return new ResponseEntity<String>("created!",HttpStatus.OK);
	}

	@DeleteMapping("/contractempls/{id}")
	public ResponseEntity<String> delete(@PathParam(value = "id") Long id){
		contractEmployeeService.deleteContractEmployee(id);
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	}
	@PutMapping("/contractempls")
	public ResponseEntity<String> update(@RequestBody ContractEmployee contractEmployee){
		contractEmployeeService.updateContractEmployee(contractEmployee);
		return new ResponseEntity<String>("updated",HttpStatus.OK);
	}
}
