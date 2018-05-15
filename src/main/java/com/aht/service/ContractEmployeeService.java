package com.aht.service;

import java.util.List;

import com.aht.entities.ContractEmployee;

public interface ContractEmployeeService {
	public ContractEmployee findOne(Long id) ;
	public List<ContractEmployee> findAll() ;
	public ContractEmployee createContractEmployee(ContractEmployee contractEmployee) ;
	public void deleteContractEmployee(Long id) ;
	public void updateContractEmployee(ContractEmployee contractEmployee) ;
}
