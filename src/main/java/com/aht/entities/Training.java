package com.aht.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Training {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column
	private String traningCode;
	@Column
	private String traningName;
	@Column
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Column
	@Temporal(TemporalType.DATE)
	private Date endDate;
	@Column
	private int status;
	
	@OneToMany(mappedBy="training")
	private List<TrainingEmployee> trainingEmployees;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTraningCode() {
		return traningCode;
	}

	public void setTraningCode(String traningCode) {
		this.traningCode = traningCode;
	}

	public String getTraningName() {
		return traningName;
	}

	public void setTraningName(String traningName) {
		this.traningName = traningName;
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

	@JsonIgnore
	public List<TrainingEmployee> getTrainingEmployees() {
		return trainingEmployees;
	}

	public void setTrainingEmployees(List<TrainingEmployee> trainingEmployees) {
		this.trainingEmployees = trainingEmployees;
	}

	public Training() {
		
	}

	public Training(String traningCode, String traningName, Date startDate, Date endDate, int status) {
	
		this.traningCode = traningCode;
		this.traningName = traningName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
	}
	
	
	
}
