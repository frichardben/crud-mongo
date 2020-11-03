package com.policy.policy.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.policy.policy.models.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String>{

}
