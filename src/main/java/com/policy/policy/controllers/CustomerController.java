package com.policy.policy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.policy.policy.models.Customer;
import com.policy.policy.services.CustomerService;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public ResponseEntity<List<Customer>>All() {
		return ResponseEntity.ok(this.customerService.getCustomers());
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Customer> getById(@PathVariable(name = "id") Long id) {
		return ResponseEntity.ok(this.customerService.getCustomerById(id));
	}
	
	@PostMapping
	public ResponseEntity<Customer> register(@RequestBody Customer customer) {
		return ResponseEntity.ok(this.customerService.registerCustomer(customer));
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Customer> update(@PathVariable(name = "id") Long id ,@RequestBody Customer customer) {
		customer.setId(id);
		return ResponseEntity.ok(this.customerService.updateCustomer(customer));
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Integer> remove(@PathVariable(name = "id") Long id) {
		this.customerService.removeCustomer(id);
		return ResponseEntity.ok(1);
	}
	
}
