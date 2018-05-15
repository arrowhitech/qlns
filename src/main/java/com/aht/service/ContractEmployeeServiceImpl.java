package com.aht.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aht.entities.ContractEmployee;
import com.aht.repository.ContractEmployeeRepository;

@Service
public class ContractEmployeeServiceImpl implements ContractEmployeeService{

	@Autowired
	private ContractEmployeeRepository contractEmployeeRepository;
	
	public ContractEmployee findOne(Long id) {
		return contractEmployeeRepository.getOne(id);
	}
	public List<ContractEmployee> findAll() {
		
		return contractEmployeeRepository.findAll();
	}	
	public ContractEmployee createContractEmployee(ContractEmployee contractEmployee) {
		return contractEmployeeRepository.save(contractEmployee);
	}
	public void deleteContractEmployee(Long id) {
		contractEmployeeRepository.deleteById(id);
	}
	public void updateContractEmployee(ContractEmployee contractEmployee) {
		contractEmployeeRepository.save(contractEmployee);
	}
}
