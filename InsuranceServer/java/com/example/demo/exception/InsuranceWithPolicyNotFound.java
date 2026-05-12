package com.example.demo.exception;

public class InsuranceWithPolicyNotFound extends RuntimeException {
	public InsuranceWithPolicyNotFound(String message) {
		super(message);
	}
}
