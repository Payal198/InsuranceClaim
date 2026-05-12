package com.example.demo.model;

import java.time.LocalDate;

public class InsuranceClaim {
	private Integer claimId;
	private LocalDate accidentDate;
	private LocalDate claimDate;
	 private int accidentReportNumber;
	 private double claimAmount; 
	 private String claimStatus; 
	 private double severityMultiplier; 
	 private double policyDeductible;
	 private double policyLimit;
	 private String accidentSeverity;
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
		return claimDate;
	}
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
	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}
	public String getClaimStatus() {
		return claimStatus;
	}
	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
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
	public String getAccidentSeverity() {
		return accidentSeverity;
	}
	public void setAccidentSeverity(String accidentSeverity) {
		this.accidentSeverity = accidentSeverity;
	} 
	 

}
