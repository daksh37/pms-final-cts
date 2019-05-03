package com.cts.policyManagmentSystem.controller;

import java.text.SimpleDateFormat; 
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.policyManagmentSystem.bean.User;
import com.cts.policyManagmentSystem.service.RegistrationService;

@Controller
public class RegistartionController {

	@Autowired
	RegistrationService registrationService;
	
	@RequestMapping("successful.html")
	public String getSuccessfulPage(){
		return "successful";
	}
	
	//Get Admin Register Page
	@GetMapping("registration12.html")
	public ModelAndView getRegistrationPage(@ModelAttribute User user,HttpSession httpSession){
		ModelAndView modelAndView= new ModelAndView();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("adminRegister");
		
		return modelAndView;
	}
	
	//Get User Registration Page
	@GetMapping("registration13.html")
	public ModelAndView getRegistrationPageUser(@ModelAttribute User user,HttpSession httpSession, Model model){
		ModelAndView modelAndView= new ModelAndView();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("userRegister");
	
		return modelAndView;
	}
	
	//Register the new Admin
	@PostMapping("registration.html")
	public ModelAndView registerAdmin(/*@ModelAttribute User user*/HttpSession httpSession,HttpServletRequest request,@RequestParam("DOB") String DO,@RequestParam("userId") String userId, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName ,@RequestParam("gender") String gender ,@RequestParam("contactNo") String contactNo, @RequestParam("address") String address, @RequestParam("email") String email ,@RequestParam("qualification") String qualification ,@RequestParam("salary") int salary ,@RequestParam("PAN") String PAN ,@RequestParam("employerType") String employerType  ,@RequestParam("employer") String employer  ,@RequestParam("hintQuestion") String hintQuestion ,@RequestParam("hintAnswer") String hintAnswer ,@RequestParam("password") String password )
	{
		Date DOB=null;
		ModelAndView modelAndView = new ModelAndView();
		
		try{
		DOB=new SimpleDateFormat("yyyy-MM-dd").parse(DO);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		String userType="A";
		User user= new User(userId,firstName,lastName,DOB,gender,contactNo,address,email,qualification,salary,PAN,employerType,employer,hintQuestion,hintAnswer,password,userType);
		String abc= registrationService.checkPrimaryUserId(user.getUserId());
		if(!user.getUserId().equals(abc))
		{
			
			if("true".equals(registrationService.addAdmin(user)))
			{
				
				JOptionPane.showMessageDialog(null, "Registration Successfull");
				modelAndView.setViewName("adminLogin");
				return modelAndView;
			}	
			else
			{
				modelAndView.setViewName("errorPage");
				return modelAndView;
			}
		}
		
			 else
			{
				
				JOptionPane.showMessageDialog(null, "userId is already taken");
				modelAndView.setViewName("adminRegister");
				return modelAndView;
			}	
		
		
	
		
	}
	
	//Register the New User
	@PostMapping("userregistration.html")
	public ModelAndView registerUser(HttpSession httpSession,HttpServletRequest request,@RequestParam("DOB") String DO,@RequestParam("userId") String userId, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName ,@RequestParam("gender") String gender ,@RequestParam("contactNo") String contactNo, @RequestParam("address") String address, @RequestParam("email") String email ,@RequestParam("qualification") String qualification ,@RequestParam("salary") int salary ,@RequestParam("PAN") String PAN ,@RequestParam("employerType") String employerType  ,@RequestParam("employer") String employer  ,@RequestParam("hintQuestion") String hintQuestion ,@RequestParam("hintAnswer") String hintAnswer ,@RequestParam("password") String password )
	{
		Date DOB=null;
		ModelAndView modelAndView = new ModelAndView();
		
		try{
		DOB=new SimpleDateFormat("yyyy-MM-dd").parse(DO);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		String userType="U";
		User user= new User(userId,firstName,lastName,DOB,gender,contactNo,address,email,qualification,salary,PAN,employerType,employer,hintQuestion,hintAnswer,password,userType);
		String abc= registrationService.checkPrimaryUserId(user.getUserId());
		if(!user.getUserId().equals(abc))
		{
			
			if("true".equals(registrationService.addUser(user)))
			{
				
				JOptionPane.showMessageDialog(null, "Registration Successfull");
				modelAndView.setViewName("adminLogin");
				return modelAndView;
			}	
			else
			{
				modelAndView.setViewName("errorPage");
				return modelAndView;
			}
		}
		
			 else
			{
				
				JOptionPane.showMessageDialog(null, "userId is already taken");
				modelAndView.setViewName("userRegister");
				return modelAndView;
			}	
		
		
	
		
	}
}
