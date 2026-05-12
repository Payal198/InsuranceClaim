package com.example.demo;

import java.util.Iterator;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.PolicyEntity;
import com.example.demo.repository.PolicyRepository;

@SpringBootTest
public class PolicyRepositoryTestCases {
	
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
		policyEntity2.setPolicyId(103);
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
	
	@Test
	void updatePolicyDetails() {
		Optional<PolicyEntity> box = policyRepository.findById(301);
		if(box.isPresent())
		{
			PolicyEntity p = box.get();
			System.out.println(p.getPolicyId()+":"+p.getPolicyDuration()+":"+p.getPolicyCoverageType()+":"+p.getPremiumAmount()+":"+p.getPaymentFrequency()+":"+p.getTotalClaim());
			p.setPolicyDuration(2);
			p.setPolicyCoverageType("Medical");
			p.setPremiumAmount(10000);
			p.setPaymentFrequency("Yearly");
			p.setTotalClaim(500000);
			
			policyRepository.save(p);
			
			System.out.println(p.getPolicyId()+":"+p.getPolicyDuration()+":"+p.getPolicyCoverageType()+":"+p.getPremiumAmount()+":"+p.getPaymentFrequency()+":"+p.getTotalClaim());
			
		}
	}
	
	@Test
	public void showpolicyTest()
	{
		Optional<PolicyEntity> box = policyRepository.findById(201);
		if(box.isPresent())
		{
			PolicyEntity policy = box.get();
			System.out.println(policy.getPolicyId()+":"+policy.getPolicyDuration()+":"+policy.getPolicyCoverageType()+":"+policy.getPremiumAmount()+":"+policy.getPaymentFrequency()+":"+policy.getTotalClaim());
			
		}
		
	}
	
	@Test
	public void showAllPoliciesTest()
	{
		Iterable<PolicyEntity> iterable = policyRepository.findAll();
		Iterator<PolicyEntity> iterator = iterable.iterator();
		while(iterator.hasNext())
		{
			PolicyEntity policy = iterator.next();
			System.out.println(policy.getPolicyId()+":"+policy.getPolicyDuration()+":"+policy.getPolicyCoverageType()+":"+policy.getPremiumAmount()+":"+policy.getPaymentFrequency()+":"+policy.getTotalClaim());
			
		}
	}
	
	@Test
	void deletePolicyTest() {
		Optional<PolicyEntity> box = policyRepository.findById(302);
		if(box.isPresent())
		{
			PolicyEntity policy = box.get();
			System.out.println(policy.getPolicyId()+":"+policy.getPolicyDuration()+":"+policy.getPolicyCoverageType()+":"+policy.getPremiumAmount()+":"+policy.getPaymentFrequency()+":"+policy.getTotalClaim());
			policyRepository.delete(policy);
		}
	}
	
}
