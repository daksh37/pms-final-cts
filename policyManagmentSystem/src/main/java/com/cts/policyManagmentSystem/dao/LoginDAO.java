package com.cts.policyManagmentSystem.dao;

import com.cts.policyManagmentSystem.bean.User;

public interface LoginDAO {

	public User authenticate(String userName, String password);
}
