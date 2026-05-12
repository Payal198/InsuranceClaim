package com.example.demo.controller;

import org.springframework.http.ResponseEntity;

import com.example.demo.entity.InsuranceEntity;

public interface InsuranceControllerInterface {

	
	ResponseEntity<InsuranceEntity> buyInsurance();
	
	ResponseEntity<InsuranceEntity> renewInsurance();
	
	ResponseEntity<String> deleteInsurance();
}
