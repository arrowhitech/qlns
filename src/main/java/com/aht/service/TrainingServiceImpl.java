package com.aht.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aht.entities.Training;
import com.aht.repository.TrainingRepository;

@Service
public class TrainingServiceImpl implements TrainingService{

	@Autowired
	private TrainingRepository trainingRepository;
	
	public Training findOne(Long id) {
		return trainingRepository.getOne(id);
	}
	public List<Training> findAll() {
		
		return trainingRepository.findAll();
	}	
	public Training createTraining(Training training) {
		return trainingRepository.save(training);
	}
	public void deleteTraining(Long id) {
		trainingRepository.deleteById(id);
	}
	public void updateTraining(Training training) {
		trainingRepository.save(training);
	}
}
