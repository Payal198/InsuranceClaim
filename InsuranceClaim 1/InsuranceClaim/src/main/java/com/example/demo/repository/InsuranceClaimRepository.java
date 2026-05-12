package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.InsuranceClaimEntity;
@Repository
public interface InsuranceClaimRepository extends CrudRepository<InsuranceClaimEntity,Integer>{

}
