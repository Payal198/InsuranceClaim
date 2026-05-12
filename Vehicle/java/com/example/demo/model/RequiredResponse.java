package com.example.demo.model;

import com.example.demo.entity.VehicleEntity;

public class RequiredResponse {
	VehicleEntity vehicle;
	User user;
	Insurance insurance;
	InsuranceClaim insuranceClaim;
	Policy policy;
	
	public VehicleEntity getVehicle() {
		return vehicle;
	}
	public void setVehicle(VehicleEntity vehicle) {
		this.vehicle = vehicle;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Insurance getInsurance() {
		return insurance;
	}
	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}
	public InsuranceClaim getInsuranceClaim() {
		return insuranceClaim;
	}
	public void setInsuranceClaim(InsuranceClaim insuranceClaim) {
		this.insuranceClaim = insuranceClaim;
	}
	public Policy getPolicy() {
		return policy;
	}
	public void setPolicy(Policy policy) {
		this.policy = policy;
	}
	
	
	

}
