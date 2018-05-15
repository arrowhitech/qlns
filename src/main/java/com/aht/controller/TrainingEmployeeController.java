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

import com.aht.entities.TrainingEmployee;
import com.aht.service.TrainingEmployeeService;




@RestController
public class TrainingEmployeeController {


	@Autowired private TrainingEmployeeService trainingEmployeeService;
	

	@GetMapping("/trainingEmployees")
	public ResponseEntity<List<TrainingEmployee>> getAll(){
		
		return new ResponseEntity<List<TrainingEmployee>>(trainingEmployeeService.findAll(), HttpStatus.OK);
	}
	
	
	@GetMapping("/trainingEmployees/{id}")
	public ResponseEntity<TrainingEmployee> getOne(@PathParam(value = "id") Long id){
		return new ResponseEntity<TrainingEmployee>(trainingEmployeeService.findOne(id),HttpStatus.OK);
	}
	
	@PostMapping("/trainingEmployees")
	public ResponseEntity<String> create(@RequestBody TrainingEmployee trainingEmployee){
		

		trainingEmployeeService.createTrainingEmployee(trainingEmployee);
		return new ResponseEntity<String>("created!",HttpStatus.OK);
	}

	@DeleteMapping("/trainingEmployees/{id}")
	public ResponseEntity<String> delete(@PathParam(value = "id") Long id){
		trainingEmployeeService.deleteTrainingEmployee(id);
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	}
	@PutMapping("/trainingEmployees")
	public ResponseEntity<String> update(@RequestBody TrainingEmployee trainingEmployee){
		trainingEmployeeService.updateTrainingEmployee(trainingEmployee);
		return new ResponseEntity<String>("updated",HttpStatus.OK);
	}
}
