package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.InsuranceClaimEntity;
import com.example.demo.security.EntityNotFoundException;
import com.example.demo.service.InsuranceClaimServiceInterface;

import jakarta.validation.Valid;
@RestController
public class InsuranceClaimControllerImpl implements InsuranceClaimControllerInterface {
	 @Autowired
	    private InsuranceClaimServiceInterface insuranceClaimServiceInterface;

	    // Endpoint to submit a claim
	    @Override
	    @PostMapping("/submitClaim")
	    public ResponseEntity<?> submitClaim(@Valid @RequestBody InsuranceClaimEntity claim) {
	        // Call the service method to submit the claim
	        insuranceClaimServiceInterface.submitClaim(claim);
	        
	        // Return a success message with HTTP 200 OK status
	        return ResponseEntity.ok("Claim submitted successfully");
	    }

	    // Endpoint to retrieve all user claims
	    @Override
	    @GetMapping("/all")
	    public ResponseEntity<?> getUserClaims() {
	        // Fetch all claims from the service and return in response
	        return ResponseEntity.ok(this.insuranceClaimServiceInterface.getAllUserClaims());
	    }

	    // Endpoint to retrieve a claim's details by claim ID
	    @Override   
	    @GetMapping("/{claimId}")
	    public ResponseEntity<?> getClaimDetails(@PathVariable("claimId") int claimId) {
	    	try {
	            InsuranceClaimEntity claim = insuranceClaimServiceInterface.getClaimDetails(claimId);
	            return new ResponseEntity<>(claim, HttpStatus.OK);
	        } catch (EntityNotFoundException e) {
	            return new ResponseEntity<>("Claim not found: " + e.getMessage(), HttpStatus.NOT_FOUND);
	        } catch (Exception e) {
	            return new ResponseEntity<>("Internal server error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
//	        
	    }

	    // Endpoint to update the claim status by claim ID
	    @Override
	    @PutMapping("/{claimId}/status")
	    public ResponseEntity<?> updateClaimStatus(@PathVariable int claimId, @RequestBody InsuranceClaimEntity updateClaim) {
	    	  try {
	    	        insuranceClaimServiceInterface.updateClaimStatus(claimId);
	    	        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Claim modified successfully");
	    	    } catch (EntityNotFoundException e) {
	    	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	    	    } catch (Exception e) {
	    	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	    	    }
//	       
	    }

	    // Endpoint to calculate the claim amount based on the claim ID
	    @Override
	    @GetMapping("/{claimId}/calculate")
	    public ResponseEntity<Double> calculateClaimAmount(@PathVariable("claimId") int claimId) {
	        // Fetch the claim details by ID
	        InsuranceClaimEntity claim = insuranceClaimServiceInterface.getClaimDetails(claimId);
	        
	        // Calculate the claim amount using the service method
	        double calculatedAmount = insuranceClaimServiceInterface.calculateClaimAmount(claim);
	        
	        // Return the calculated claim amount in the response
	        return ResponseEntity.ok(calculatedAmount);
	    }
	}