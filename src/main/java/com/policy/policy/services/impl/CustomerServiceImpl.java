package com.policy.policy.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.policy.policy.models.Customer;
import com.policy.policy.repositories.CustomerRepository;
import com.policy.policy.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> getCustomers() {
		
		return this.customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(String id) {
		
		return this.customerRepository.findById(id).get();
	}

	@Override
	public Customer registerCustomer(Customer customer) {
		
		return this.customerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		
		return this.customerRepository.save(customer);
	}

	@Override
	public void removeCustomer(String id) {
	
		this.customerRepository.deleteById(id);
	}

}
