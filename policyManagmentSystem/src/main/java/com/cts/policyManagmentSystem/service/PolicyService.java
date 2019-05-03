package com.cts.policyManagmentSystem.service;

import java.util.List;

import com.cts.policyManagmentSystem.bean.Policy;
import com.cts.policyManagmentSystem.bean.UserPolicy;

public interface PolicyService {
	public String addPolicy(Policy policy);
	public List<Policy> getAllPolicy();
	public String updatePolicy(Policy policy);
	public Policy getPolicyById(String policyId);
    public List<Policy> searchPolicyByValues(String userId, String search_by,String search_value);
    public List<Policy> getAllPolicyForUser(String userId);
    public List<Policy> allPolicy(String userId);
	public String removePolicy(String policyId,String userId);
	public List<String> getPolicyStatus(String userId, String policyId);
	public boolean updatePolicyStatus(String policyId, String userId);
	public List<Policy> searchPolicyByValuesAdmin(String userId, String search_by,String search_value);
}
