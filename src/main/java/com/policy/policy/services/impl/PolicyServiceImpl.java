package com.policy.policy.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.policy.policy.models.Policy;
import com.policy.policy.repositories.PolicyRepository;
import com.policy.policy.services.PolicyService;

@Service
public class PolicyServiceImpl implements PolicyService {
	
	@Autowired
	private PolicyRepository policyRepository;
	
	
	@Override
	public List<Policy> getPolicy() {
	
		return this.policyRepository.findAll();
	}

	@Override
	public Policy getPolicyById(String numberPolicy) {
		
		return this.policyRepository.findById(numberPolicy).get();
	}

	@Override
	public Policy registerPolicy(Policy policy) {
		
		return this.policyRepository.save(policy);
	}

	@Override
	public Policy updatePolicy(Policy policy) {
		
		return this.policyRepository.save(policy);
	}

	@Override
	public void removePolicy(String numberPolicy) {
		
		this.policyRepository.deleteById(numberPolicy);
	}

	@Override
	public Policy searchNumberPolicy(String numberPolicy) {
		
		return this.policyRepository.findById(numberPolicy).get();
	}

}
