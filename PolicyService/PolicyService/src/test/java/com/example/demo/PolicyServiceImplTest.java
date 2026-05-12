package com.example.demo;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.PolicyEntity;
import com.example.demo.repository.PolicyRepository;
import com.example.demo.service.PolicyServiceImpl;

@SpringBootTest
public class PolicyServiceImplTest {
	
	@Mock
	PolicyRepository policyRepository;
	
	@InjectMocks
	PolicyServiceImpl policyService;
	
	@BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }
	
	private Optional<PolicyEntity> createPolicyStub() {
		PolicyEntity policy=new PolicyEntity();
		policy.setPolicyId(201);
		policy.setPolicyDuration(2);
		policy.setPolicyCoverageType("Medical");
		policy.setPremiumAmount(10000);
		policy.setPaymentFrequency("Yearly");
		policy.setTotalClaim(500000);
		
		return Optional.of(policy);
	}
	
	@Test
	void testGetPolicyById() {
		
		when(policyRepository.findById(201)).thenReturn(createPolicyStub());
		PolicyEntity policy = policyService.getPolicyById(201);
		Assertions.assertEquals(policy.getPolicyDuration(),2);
		System.out.println(policy.getPolicyId()+":"+policy.getPolicyDuration()+":"+policy.getPolicyCoverageType()+":"+policy.getPremiumAmount()+":"+policy.getPaymentFrequency()+":"+policy.getTotalClaim());
	}
	
}
