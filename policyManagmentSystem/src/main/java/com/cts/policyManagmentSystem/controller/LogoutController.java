package com.cts.policyManagmentSystem.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {

	//Logout for Admin
	@RequestMapping("logout.html")
	public ModelAndView exitPolicy(HttpSession httpSession){
		ModelAndView modelAndView = new ModelAndView();
		httpSession.invalidate();
		
		modelAndView.setViewName("adminLogin");
		return modelAndView;
	}
	
	//Logout for User
	@RequestMapping("logout1.html")
	public ModelAndView exitUserPolicy(HttpSession httpSession){
		ModelAndView modelAndView = new ModelAndView();
		httpSession.invalidate();
		
		modelAndView.setViewName("userLogin");
		return modelAndView;
	}
}
