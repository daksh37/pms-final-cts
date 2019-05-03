package com.cts.policyManagmentSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cts.policyManagmentSystem.bean.Policy;
import com.cts.policyManagmentSystem.bean.UserPolicy;
import com.cts.policyManagmentSystem.dao.PolicyDAO;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class PolicyServiceImpl implements PolicyService {

	@Autowired
	PolicyDAO policyDAO;

	@Override
	public String addPolicy(Policy policy) {
		return policyDAO.addPolicy(policy);
	}

	@Override
	public List<Policy> getAllPolicy() {
		return policyDAO.getAllPolicy();
	}

	@Override
	public String updatePolicy(Policy policy) {
		return policyDAO.updatePolicy(policy);
	}

	@Override
	public Policy getPolicyById(String policyId) {
		return policyDAO.getPolicyById(policyId);
	}

	@Override
	public List<Policy> searchPolicyByValues(String userId, String search_by, String search_value) {
		return policyDAO.searchPolicyByValues(userId, search_by, search_value);
	}
	@Override
	public List<Policy> getAllPolicyForUser(String userId)
	{
		return policyDAO.getAllPolicyForUser(userId);
	}
	
	@Override
	public List<Policy> allPolicy(String userId)
	{
		return policyDAO.allPolicy(userId);
	}
	
	public String removePolicy(String policyId, String userId)
	{
		System.out.println("In service");
		return policyDAO.removePolicy(policyId,userId);
	}

	@Override
	public List<String> getPolicyStatus(String userId, String policyId) {
		return policyDAO.getPolicyStatus(userId,policyId);
	}
	@Override
	public boolean updatePolicyStatus(String policyId, String userId)
	{
		return policyDAO.updatePolicyStatus(policyId,userId);
	}
	
	@Override
	public List<Policy> searchPolicyByValuesAdmin(String userId, String search_by, String search_value) {
		return policyDAO.searchPolicyByValuesAdmin(userId, search_by, search_value);
	}
	
}
