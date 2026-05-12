package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.InsuranceEntity;
import com.example.demo.exception.InsuranceNotFoundException;
import com.example.demo.exception.InsuranceWithPolicyNotFound;
import com.example.demo.repository.InsuranceRepository;
import com.example.demo.service.InsuranceServiceImplementation;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/insurance")
public class InsuranceControllerImplementation {
	
	@Autowired
	private InsuranceServiceImplementation insuranceServiceImpl;
	
	@Autowired
	InsuranceRepository insuranceRepository;
	
	@Autowired
    private RestTemplate restTemplate;
	
	@GetMapping("/all")
	public List<InsuranceEntity> getAllInsurance(){
		return (List<InsuranceEntity>) insuranceRepository.findAll();
	}
	
	@GetMapping("/insurance/{id}")
	public InsuranceEntity getInsuranceById(@Valid @PathVariable("id")int id) {
		return insuranceRepository.findById(id).orElseThrow(() -> new InsuranceNotFoundException("Insurance with this Id not found.."));
	}
		
	 
	@PostMapping("/buy")
    public ResponseEntity<InsuranceEntity> buyInsurance(@Valid @RequestBody InsuranceEntity insuranceMaster) {
		System.out.println("adding policy "+insuranceMaster.getPolicyId() + " for "+insuranceMaster.getInsuranceId());

		InsuranceEntity savedInsurance = insuranceServiceImpl.buyInsuranceService(insuranceMaster);
        return ResponseEntity.ok(savedInsurance);
    }
	
	@PutMapping("/renew/{insuranceId}")
    public ResponseEntity<InsuranceEntity> renewInsurance(@Valid @PathVariable int insuranceId) {
		InsuranceEntity renewedInsurance = insuranceServiceImpl.renewInsuranceService(insuranceId);
        return ResponseEntity.ok(renewedInsurance);
    }
	
	@GetMapping("/policy/{id}")
	public InsuranceEntity getInsuranceByPolicyId(@Valid @PathVariable("id")int id) {
		return insuranceRepository.findById(id).orElseThrow(() -> new InsuranceWithPolicyNotFound("Insurance with this Ploicy Id not found.."));
	}
	
	@DeleteMapping("/delete/{insuranceId}")
    public ResponseEntity<String> deleteInsurance(@Valid @PathVariable int insuranceId) {
        insuranceServiceImpl.deleteInsuranceService(insuranceId);
        return ResponseEntity.ok("Insurance with ID " + insuranceId + " has been marked as inactive.");
    }
	
	

}
