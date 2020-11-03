package com.policy.policy.services;

import java.util.List;


import com.policy.policy.models.Customer;

public interface CustomerService {
	
	List<Customer> getCustomers();
	
	Customer getCustomerById(String id);
	
	Customer registerCustomer(Customer customer);
	
	Customer updateCustomer(Customer customer);
	
	void removeCustomer(String id);
	
}
