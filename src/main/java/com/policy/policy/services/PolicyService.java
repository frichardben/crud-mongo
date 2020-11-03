package com.policy.policy.services;

import java.util.List;

import com.policy.policy.models.Policy;

public interface PolicyService {
	
	List<Policy> getPolicy();
	
	Policy getPolicyById(String numberPolicy);
	
	Policy registerPolicy(Policy policy);
	
	Policy updatePolicy(Policy policy);
	
	void removePolicy(String numberPolicy);
	
	Policy searchNumberPolicy(String numberPolicy);
}
