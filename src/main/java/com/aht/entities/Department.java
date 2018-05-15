package com.aht.entities;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Long id;
	@Column
	private String name;
	
	@ManyToOne
	@JoinColumn(name="idParts")
	private Parts parts;

	@OneToMany(mappedBy="department")	
	private List<Employee> employees;
	public Department() {
		
	}
	public Department( String name,Parts parts) {
			
		this.name = name;
		this.parts = parts;
		
	}

	public Department(String name) {
		
		this.name = name;
	}



	public List<Employee> getEmployee() {
		return employees;
	}


	public void setEmployee(List<Employee> employee) {
		this.employees = employee;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public Parts getParts() {
		return parts;
	}


	public void setParts(Parts parts) {
		this.parts = parts;
	}




	
	
}
