package com.aht.service;

import java.util.List;

import com.aht.entities.Contract;

public interface ContractService {

	public Contract findOne(Long id) ;
	public List<Contract> findAll() ;
	public Contract createContract(Contract contract) ;
	public void deleteContract(Long id);
	public void updateContract(Contract contract) ;

}
