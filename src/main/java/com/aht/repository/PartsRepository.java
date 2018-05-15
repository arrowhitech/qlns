package com.aht.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aht.entities.Parts;

@Repository
public interface PartsRepository  extends JpaRepository<Parts, Long>{

}
