package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.InsuranceClaimEntity;

@Service
public interface InsuranceClaimServiceInterface {
	public void submitClaim(InsuranceClaimEntity claim);
	public List<InsuranceClaimEntity>getAllUserClaims ();
	public InsuranceClaimEntity  getClaimDetails(int claimId);
	public InsuranceClaimEntity updateClaimStatus(int claimId);
	public double calculateClaimAmount(InsuranceClaimEntity claim);
	public double getSeverityMultiplier(String accidentSeverity);
	
	
}
