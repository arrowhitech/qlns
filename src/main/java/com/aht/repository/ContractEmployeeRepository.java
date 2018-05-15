package com.aht.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aht.entities.ContractEmployee;

@Repository
public interface ContractEmployeeRepository extends JpaRepository<ContractEmployee, Long> {

}
