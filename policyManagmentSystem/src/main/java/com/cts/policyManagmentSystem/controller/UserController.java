package com.cts.policyManagmentSystem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.policyManagmentSystem.bean.BankDetail;
import com.cts.policyManagmentSystem.bean.Policy;
import com.cts.policyManagmentSystem.bean.UserPolicy;
import com.cts.policyManagmentSystem.service.PolicyService;
import com.cts.policyManagmentSystem.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
static public List<Policy> li= new ArrayList<Policy>(); 
	@Autowired
	UserService userService;
	
	@Autowired
	PolicyService policyService;
	
	
	@RequestMapping(value="/viewPolicyByUser.html")
	public ModelAndView getViewPolicy(@RequestParam("id") String id,HttpSession httpSession){
		ModelAndView mav = new ModelAndView();
		Policy policy= policyService.getPolicyById(id);
		mav.addObject("policy",policy);
		mav.setViewName("viewPolicyByUser");
		
		return mav;
	}
	
	
	@RequestMapping(value="/addToCart.html")
	public ModelAndView addToCart(@ModelAttribute UserPolicy userPolicy, @RequestParam("id") String policyId,@RequestParam("id1") String userId, HttpSession httpSession, HttpServletRequest request)
	{
		ModelAndView modelAndView= new ModelAndView();
		
		List<String> status=policyService.getPolicyStatus(userId,policyId);
		modelAndView.addObject("id", policyId);
		modelAndView.addObject("id1", userId);
	if("Pending".equals(status.get(0)))
	{	
				modelAndView.setViewName("paymentPage");
				return modelAndView;
			
	}
	else
	{
		JOptionPane.showMessageDialog(null, "Already Paid");
		List<Policy> policies=policyService.allPolicy(userId);
		modelAndView.addObject("products", policies);
		modelAndView.setViewName("userPolicy");
		return modelAndView;
	}
	}
	
	
	@RequestMapping(value="/addToCart1.html")
	public ModelAndView addToCart1(@ModelAttribute UserPolicy userPolicy, @RequestParam("id") String policyId,@RequestParam("id1") String userId, HttpSession httpSession, HttpServletRequest request)
	{
		ModelAndView modelAndView= new ModelAndView();
		modelAndView.addObject("id", policyId);
		modelAndView.addObject("id1", userId);
		if("true".equals(userService.addPolicy(userPolicy,policyId, userId)))
		{
			modelAndView.setViewName("paymentPage");
			return modelAndView;
		}
		else
		{
			modelAndView.setViewName("errorPage");
			return null;
			
		}
}

	
	
	@RequestMapping(value="/policy.html")
	public ModelAndView policy(@ModelAttribute Policy policy,@RequestParam("id") String userId, HttpSession httpSession)
	{
		ModelAndView modelAndView= new ModelAndView();
		List<Policy> policies = policyService.getAllPolicyForUser(userId);
		modelAndView.addObject("products", policies);
		modelAndView.setViewName("redirect:/userHome2.html");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/search.html", method= RequestMethod.POST)
	public ModelAndView searchMedicine(@ModelAttribute Policy policy,@RequestParam("id") String userId, @RequestParam("selectby") String search_by,@RequestParam("search") String search_value, HttpSession httpSession){
		ModelAndView modelAndView = new ModelAndView();
		if(("".equals(search_by))||("".equals(search_value)))
		{
			List<Policy> policies1 = policyService.getAllPolicyForUser(userId);
			modelAndView.addObject("products", policies1);
			modelAndView.setViewName("redirect:/userHome2.html");
			return modelAndView;	
		}
			else
		{
			List<Policy> policies= policyService.searchPolicyByValues(userId, search_by, search_value);
			if(policies.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "No Match Found");
				List<Policy> policies1 = policyService.getAllPolicyForUser(userId);
				modelAndView.addObject("products", policies1);
				modelAndView.setViewName("redirect:/userHome2.html");
				return modelAndView;	
				
			}
			else
			{
			modelAndView.addObject("products", policies);
			modelAndView.setViewName("userHome");
			return modelAndView;
			}
		}
	
	}
	
	@RequestMapping(value="/userShowPolicy.html")
	public ModelAndView policy(@RequestParam("id") String userId, HttpSession httpSession)
	{
		ModelAndView modelAndView= new ModelAndView();
		List<Policy> policies=policyService.allPolicy(userId);
		
		modelAndView.addObject("products", policies);
		modelAndView.setViewName("userPolicy");
		return modelAndView;
	}
	
	@RequestMapping(value="/remove.html")
	public ModelAndView remove(@RequestParam("id") String policyId, @RequestParam("id1") String userId,  HttpSession httpSession)
	{
		ModelAndView modelAndView= new ModelAndView();
		System.out.println(userId + policyId);
		List<String> status=policyService.getPolicyStatus(userId,policyId);
		if("Pending".equals(status.get(0)))
		{
		String a=policyService.removePolicy(policyId,userId);
			List<Policy> policies=policyService.allPolicy(userId);
			modelAndView.addObject("products", policies);
			modelAndView.setViewName("userPolicy");
			return modelAndView;
		}
		else
		{
			JOptionPane.showMessageDialog(null, "You already paid for this policy, You can't remove from your cart ");
			List<Policy> policies=policyService.allPolicy(userId);
			modelAndView.addObject("products", policies);
			modelAndView.setViewName("userPolicy");
			return modelAndView;
		}
		
		
	}
	@PostMapping(value="/paymentGateway.html")
	public ModelAndView cart(HttpSession httpSession,@RequestParam("id") String policyId, @RequestParam("id1") String userId, @RequestParam("paymentMethod") String paymentMethod)
	{
		System.out.println(paymentMethod);
		if("Credit/Debit Card".equals(paymentMethod))
		{
		ModelAndView modelAndView= new ModelAndView();
		modelAndView.addObject("id", policyId);
		modelAndView.addObject("id1", userId);
		modelAndView.setViewName("checkout");
		return modelAndView;
		}
		if("NetBanking".equals(paymentMethod))
		{
		ModelAndView modelAndView= new ModelAndView();
		modelAndView.addObject("id", policyId);
		modelAndView.addObject("id1", userId);
		modelAndView.setViewName("netBanking");
		return modelAndView;
		}
		else
		{
			ModelAndView modelAndView= new ModelAndView();
			modelAndView.addObject("id", policyId);
			modelAndView.addObject("id1", userId);
			modelAndView.setViewName("upi");
			return modelAndView;
		}
	}
	
	@PostMapping(value="/checkout.html")
	public ModelAndView checkout(@ModelAttribute BankDetail bankDetail, HttpSession httpSession, @RequestParam("id") String policyId, @RequestParam("id1") String userId)
	{
		
		
		System.out.println("In Payment" + policyId + userId);
		
		ModelAndView modelAndView= new ModelAndView();
		modelAndView.addObject("id", policyId);
		modelAndView.addObject("id1", userId);
		if("true".equals(userService.addBankDetail(bankDetail, userId)))
		{
			Policy policies=policyService.getPolicyById(policyId);
			modelAndView.addObject("policy", policies);
			boolean a=policyService.updatePolicyStatus(policyId,userId);
			modelAndView.setViewName("paymentSuccess");
		}
		return modelAndView;
	}
	
	
	@PostMapping(value="/checkoutNet.html")
	public ModelAndView checkoutNet(@ModelAttribute BankDetail bankDetail, HttpSession httpSession, @RequestParam("id") String policyId, @RequestParam("id1") String userId)
	{
		
		
		System.out.println("In Payment" + policyId + userId);
		
		ModelAndView modelAndView= new ModelAndView();
		modelAndView.addObject("id", policyId);
		modelAndView.addObject("id1", userId);
		if("true".equals(userService.addNetBankingDetail(bankDetail, userId)))
		{
			Policy policies=policyService.getPolicyById(policyId);
			modelAndView.addObject("policy", policies);
			boolean a=policyService.updatePolicyStatus(policyId,userId);
			modelAndView.setViewName("paymentSuccess");
		}
		return modelAndView;
	}
	
	@PostMapping(value="/checkoutUPI.html")
	public ModelAndView checkoutUPI(@ModelAttribute BankDetail bankDetail, HttpSession httpSession, @RequestParam("id") String policyId, @RequestParam("id1") String userId)
	{
		
		
		System.out.println("In Payment" + policyId + userId);
		
		ModelAndView modelAndView= new ModelAndView();
		modelAndView.addObject("id", policyId);
		modelAndView.addObject("id1", userId);
		if("true".equals(userService.addUPIDetail(bankDetail, userId)))
		{
			Policy policies=policyService.getPolicyById(policyId);
			modelAndView.addObject("policy", policies);
			boolean a=policyService.updatePolicyStatus(policyId,userId);
			modelAndView.setViewName("paymentSuccess");
		}
		return modelAndView;
	}
	
	@GetMapping("/logout1.html")
	public ModelAndView exitProduct(HttpSession httpSession){
		ModelAndView modelAndView = new ModelAndView();
		httpSession.invalidate();
		
		modelAndView.setViewName("redirect:/logout1.html");
		return modelAndView;
	}
}
