package com.aht.service;

import java.util.List;

import com.aht.entities.TrainingEmployee;

public interface TrainingEmployeeService {
	public TrainingEmployee findOne(Long id);

	public List<TrainingEmployee> findAll();

	public TrainingEmployee createTrainingEmployee(TrainingEmployee trainingEmployee);

	public void deleteTrainingEmployee(Long id);

	public void updateTrainingEmployee(TrainingEmployee trainingEmployee);
}
