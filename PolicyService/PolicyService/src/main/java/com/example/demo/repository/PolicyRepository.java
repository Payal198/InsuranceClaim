package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.PolicyEntity;

@Repository
public interface PolicyRepository extends CrudRepository<PolicyEntity, Integer> {

}
