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

import com.aht.entities.Contract;
import com.aht.service.ContractService;





@RestController
public class ContractController  {

	

	@Autowired private ContractService contractService;
	

	@GetMapping("/contracts")
	public ResponseEntity<List<Contract>> getAll(){
		
		return new ResponseEntity<List<Contract>>(contractService.findAll(), HttpStatus.OK);
	}
	
	
	@GetMapping("/contracts/{id}")
	public ResponseEntity<Contract> getOne(@PathParam(value = "id") Long id){
		return new ResponseEntity<Contract>(contractService.findOne(id),HttpStatus.OK);
	}
	
	@PostMapping("/contracts")
	public ResponseEntity<String> create(@RequestBody Contract contract){
		
		
		contractService.createContract(contract);
		return new ResponseEntity<String>("created!",HttpStatus.OK);
	}

	@DeleteMapping("/contract/{id}")
	public ResponseEntity<String> delete(@PathParam(value = "id") Long id){
		contractService.deleteContract(id);
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	}
	@PutMapping("/contracts")
	public ResponseEntity<String> update(@RequestBody Contract contract){
		contractService.updateContract(contract);
		return new ResponseEntity<String>("updated",HttpStatus.OK);
	}
}
