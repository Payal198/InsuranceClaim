package com.example.demo.model;

import java.time.LocalDate;

public class Insurance {
	private Integer insuranceId;
	private LocalDate insuranceIssueDate;
	private LocalDate insuranceExpiryDate;
	private Double insurancePremiumAmount;
	private Double insuranceCoverageAmount;
	private String renewalFrequency;
	private boolean isactive;
	public Integer getInsuranceId() {
		return insuranceId;
	}
	public void setInsuranceId(Integer insuranceId) {
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
	public Double getInsurancePremiumAmount() {
		return insurancePremiumAmount;
	}
	public void setInsurancePremiumAmount(Double insurancePremiumAmount) {
		this.insurancePremiumAmount = insurancePremiumAmount;
	}
	public Double getInsuranceCoverageAmount() {
		return insuranceCoverageAmount;
	}
	public void setInsuranceCoverageAmount(Double insuranceCoverageAmount) {
		this.insuranceCoverageAmount = insuranceCoverageAmount;
	}
	public String getRenewalFrequency() {
		return renewalFrequency;
	}
	public void setRenewalFrequency(String renewalFrequency) {
		this.renewalFrequency = renewalFrequency;
	}
	public boolean isIsactive() {
		return isactive;
	}
	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}
	

}
