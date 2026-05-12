package com.example.demo.entity;

import org.springframework.stereotype.Component;
 
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
 
@Component
@Entity
@Table(name="policy_table")
public class PolicyEntity {
	@Id
	@NotNull(message = "Policy ID cannot be null")
	@Positive(message = "Policy ID must be a positive number")
	private int policyId;
	
	@NotNull(message = "Policy duration cannot be null")
    @Min(value = 1, message = "Policy duration must be at least 1 year")
	private int policyDuration;
	
	@NotBlank(message = "Policy coverage type cannot be empty")
	private String policyCoverageType;
	
	@NotNull(message = "Premium amount cannot be null")
    @Positive(message = "Premium amount must be a positive number")
	private double premiumAmount;
	
	@NotBlank(message = "Payment frequency cannot be empty")
	private String paymentFrequency;
	
	@NotNull(message = "Total claim cannot be null")
	@Positive(message = "Total claim must be a positive number")
	private double totalClaim;
	
	
	
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	public int getPolicyDuration() {
		return policyDuration;
	}
	public void setPolicyDuration(int policyDuration) {
		this.policyDuration = policyDuration;
	}
	public String getPolicyCoverageType() {
		return policyCoverageType;
	}
	public void setPolicyCoverageType(String policyCoverageType) {
		this.policyCoverageType = policyCoverageType;
	}
	public double getPremiumAmount() {
		return premiumAmount;
	}
	public void setPremiumAmount(double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}
	public String getPaymentFrequency() {
		return paymentFrequency;
	}
	public void setPaymentFrequency(String paymentFrequency) {
		this.paymentFrequency = paymentFrequency;
	}
	public double getTotalClaim() {
		return totalClaim;
	}
	public void setTotalClaim(double totalClaim) {
		this.totalClaim = totalClaim;
	}

	public PolicyEntity() {
		super();
	}
}