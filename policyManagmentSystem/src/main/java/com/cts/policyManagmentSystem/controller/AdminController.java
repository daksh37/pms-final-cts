package com.cts.policyManagmentSystem.controller;

import java.util.List;

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
import com.cts.policyManagmentSystem.service.PolicyService;

@Controller
@RequestMapping("admin")
public class AdminController {

	@Autowired
	PolicyService policyService;	
	
	
	//For open the add policy page
	@RequestMapping("/addPolicy.html")
	public ModelAndView getPolicyPage(HttpSession httpSession){
		ModelAndView modelAndView= new ModelAndView();
		modelAndView.setViewName("addPolicy");
		return modelAndView;
	}
	
	
	//After Fill the Add policy form , it will work on submit button and policy stored in database
	@PostMapping("/addPolicy.html")
	public ModelAndView addPolicy(@ModelAttribute Policy policy,HttpSession httpSession){
		ModelAndView modelAndView = new ModelAndView();
		if("true".equals(policyService.addPolicy(policy)))
		{
			JOptionPane.showMessageDialog(null, "Policy Added Successfully");
			List<Policy> policies = policyService.getAllPolicy();
			modelAndView.addObject("products", policies);
			modelAndView.setViewName("redirect:/adminHome2.html");
			return modelAndView;
		}
		else
		{
			modelAndView.setViewName("errorPage");
			return modelAndView;
		}
	}
	
	
	// this mapping is use for the view the policy detail with respect to the policy id
	@RequestMapping(value="/viewPolicy.html")
	public ModelAndView getViewProduct(@RequestParam("id") String id,HttpSession httpSession){
		ModelAndView mav = new ModelAndView();
		Policy policy= policyService.getPolicyById(id);
		mav.addObject("policy",policy);
		mav.setViewName("viewPolicy");
		
		return mav;
	}
	
	//Edit Policy help for open the edit policy page
	@RequestMapping(value="/editPolicy.html")
	public ModelAndView getEditPolicyInfo(@RequestParam("id") String id,HttpSession httpSession){
		ModelAndView mav = new ModelAndView();
		Policy policy= policyService.getPolicyById(id);
		System.out.println(policy);
		mav.addObject("display",policy);
		mav.setViewName("editPolicy");
		return mav;
	}
	
	//After change in the policy, it will update the database after pressing submit button 
	@PostMapping(value="/editPolicy.html")
	public ModelAndView putEditPolicy(@ModelAttribute Policy policy,HttpSession httpSession){
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(policy);
		if("true".equals(policyService.updatePolicy(policy)))
		{
			List<Policy> policies = policyService.getAllPolicy();
			modelAndView.addObject("products", policies);
			modelAndView.setViewName("redirect:/adminHome2.html");
			return modelAndView;
			
		}
		else
		{
			modelAndView.setViewName("errorPage");
			return modelAndView;
		}
	}
	
	//For Logout
	@GetMapping("/logout.html")
	public ModelAndView exitProduct(HttpSession httpSession){
		ModelAndView modelAndView = new ModelAndView();
		httpSession.invalidate();
		
		modelAndView.setViewName("redirect:/logout.html");
		return modelAndView;
	}
	
	
	//For getting Admin Home page
	@RequestMapping(value="/policy1.html")
	public ModelAndView policy(@ModelAttribute Policy policy,@RequestParam("id") String userId, HttpSession httpSession)
	{
		ModelAndView modelAndView= new ModelAndView();
		User user2 = (User)httpSession.getAttribute("user");
		modelAndView.addObject("user", user2);
		List<Policy> policies = policyService.getAllPolicy();
		modelAndView.addObject("products", policies);
		modelAndView.setViewName("redirect:/adminHome2.html");
		return modelAndView;
	}
	
	
	//search the policy
	@RequestMapping(value="/search1.html", method= RequestMethod.POST)
	public ModelAndView searchMedicine(@ModelAttribute Policy policy,@RequestParam("id") String userId, @RequestParam("selectby") String search_by,@RequestParam("search") String search_value, HttpSession httpSession){
		ModelAndView modelAndView = new ModelAndView();
		if(("".equals(search_by))||("".equals(search_value)))
		{
			List<Policy> policies = policyService.getAllPolicy();
			modelAndView.addObject("products", policies);
			modelAndView.setViewName("redirect:/adminHome2.html");
			return modelAndView;
		}
		else
		{
			
		
			List<Policy> policies= policyService.searchPolicyByValuesAdmin(userId, search_by, search_value);
			if(policies.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "No Match Found");
				List<Policy> policies1 = policyService.getAllPolicy();
				modelAndView.addObject("products", policies1);
				modelAndView.setViewName("redirect:/adminHome2.html");
				return modelAndView;
			}
			else
			{
			modelAndView.addObject("products", policies);
			modelAndView.setViewName("adminHome1");
			return modelAndView;
			}
		}
	
	}
}
