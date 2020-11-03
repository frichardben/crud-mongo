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


import com.policy.policy.models.Policy;
import com.policy.policy.reponses.Response;
import com.policy.policy.services.PolicyService;

@RestController
@RequestMapping(path = "/policy")
public class PolicyController {
	
	@Autowired
	private PolicyService policyService;
	
	@GetMapping
	public ResponseEntity<Response<List<Policy>>>getAll() {
		return ResponseEntity.ok(new Response<List<Policy>>(this.policyService.getPolicy()));
	}
	
	@GetMapping(path = "/{numberPolicy}")
	public ResponseEntity<Response<Policy>> getById(@PathVariable(name = "numberPolicy") String numberPolicy) {
		return ResponseEntity.ok(new Response<Policy>(this.policyService.getPolicyById(numberPolicy)));
	}
	
	@PostMapping
	public ResponseEntity<Response<Policy>> register(@Valid @RequestBody Policy policy, BindingResult result) {
		if(result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Policy>(erros));
		}
		
		return ResponseEntity.ok(new Response<Policy>(this.policyService.registerPolicy(policy)));
	}
	
	@PutMapping(path = "/{numberPolicy}")
	public ResponseEntity<Response<Policy>> update(@PathVariable(name = "numberPolicy") String numberPolicy ,@Valid @RequestBody Policy policy, BindingResult result) {
		if(result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Policy>(erros));
		}
		
		policy.setNumberPolicy(numberPolicy);
		return ResponseEntity.ok(new Response<Policy>(this.policyService.updatePolicy(policy)));
	}
	
	@DeleteMapping(path = "/{numberPolicy}")
	public void remove(@PathVariable(name = "numberPolicy") String numberPolicy) {
		this.policyService.removePolicy(numberPolicy);
	}

}
