package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.exception.InsuranceNotFoundException;
import com.example.demo.exception.InsuranceWithPolicyNotFound;

import org.springframework.web.bind.MethodArgumentNotValidException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(InsuranceNotFoundException.class)
    public ResponseEntity<String> insuranceNotFoundException(InsuranceNotFoundException ex){
 	   return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(InsuranceWithPolicyNotFound.class)
    public ResponseEntity<String> insuranceWithPolicyNotFoundException(InsuranceWithPolicyNotFound ex){
 	   return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleValidationExceptions(MethodArgumentNotValidException ex){
    	System.out.println("handleValidationException() invoked.......");
    	Map<String,String> errorsMaps=new HashMap<>();
    	ex.getBindingResult().getAllErrors().forEach(
    			(error) ->
    			{String fieldName=((FieldError) error).getField();
    			String fieldMessage=error.getDefaultMessage();
    			errorsMaps.put(fieldName, fieldMessage);
    		
    	});
    	
    	return errorsMaps;
    }
	
//	@ExceptionHandler(InsuranceNotFoundException.class)
//    public ResponseEntity<String> insuranceNotFoundException(InsuranceNotFoundException userAlreadyExistsException){
// 	   return new ResponseEntity<String>("This user already exists in the server..", HttpStatus.NOT_FOUND);
//    }
	
	
}
