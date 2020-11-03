package com.policy.policy.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.policy.policy.models.Policy;

public interface PolicyRepository extends MongoRepository<Policy, String> {

}
