package com.aht.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class TrainingEmployee {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column
	
	private String result;

	@ManyToOne
	@JoinColumn(name = "idEmployee")
	private Employee employee;

	@ManyToOne
	@JoinColumn(name = "idTraining")
	private Training training;
	public TrainingEmployee() {

	}

	public TrainingEmployee(String result, Employee employee, Training training) {

		this.result = result;
		this.employee = employee;
		this.training = training;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Training getTraining() {
		return training;
	}

	public void setTraining(Training training) {
		this.training = training;
	}


}
