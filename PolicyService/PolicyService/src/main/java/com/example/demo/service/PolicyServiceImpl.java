package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PolicyEntity;
import com.example.demo.repository.PolicyRepository;

@Service
public class PolicyServiceImpl implements PolicyService {
	
	@Autowired
    private PolicyRepository policyRepository;

    @Override
    public PolicyEntity createPolicy(PolicyEntity policy) {
        return policyRepository.save(policy);
    }

    @Override
    public List<PolicyEntity> getAllPolicies() {
    	List<PolicyEntity> policyList = new ArrayList<>();
        policyRepository.findAll().forEach(e->{
        	policyList.add(e);
        });
        return policyList;
    }

    @Override
    public PolicyEntity getPolicyById(Integer id) {
        Optional<PolicyEntity> policyOptional = policyRepository.findById(id);
        return policyOptional.orElse(null); 
    }

   
    public PolicyEntity updatePolicyDetails(Integer id, Integer duration,String coverage,double premium,String frequency,double claim) {
    	 PolicyEntity updatedPolicy = new PolicyEntity();
    	if (policyRepository.existsById(id)) {
            
            updatedPolicy.setPolicyId(id); 
            updatedPolicy.setPolicyDuration(duration);
            updatedPolicy.setPolicyCoverageType(coverage);
            updatedPolicy.setPremiumAmount(premium);
            updatedPolicy.setPaymentFrequency(frequency);
            updatedPolicy.setTotalClaim(claim);
            return policyRepository.save(updatedPolicy);
        } else {
            return null; 
        }
    }

    @Override
    public boolean deletePolicy(Integer id) {
        if (policyRepository.existsById(id)) {
            policyRepository.deleteById(id);
            return true;
        } else {
            // Handle the case where the policy does not exist
        	return false;
        }
    }

}
