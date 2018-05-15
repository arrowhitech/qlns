package com.aht.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aht.entities.Contract;
import com.aht.repository.ContractRepository;

@Service
public class ContractServiceImpl implements ContractService{

	@Autowired
	private ContractRepository contractRepository;
	
	public Contract findOne(Long id) {
		return contractRepository.getOne(id);
	}
	public List<Contract> findAll() {
		
		return contractRepository.findAll();
	}	
	public Contract createContract(Contract contract) {
		return contractRepository.save(contract);
	}
	public void deleteContract(Long id) {
		contractRepository.deleteById(id);
	}
	public void updateContract(Contract contract) {
		contractRepository.save(contract);
	}
}
