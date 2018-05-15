package com.aht.service;

import java.util.List;

import com.aht.entities.Training;

public interface TrainingService {
	public Training findOne(Long id);

	public List<Training> findAll();

	public Training createTraining(Training training);

	public void deleteTraining(Long id);

	public void updateTraining(Training training);
}
