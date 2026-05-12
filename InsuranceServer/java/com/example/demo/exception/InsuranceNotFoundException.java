package com.example.demo.exception;

public class InsuranceNotFoundException extends RuntimeException{
	public InsuranceNotFoundException(String message) {
		super(message);
	}
}
