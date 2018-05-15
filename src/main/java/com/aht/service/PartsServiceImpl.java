package com.aht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.aht.entities.Parts;
import com.aht.repository.PartsRepository;

@Service
public class PartsServiceImpl implements PartsService{

	@Autowired
	private PartsRepository partsRepository;
	
	public Parts findOne(Long id) {
		return partsRepository.getOne(id);
	}
	public List<Parts> findAll() {
		
		return partsRepository.findAll();
	}	
	public Parts createPart(Parts parts) {
		return partsRepository.save(parts);
	}
	public void deletePart(Long id) {
		 partsRepository.deleteById(id);
	}
	public void updateParts(Parts parts) {
		partsRepository.save(parts);
	}



}
