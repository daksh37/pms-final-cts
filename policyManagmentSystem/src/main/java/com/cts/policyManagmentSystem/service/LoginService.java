package com.cts.policyManagmentSystem.service;

import com.cts.policyManagmentSystem.bean.User;

public interface LoginService {
	public User authenticate(String userName, String password);
}
