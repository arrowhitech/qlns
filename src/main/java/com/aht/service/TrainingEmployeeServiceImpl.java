package com.aht.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aht.entities.TrainingEmployee;
import com.aht.repository.EmployeeTrainingRepository;

@Service
public class TrainingEmployeeServiceImpl implements TrainingEmployeeService {

	@Autowired
	private EmployeeTrainingRepository trainingEmployeeRepository;
	
	public TrainingEmployee findOne(Long id) {
		return trainingEmployeeRepository.getOne(id);
	}
	public List<TrainingEmployee> findAll() {
		
		return trainingEmployeeRepository.findAll();
	}	
	public TrainingEmployee createTrainingEmployee(TrainingEmployee trainingEmployee) {
		return trainingEmployeeRepository.save(trainingEmployee);
	}
	public void deleteTrainingEmployee(Long id) {
		trainingEmployeeRepository.deleteById(id);
	}
	public void updateTrainingEmployee(TrainingEmployee trainingEmployee) {
		trainingEmployeeRepository.save(trainingEmployee);
	}
	
	
	


}
