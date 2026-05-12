package com.example.demo.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.entity.InsuranceEntity;
import com.example.demo.exception.InsuranceNotFoundException;
import com.example.demo.repository.InsuranceRepository;

@Service
public class InsuranceServiceImplementation implements InsuranceServiceInterface {
	
	 @Autowired
	private InsuranceRepository insuranceRepo;
	
	
	
   public InsuranceEntity buyInsuranceService(InsuranceEntity insuranceEntity) {
		insuranceEntity.setIsactive(true);
		insuranceEntity.setInsuranceIssueDate(LocalDate.now());
		insuranceEntity.setInsuranceExpiryDate(LocalDate.now().plusYears(1));
       return insuranceRepo.save(insuranceEntity);
   }
	
	public InsuranceEntity renewInsuranceService(int insuranceId) {
        Optional<InsuranceEntity> existingInsuranceOpt = insuranceRepo.findById(insuranceId);
        if (existingInsuranceOpt.isEmpty()) {
            throw new InsuranceNotFoundException("Insurance with ID " + insuranceId + " not found");
        }

        InsuranceEntity existingInsurance = existingInsuranceOpt.get();

        // Renew insurance: Update expiry date and ensure active status
        existingInsurance.setInsuranceExpiryDate(existingInsurance.getInsuranceExpiryDate().plusYears(1));
        existingInsurance.setIsactive(true);

        return insuranceRepo.save(existingInsurance);
        
	}
	
	public Optional<InsuranceEntity> insuranceWithPolicyId(int policyId) {
        Optional<InsuranceEntity> existingInsuranceOpt = insuranceRepo.findById(policyId);
        if (existingInsuranceOpt.isEmpty()) {
            throw new InsuranceNotFoundException("Insurance with ID " + policyId + " not found");
        }
        return existingInsuranceOpt;
        
	}
	
	
	
	public void deleteInsuranceService(int insuranceId) {
        Optional<InsuranceEntity> existingInsuranceOpt = insuranceRepo.findById(insuranceId);
        if (existingInsuranceOpt.isEmpty()) {
            throw new RuntimeException("Insurance with ID " + insuranceId + " not found");
        }

        InsuranceEntity existingInsurance = existingInsuranceOpt.get();

        // Mark the insurance as inactive
        existingInsurance.setIsactive(false);

        insuranceRepo.save(existingInsurance);
    }

}
