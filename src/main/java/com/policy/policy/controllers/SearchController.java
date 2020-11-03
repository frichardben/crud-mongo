package com.policy.policy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.policy.policy.models.Policy;
import com.policy.policy.reponses.Response;
import com.policy.policy.services.PolicyService;

@RestController
@RequestMapping("/search")
public class SearchController {

	@Autowired
	private PolicyService policyService;
	
	@GetMapping
	public ResponseEntity<Response<Policy>>getNumberPolicy(@RequestParam String numberPolicy) {
		return ResponseEntity.ok(new Response<Policy>(this.policyService.searchNumberPolicy(numberPolicy)));
		
	}
	
	
	
	
}
