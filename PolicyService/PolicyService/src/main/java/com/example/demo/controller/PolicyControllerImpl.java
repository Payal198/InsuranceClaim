package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.PolicyEntity;
import com.example.demo.exception.ControllerException;
import com.example.demo.service.PolicyService;

import jakarta.validation.Valid;

@RestController
public class PolicyControllerImpl {
	
	@Autowired
	private PolicyService policyService;
	
	@GetMapping("/policy")
	public ResponseEntity<?> getAllPolicies(){
		return ResponseEntity.ok(this.policyService.getAllPolicies());
	}
	
	@GetMapping("policy/{id}")
	public ResponseEntity<?> getPolicyById(@PathVariable("id") Integer pid){
		try {
			return new ResponseEntity<PolicyEntity>(policyService.getPolicyById(pid),HttpStatus.OK);
		}
		catch(Exception e) {
			ControllerException controllerException = new ControllerException(e.getMessage()+" "+e.getCause());
			return new ResponseEntity<ControllerException>(controllerException, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/addPolicy")
	public ResponseEntity<?> addACustomer(@Valid @RequestBody PolicyEntity newPolicy){
		try {
			policyService.createPolicy(newPolicy);
			return ResponseEntity.status(HttpStatus.CREATED).body("New Policy Successfully Added.....");
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}
	
	@PutMapping("/modifyPolicy")
	public ResponseEntity<?> updateCustomer(@RequestBody PolicyEntity policyModify){
		try {
			policyService.updatePolicyDetails(policyModify.getPolicyId(), policyModify.getPolicyDuration(), policyModify.getPolicyCoverageType(), policyModify.getPremiumAmount(), policyModify.getPaymentFrequency(), policyModify.getTotalClaim());
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Policy Successfully modify...");
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/deletePolicy/{id}")
	public ResponseEntity<?> deletePolicy(@PathVariable("id") int pid){
		try {
			boolean isDelete = policyService.deletePolicy(pid);
			if(isDelete==true) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Policy deleted successfully.");
			}
			else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Policy Not Found.");
			}
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occured while deleting the customer"+e.getMessage());
		}

	}
}
