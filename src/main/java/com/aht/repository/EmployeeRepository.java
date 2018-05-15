package com.aht.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aht.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
