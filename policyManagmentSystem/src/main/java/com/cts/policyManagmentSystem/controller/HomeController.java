package com.cts.policyManagmentSystem.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	
//Front Page
	@RequestMapping("/")
	public String homePage(){
		return "adminLogin";
	}
}
