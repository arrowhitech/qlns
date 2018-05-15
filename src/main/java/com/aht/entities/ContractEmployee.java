package com.aht.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class ContractEmployee {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Column
	@Temporal(TemporalType.DATE)
	private Date endDate;
	@Column
	private int status;
	
	@ManyToOne
	@JoinColumn(name="idContract")
	private Contract contract;
	
	@ManyToOne
	@JoinColumn(name="idEmploy")
	private Employee employee;
	
	public ContractEmployee(Date startDate, Date endDate, int status,Contract contract, Employee employee) {
		
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.contract = contract;
		this.employee = employee;
	}

	public ContractEmployee() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
	public Contract getContract() {
		return contract;
	}
	
	public void setContract(Contract contract) {
		this.contract = contract;
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	
	
	
}
