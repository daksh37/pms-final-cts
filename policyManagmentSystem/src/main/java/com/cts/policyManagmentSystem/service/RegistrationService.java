package com.cts.policyManagmentSystem.service;

import java.util.Date;
import java.util.List;

import com.cts.policyManagmentSystem.bean.User;

public interface RegistrationService {
	public String addAdmin(User user);
	public String addUser(User user);
	public String checkPrimaryUserId(String userId);
}
