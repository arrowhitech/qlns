package com.aht.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aht.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
