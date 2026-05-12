package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
 
import com.example.demo.entity.PolicyEntity;
import com.example.demo.repository.PolicyRepository;


@SpringBootTest
public class PolicyRepositoryTests {

	
	@Autowired
	PolicyRepository policyRepository;
	
	@Test
	void createPolicyTest() {
		
		
		PolicyEntity policyEntity = new PolicyEntity();
		policyEntity.setPolicyId(101); policyEntity.setPolicyDuration(1);
		policyEntity.setPolicyCoverageType("Liability");
		policyEntity.setPremiumAmount(2000);
		policyEntity.setPaymentFrequency("Monthly");
		policyEntity.setTotalClaim(200000); policyRepository.save(policyEntity);
		
		
		PolicyEntity policyEntity1 = new PolicyEntity();
		policyEntity1.setPolicyId(102);
		policyEntity1.setPolicyDuration(1);
		policyEntity1.setPolicyCoverageType("Medical");
		policyEntity1.setPremiumAmount(3000);
		policyEntity1.setPaymentFrequency("Monthly");
		policyEntity1.setTotalClaim(300000);
		policyRepository.save(policyEntity1);
		
		PolicyEntity policyEntity2 = new PolicyEntity();
		policyEntity2.setPolicyId(102);
		policyEntity2.setPolicyDuration(1);
		policyEntity2.setPolicyCoverageType("Physical Damage");
		policyEntity2.setPremiumAmount(1000);
		policyEntity2.setPaymentFrequency("Monthly");
		policyEntity2.setTotalClaim(100000);
		policyRepository.save(policyEntity2);
		
		PolicyEntity policyEntity3 = new PolicyEntity();
		policyEntity3.setPolicyId(201);
		policyEntity3.setPolicyDuration(2);
		policyEntity3.setPolicyCoverageType("Liability");
		policyEntity3.setPremiumAmount(1500);
		policyEntity3.setPaymentFrequency("Monthly");
		policyEntity3.setTotalClaim(300000);
		policyRepository.save(policyEntity3);
		
		PolicyEntity policyEntity4 = new PolicyEntity();
		policyEntity4.setPolicyId(202);
		policyEntity4.setPolicyDuration(2);
		policyEntity4.setPolicyCoverageType("Medical");
		policyEntity4.setPremiumAmount(8000);
		policyEntity4.setPaymentFrequency("Quartly");
		policyEntity4.setTotalClaim(400000);
		policyRepository.save(policyEntity4);
		
		PolicyEntity policyEntity5 = new PolicyEntity();
		policyEntity5.setPolicyId(203);
		policyEntity5.setPolicyDuration(2);
		policyEntity5.setPolicyCoverageType("Physical Damage");
		policyEntity5.setPremiumAmount(6000);
		policyEntity5.setPaymentFrequency("Quartly");
		policyEntity5.setTotalClaim(300000);
		policyRepository.save(policyEntity5);
		
		
	}
	
	
}