package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.PolicyEntity;

public interface PolicyRepository extends CrudRepository<PolicyEntity, Integer> {

}
