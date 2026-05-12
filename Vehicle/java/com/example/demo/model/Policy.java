package com.example.demo.model;

public class Policy {
	private int policyId;
	private int policyDuration;
	private String policyCoverageType;
	private double premiumAmount;
	private String paymentFrequency;
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
	

}
