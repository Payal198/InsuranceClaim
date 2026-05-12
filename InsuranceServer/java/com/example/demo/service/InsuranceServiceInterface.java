package com.example.demo.service;

import com.example.demo.entity.InsuranceEntity;

public interface InsuranceServiceInterface {
	
	 InsuranceEntity buyInsuranceService(InsuranceEntity insuranceEntity);
	 
	 InsuranceEntity renewInsuranceService(int insuranceId);
	 
	 void deleteInsuranceService(int insuranceId);
	 
  
	
}
