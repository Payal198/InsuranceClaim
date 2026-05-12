package com.example.demo.entity;

import java.time.LocalDate;

import org.springframework.stereotype.Component;
import jakarta.validation.constraints.*;
import jakarta.persistence.*;


@Component
@Entity
@Table(name="insurance_table")
public class InsuranceEntity {
	
	@Id
	@NotNull(message = "Insurance ID cannot be null")
    @Positive(message = "Insurance ID must be positive")
	
	private Integer insuranceId;
	
	@NotNull(message = "Issue date cannot be null")
	private LocalDate insuranceIssueDate;
	
	@NotNull(message = "Expiry date cannot be null")
	private LocalDate insuranceExpiryDate;
	
	@NotNull(message = "Premium amount cannot be null")
    //@DecimalMin(value = "0.0", inclusive = false, message = "Premium amount must be greater than zero")
    //@Digits(integer = 10, fraction = 2, message = "Premium amount must be a valid decimal value")
	private Double insurancePremiumAmount;
	
	
	 @NotNull(message = "Coverage amount cannot be null")
   // @DecimalMin(value = "0.0", inclusive = false, message = "Coverage amount must be greater than zero")
    //@Digits(integer = 8, fraction = 2, message = "Coverage amount must be a valid decimal value")
	private Double insuranceCoverageAmount;
	 
	
	private String renewalFrequency;
	private boolean isactive;
	
	@Column(name="fk_policy_id")
	int policyId;
//	PolicyEntity policyEntity;
	
	

	//constructor of insurance master
	public InsuranceEntity() {
		super();
		
	}
	
	public int getPolicyId() {
		return policyId;
	}

	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}

	//getters and setters
	public int getInsuranceId() {
		return insuranceId;
	}
	public void setInsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
	}
	public LocalDate getInsuranceIssueDate() {
		return insuranceIssueDate;
	}
	public void setInsuranceIssueDate(LocalDate insuranceIssueDate) {
		this.insuranceIssueDate = insuranceIssueDate;
	}
	public LocalDate getInsuranceExpiryDate() {
		return insuranceExpiryDate;
	}
	public void setInsuranceExpiryDate(LocalDate insuranceExpiryDate) {
		this.insuranceExpiryDate = insuranceExpiryDate;
	}
	public boolean getIsactive() {
		return isactive;
	}
	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}
	public double getInsurancePremiumAmount() {
		return insurancePremiumAmount;
	}
	public void setInsurancePremiumAmount(double insurancePremiumAmount) {
		this.insurancePremiumAmount = insurancePremiumAmount;
	}
	public double getInsuranceCoverageAmount() {
		return insuranceCoverageAmount;
	}
	public void setInsuranceCoverageAmount(double insuranceCoverageAmount) {
		this.insuranceCoverageAmount = insuranceCoverageAmount;
	}
	public String getRenewalFrequency() {
		return renewalFrequency;
	}
	public void setRenewalFrequency(String renewalFrequency) {
		this.renewalFrequency = renewalFrequency;
	}
	
	
	
	
	
}