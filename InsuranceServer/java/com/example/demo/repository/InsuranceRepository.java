package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.InsuranceEntity;

public interface InsuranceRepository extends CrudRepository<InsuranceEntity,Integer> {
	
}
