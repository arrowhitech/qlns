package com.aht.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aht.entities.Training;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long>{

}
