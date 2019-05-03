package com.cts.policyManagmentSystem.service;

import java.util.List;

import com.cts.policyManagmentSystem.bean.BankDetail;
import com.cts.policyManagmentSystem.bean.Policy;
import com.cts.policyManagmentSystem.bean.UserPolicy;

public interface UserService {
	public List<Policy> getPolicyByType();
	public List<Policy> getPolicyById();
	public List<Policy> getPolicyByYears();
	public List<Policy> getPolicyByCompany();
	public List<Policy> getPolicyByName();
	public String addPolicy(UserPolicy userPolicy,String policyId, String userId);
	public String addBankDetail(BankDetail bankDetail, String userId);
	public String addNetBankingDetail(BankDetail bankDetail, String userId);
	public String addUPIDetail(BankDetail bankDetail, String userId);
}
