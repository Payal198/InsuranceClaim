package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.PolicyEntity;

@Service
public interface PolicyService {
	
	PolicyEntity createPolicy(PolicyEntity policy);
    List<PolicyEntity> getAllPolicies();
    PolicyEntity getPolicyById(Integer id);
    PolicyEntity updatePolicyDetails(Integer id, Integer duration,String coverage,double premium,String frequency,double claim);
    boolean deletePolicy(Integer id);
	

}
