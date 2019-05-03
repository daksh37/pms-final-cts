package com.cts.policyManagmentSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cts.policyManagmentSystem.bean.User;
import com.cts.policyManagmentSystem.dao.LoginDAO;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginDAO loginDAO;

	@Override
	public User authenticate(String userName, String password) {
		return loginDAO.authenticate(userName, password);
	}

}
