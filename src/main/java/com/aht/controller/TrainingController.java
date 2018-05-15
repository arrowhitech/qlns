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

import com.aht.entities.Training;
import com.aht.service.TrainingService;




@RestController
public class TrainingController {


	
	@Autowired private TrainingService trainingService;
	

	@GetMapping("/training")
	public ResponseEntity<List<Training>> getAll(){
		
		return new ResponseEntity<List<Training>>(trainingService.findAll(), HttpStatus.OK);
	}
	
	
	@GetMapping("/trainings/{id}")
	public ResponseEntity<Training> getOne(@PathParam(value = "id") Long id){
		return new ResponseEntity<Training>(trainingService.findOne(id),HttpStatus.OK);
	}
	
	@PostMapping("/trainings")
	public ResponseEntity<String> create(@RequestBody Training training){
		
		System.out.println("huhuhuhu"+training);
		trainingService.createTraining(training);
		return new ResponseEntity<String>("created!",HttpStatus.OK);
	}

	@DeleteMapping("/trainings/{id}")
	public ResponseEntity<String> delete(@PathParam(value = "id") Long id){
		trainingService.deleteTraining(id);
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	}
	@PutMapping("/trainings")
	public ResponseEntity<String> update(@RequestBody Training training){
		trainingService.updateTraining(training);
		return new ResponseEntity<String>("updated",HttpStatus.OK);
	}
}
