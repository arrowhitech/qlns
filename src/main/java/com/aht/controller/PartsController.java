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

import com.aht.entities.Parts;
import com.aht.service.PartsService;




@RestController
public class PartsController  {

	
	@Autowired 
	private PartsService partsService;
	

	@GetMapping("/parts")
	public ResponseEntity<List<Parts>> getAll(){
		
		return new ResponseEntity<List<Parts>>(partsService.findAll(), HttpStatus.OK);
	}
	
	
	@GetMapping("/parts/{id}")
	public ResponseEntity<Parts> getOne(@PathParam(value = "id") Long id){
		return new ResponseEntity<Parts>(partsService.findOne(id),HttpStatus.OK);
	}
	
	@PostMapping("/parts")
	public ResponseEntity<String> create(@RequestBody Parts parts){
		
	
		partsService.createPart(parts);
		return new ResponseEntity<String>("created!",HttpStatus.OK);
	}

	@DeleteMapping("/parts/{id}")
	public ResponseEntity<String> delete(@PathParam(value = "id") Long id){
		partsService.deletePart(id);
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	}
	@PutMapping("/parts")
	public ResponseEntity<String> update(@RequestBody Parts parts){
		partsService.updateParts(parts);
		return new ResponseEntity<String>("updated",HttpStatus.OK);
	}
}
