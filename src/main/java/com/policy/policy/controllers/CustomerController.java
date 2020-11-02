package com.policy.policy.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.policy.policy.models.Customer;
import com.policy.policy.reponses.Response;
import com.policy.policy.services.CustomerService;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public ResponseEntity<Response<List<Customer>>>getAll() {
		return ResponseEntity.ok(new Response<List<Customer>>(this.customerService.getCustomers()));
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Response<Customer>> getById(@PathVariable(name = "id") Long id) {
		return ResponseEntity.ok(new Response<Customer>(this.customerService.getCustomerById(id)));
	}
	
	@PostMapping
	public ResponseEntity<Response<Customer>> register(@Valid @RequestBody Customer customer, BindingResult result) {
		if(result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Customer>(erros));
		}
		
		return ResponseEntity.ok(new Response<Customer>(this.customerService.registerCustomer(customer)));
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Response<Customer>> update(@PathVariable(name = "id") Long id ,@Valid @RequestBody Customer customer, BindingResult result) {
		if(result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Customer>(erros));
		}
		
		customer.setId(id);
		return ResponseEntity.ok(new Response<Customer>(this.customerService.updateCustomer(customer)));
	}
	
	@DeleteMapping(path = "/{id}")
	public void remove(@PathVariable(name = "id") Long id) {
		this.customerService.removeCustomer(id);
	}
	
	
}
