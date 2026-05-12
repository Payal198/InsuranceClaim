package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.InsuranceClaimEntity;
import com.example.demo.repository.InsuranceClaimRepository;
import com.example.demo.security.EntityNotFoundException;
import com.example.demo.security.InvalidClaimAmountException;
@Service
public class InsuranceClaimServiceImpl implements InsuranceClaimServiceInterface {
	  	@Autowired
	    private InsuranceClaimRepository claimRepository;
	    // Method to submit a new claim by saving it to the repository
	    @Override
	    public void submitClaim(InsuranceClaimEntity claim) {
	        claimRepository.save(claim);  // Save claim to the database
	    }

	    // Method to retrieve all claims from the database
	    @Override
	    public List<InsuranceClaimEntity> getAllUserClaims() {
	        List<InsuranceClaimEntity> claimList = new ArrayList<>();  
	        
	        // Iterating over all claims and adding them to the list
	        claimRepository.findAll().forEach(c -> claimList.add(c));  
	        return claimList;  // Return the list of claims
	    }

	    // Method to get claim details based on claim ID
	    @Override
	    public InsuranceClaimEntity getClaimDetails(int claimId) {
	        Optional<InsuranceClaimEntity> claim = claimRepository.findById(claimId);
	        
	        if (!claim.isPresent()) {
	           throw new EntityNotFoundException("Claim with ID " + claimId + " not found.");
	        }
	        return claim.get(); 
	    }
	    //Method to update the claim status based on the current status
	    @Override
	    public InsuranceClaimEntity updateClaimStatus(int claimId) {
	        Optional<InsuranceClaimEntity> claim = claimRepository.findById(claimId);
	        if (!claim.isPresent()) {
	           throw new EntityNotFoundException("Claim with ID " + claimId + " not found.");
	        }
	        if (claim.isPresent()) {
	            InsuranceClaimEntity claimEntity = claim.get();
	            String currentStatus = claimEntity.getClaimStatus();
	            //Update the claim status based on the current status
	            if ("Pending".equals(currentStatus)){	
	                claimEntity.setClaimStatus("Approved");
	            } else if ("Approved".equals(currentStatus)) {
	                claimEntity.setClaimStatus("Closed");
	            } else {
	                claimEntity.setClaimStatus("Rejected");
	            }
	            return claimRepository.save(claimEntity);  // Save and return updated claim
	        } else {
	            return null;  // Return null if claim with the provided ID does not exist
	        }
	    }

	    // Method to calculate the claim amount after applying severity multiplier, deductible, and policy limit
	    @Override
	    public double calculateClaimAmount(InsuranceClaimEntity claim) {
	        double baseAmount = claim.getClaimAmount();  // Get base claim amount
	        
	        // Calculate the severity multiplier based on the accident severity
	        double severityMultiplier = getSeverityMultiplier(claim.getAccidentSeverity());
	        double adjustedAmount = baseAmount * severityMultiplier;  // Apply severity multiplier to the base amount

	        double deductible = claim.getPolicyDeductible();  // Get the deductible
	        adjustedAmount -= deductible;  // Subtract deductible from the adjusted amount

	        double policyLimit = claim.getPolicyLimit();  // Get the policy limit	        
	        // Ensure the claim amount does not exceed the policy limit
	        if (adjustedAmount > policyLimit) {
	            adjustedAmount = policyLimit;
	        }
	        if (adjustedAmount < 0) {
	            throw new InvalidClaimAmountException("Claim amount cannot be negative.");
	        }
	        if (adjustedAmount > claim.getPolicyLimit()) {
	            throw new InvalidClaimAmountException("Claim amount exceeds policy limit.");
	        }
	        return Math.max(adjustedAmount, 0);  // Ensure the claim amount is not negative
	    }

	    // Method to determine the severity multiplier based on the accident severity
	    public double getSeverityMultiplier(String accidentSeverity) {
	        switch (accidentSeverity) {
	            case "Low":
	                return 1.0;  // No multiplier for low severity
	            case "Moderate":
	                return 1.5;  // 1.5x multiplier for moderate severity
	            case "High":
	                return 2.0;  // 2x multiplier for high severity
	            default:
	                return 1.0;  // Default multiplier is 1.0 if the severity is not recognized
	        }
	    }
	}
