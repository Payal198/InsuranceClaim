package com.example.demo.entity;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Component
@Entity
@Table(name="Insurance_Claim_Entity")
public class InsuranceClaimEntity {
	 @Id  
	    @Min(1)  
	    @NotNull(message = "Claim Id cannot be null")  
	    private Integer claimId;  // Primary key for the insurance claim entity

	    private LocalDate accidentDate;  // Date of the accident

	    @NotNull(message = "Claim Date cannot be null")  
	    private LocalDate claimDate;  // Date when the claim was made

	    @Min(value = 1, message = "Accident Report Number should be greater than 0")  
	    private int accidentReportNumber;  // Report number of the accident

	    @Positive(message = "Claim Amount must be a positive value")  
	    private double claimAmount;  // Amount requested for the claim

	    @NotBlank(message = "Claim Status cannot be empty") 
	    @Size(max = 50, message = "Claim Status should not exceed 50 characters")  
	    private String claimStatus;  // Current status of the claim (e.g., "Pending", "Approved")

	    @Positive(message = "Severity Multiplier must be greater than 0")  
	    private double severityMultiplier;  // Multiplier based on the accident's severity (used in claim calculation)

	    @PositiveOrZero(message = "Policy Deductible must be zero or greater")   
	    private double policyDeductible;  // Deductible amount in the insurance policy

	    @PositiveOrZero(message = "Policy Limit must be zero or greater")  
	    private double policyLimit;  // Maximum limit for the claim according to the policy

	    @Pattern(regexp = "Low|Moderate|High", message = "Accident Severity must be one of the following: Low, Moderate, or High")  // Ensures the severity matches one of the allowed values
	    private String accidentSeverity;  // Describes the severity of the accident (e.g., "Low", "Moderate", "High")
	    
	    // Getters and Setters for all fields

	public String getAccidentSeverity() {
		return accidentSeverity;
	}
	public void setAccidentSeverity(String accidentSeverity) {
		this.accidentSeverity = accidentSeverity;
	}
	
	public double getSeverityMultiplier() {
		return severityMultiplier;
	}
	public void setSeverityMultiplier(double severityMultiplier) {
		this.severityMultiplier = severityMultiplier;
	}
	public double getPolicyDeductible() {
		return policyDeductible;
	}
	public void setPolicyDeductible(double policyDeductible) {
		this.policyDeductible = policyDeductible;
	}
	public double getPolicyLimit() {
		return policyLimit;
	}
	public void setPolicyLimit(double policyLimit) {
		this.policyLimit = policyLimit;
	}
	public Integer getClaimId() {
		return claimId;
	}
	public void setClaimId(Integer claimId) {
		this.claimId = claimId;
	}
	public LocalDate getAccidentDate() {
		return accidentDate;
	}
	public void setAccidentDate(LocalDate accidentDate) {
		this.accidentDate = accidentDate;
	}
	public LocalDate getClaimDate() {
		return claimDate;	}
	public void setClaimDate(LocalDate claimDate) {
		this.claimDate = claimDate;
	}
	public int getAccidentReportNumber() {
		return accidentReportNumber;
	}
	public void setAccidentReportNumber(int accidentReportNumber) {
		this.accidentReportNumber = accidentReportNumber;
	}
	public double getClaimAmount() {
		return claimAmount;
	}
	public void setClaimAmount(double d) {
		this.claimAmount = d;
	}
	public String getClaimStatus() {
		return claimStatus;
	}
	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}
	
	
	
}
