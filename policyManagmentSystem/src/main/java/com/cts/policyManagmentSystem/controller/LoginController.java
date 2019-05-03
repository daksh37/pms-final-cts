package com.cts.policyManagmentSystem.controller;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.EventListener;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRegistration.Dynamic;
import javax.servlet.SessionCookieConfig;
import javax.servlet.SessionTrackingMode;
import javax.servlet.descriptor.JspConfigDescriptor;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.policyManagmentSystem.bean.Policy;
import com.cts.policyManagmentSystem.bean.User;
import com.cts.policyManagmentSystem.service.LoginService;
import com.cts.policyManagmentSystem.service.PolicyService;



@Controller
public class LoginController{
	
	@Autowired
	LoginService loginService;
	
	//Open User Login
	@RequestMapping("userlog.html")
	public String getLoginPage1(){
		return "userLogin";
	}
	
	//open Admin Login
	@RequestMapping("adminlog.html")
	public String getLoginPage2(){
		return "adminLogin";
	}
	
	
	//For Getting Admin home page by Home button 
	@RequestMapping("policy1.html")
	public ModelAndView policy(@ModelAttribute Policy policy,@RequestParam("id") String userId, HttpSession httpSession)
	{
		ModelAndView modelAndView= new ModelAndView();
		User user2 = (User)httpSession.getAttribute("user");
		modelAndView.addObject("user", user2);
		List<Policy> policies = policyService.getAllPolicy();
		modelAndView.addObject("products", policies);
		modelAndView.setViewName("adminHome1");
		return modelAndView;
	}
	
	@GetMapping(value="adminHome2.html")
	public ModelAndView getAdminPage(@ModelAttribute Policy policy, HttpSession httpSession){
		ModelAndView modelAndView= new ModelAndView();
		User user2 = (User)httpSession.getAttribute("user");
		modelAndView.addObject("user", user2);
		List<Policy> policies = policyService.getAllPolicy();
		modelAndView.addObject("products", policies);
		modelAndView.setViewName("adminHome1");
		return modelAndView;
	}
	
	//For Getting User home page by Home button 
	@RequestMapping(value="policy.html")
	public ModelAndView policyUser(@ModelAttribute Policy policy,@RequestParam("id") String userId, HttpSession httpSession)
	{
		ModelAndView modelAndView= new ModelAndView();
		List<Policy> policies = policyService.getAllPolicyForUser(userId);
		modelAndView.addObject("products", policies);
		modelAndView.setViewName("userHome");
		return modelAndView;
	}
	
	@RequestMapping(value="userHome2.html")
	public ModelAndView getUserPage(@ModelAttribute Policy policy, HttpSession httpSession)
	{
		ModelAndView modelAndView= new ModelAndView();
		User user2 = (User)httpSession.getAttribute("user");
		modelAndView.addObject("user", user2);
		String userId= user2.getUserId();
		List<Policy> policies = policyService.getAllPolicyForUser(userId);
		modelAndView.addObject("products", policies);
		modelAndView.setViewName("userHome");
		return modelAndView;
	}

	
	@Autowired
	PolicyService policyService;
	

	//Login Controller for Admin
	@PostMapping("login.html")
	public ModelAndView validateAdmin(@ModelAttribute User user,HttpSession httpSession){
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(user.toString());
		User user2 = loginService.authenticate(user.getUserId(), user.getPassword());
		if(loginService.authenticate(user.getUserId(),user.getPassword()) != null)
		{
				if("A".equals(user2.getUserType()))
			{
					modelAndView.addObject("user", user2);
					httpSession.setAttribute("user", user2);
					List<Policy> policies = policyService.getAllPolicy();
					modelAndView.addObject("products", policies);	
					modelAndView.setViewName("adminHome1");
			}
			
			if("U".equals(user2.getUserType()))
			{
				JOptionPane.showMessageDialog(null, "Hey User! Please Login in user Portal");
				modelAndView.setViewName("adminLogin");
				return modelAndView;
			}
				
				
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "UserId and Password not matched");
			modelAndView.setViewName("adminLogin");
			return modelAndView;
		}
		return modelAndView;
		
	}
	
	
	//Login Controller for User
	@PostMapping("loginuser.html")
	public ModelAndView validateUser(@ModelAttribute User user,@RequestParam("id") String userId,HttpSession httpSession){
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(user.toString());
		User user2 = loginService.authenticate(user.getUserId(), user.getPassword());
		if(loginService.authenticate(user.getUserId(),user.getPassword()) != null)
		{
			if("A".equals(user2.getUserType()))
			{
				JOptionPane.showMessageDialog(null, "Hey Admin! Please Login in Admin Portal");
				modelAndView.setViewName("userLogin");
				return modelAndView;
				
			}
			
			if("U".equals(user2.getUserType()))
			{
				modelAndView.addObject("user", user2);
				httpSession.setAttribute("user", user2);
				List<Policy> policies = policyService.getAllPolicyForUser(user.getUserId());
				modelAndView.addObject("products", policies);
				modelAndView.setViewName("userHome");
				
			}
				
				
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "UserId and Password not matched");
			modelAndView.setViewName("userLogin");
			return modelAndView;	
		}
		return modelAndView;
		
	}


	
	
}
