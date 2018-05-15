package com.aht.service;

import java.util.List;
import com.aht.entities.Parts;



public interface PartsService {
	
	public Parts findOne(Long id) ;
	public List<Parts> findAll() ;
	public Parts createPart(Parts parts) ;
	public void deletePart(Long id);
	public void updateParts(Parts parts) ;

}
