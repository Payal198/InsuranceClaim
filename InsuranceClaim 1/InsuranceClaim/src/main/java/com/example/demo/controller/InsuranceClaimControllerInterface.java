package com.example.demo.controller;
import org.springframework.http.ResponseEntity;

import com.example.demo.entity.InsuranceClaimEntity;

public interface InsuranceClaimControllerInterface {
	ResponseEntity<?> submitClaim(InsuranceClaimEntity claim);

    ResponseEntity<?>getUserClaims();

    ResponseEntity<?>getClaimDetails(int claimId);

    ResponseEntity<Double>calculateClaimAmount(int claimId);

	ResponseEntity<?> updateClaimStatus(int claimId, InsuranceClaimEntity updateClaim);
}