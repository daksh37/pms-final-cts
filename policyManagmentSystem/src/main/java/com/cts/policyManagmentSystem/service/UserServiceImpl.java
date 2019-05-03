package com.cts.policyManagmentSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cts.policyManagmentSystem.bean.BankDetail;
import com.cts.policyManagmentSystem.bean.Policy;
import com.cts.policyManagmentSystem.bean.UserPolicy;
import com.cts.policyManagmentSystem.dao.UserDAO;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class UserServiceImpl implements UserService{

	@Autowired
	UserDAO userDAO;
	
	
	@Override
	public List<Policy> getPolicyByType() {
		return userDAO.getPolicyByType();
	}

	@Override
	public List<Policy> getPolicyById() {
		return userDAO.getPolicyById();
	}

	@Override
	public List<Policy> getPolicyByYears() {
		return userDAO.getPolicyByYears();
	}

	@Override
	public List<Policy> getPolicyByCompany() {
		return userDAO.getPolicyByCompany();
	}

	@Override
	public List<Policy> getPolicyByName() {
		return userDAO.getPolicyByName();
	}

	@Override
	public String addPolicy(UserPolicy userPolicy, String policyId, String userId) {
		return userDAO.addPolicy(userPolicy,policyId, userId);
	}

	@Override
	public String addBankDetail(BankDetail bankDetail, String userId) {
		return userDAO.addBankDetail(bankDetail,userId);
	}
	@Override
	public String addNetBankingDetail(BankDetail bankDetail, String userId)
	{
		return userDAO.addNetBankingDetail(bankDetail, userId);
	}
	
	@Override
	public String addUPIDetail(BankDetail bankDetail, String userId)
	{
		return userDAO.addUPIDetail(bankDetail, userId);
	}

}
