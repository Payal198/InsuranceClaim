package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.PolicyEntity;
import com.example.demo.service.PolicyService;

@SpringBootTest
public class PolicyServiceTest {
	
	@Autowired
	private PolicyService policyService;
	private PolicyEntity policy;
	
	@BeforeEach
	void setUp() {
		policy = new PolicyEntity();
		policy.setPolicyId(302); 
        policy.setPolicyDuration(2);
        policy.setPolicyCoverageType("Medical");
        policy.setPremiumAmount(30000);
        policy.setPaymentFrequency("Yearly");
        policy.setTotalClaim(500000);
	}
	
	@Test
	void testSaveCustomer() {
		policyService.createPolicy(policy);
	}

	@Test
	void testGetPolicyById() {
		policyService.createPolicy(policy);
		policyService.getPolicyById(policy.getPolicyId());
	}
	
	@Test
	void testGetAllPolicies() {
		Iterable<PolicyEntity> policies = policyService.getAllPolicies();
		policies.forEach(p->{
			System.out.println(p.getPolicyId()+p.getPolicyDuration()+p.getPolicyCoverageType()+p.getPremiumAmount()+p.getPaymentFrequency()+p.getTotalClaim());
		});
	}
	
	@Test
	void testUpdatePolicy() {
		policyService.createPolicy(policy);
		policy.setPolicyId(302);
		policy.setPolicyDuration(3);
		policy.setPolicyCoverageType("Medical");
		policy.setPremiumAmount(15000);
		policy.setPaymentFrequency("Half yearly");
		policy.setTotalClaim(800000);
		policyService.updatePolicyDetails(policy.getPolicyId(),policy.getPolicyDuration(),policy.getPolicyCoverageType(),policy.getPremiumAmount(),policy.getPaymentFrequency(),policy.getTotalClaim());
	}
	
	@Test
	void testDeletepolicy() {
		policyService.createPolicy(policy);
		policyService.deletePolicy(policy.getPolicyId());
	}
	
	
}
