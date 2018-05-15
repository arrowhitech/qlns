package com.aht.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Contract {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column
	private String contractCode;
	@Column
	private int contractType;
	
	@OneToMany(mappedBy="contract")
	private List<ContractEmployee> contractEmployees;

	public Contract(String contractCode, int contractType) {
		
		this.contractCode = contractCode;
		this.contractType = contractType;
	}

	public Contract() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContractCode() {
		return contractCode;
	}

	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}

	public int getContractType() {
		return contractType;
	}

	public void setContractType(int contractType) {
		this.contractType = contractType;
	}



	
}
