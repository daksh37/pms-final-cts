package com.cts.policyManagmentSystem.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.cts.policyManagmentSystem.bean.Policy;
import com.cts.policyManagmentSystem.bean.User;
import com.cts.policyManagmentSystem.bean.UserPolicy;


@Repository("policyDAO")
public class PolicyDAOImpl implements PolicyDAO{

	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory;
	
	@Transactional
	public String addPolicy(Policy policy) {
		Session session = null;
		try {
		session = sessionFactory.getCurrentSession();
		session.save(policy);
			return "true";
		}
		catch(Exception e)
		{
		      e.printStackTrace();
		}
		return null;
	}

	@Transactional
	public List<Policy> getAllPolicy() {
		Session session = null;
		  try {
			  System.out.println("hi from getall");
	    	  	String query= "from Policy";
	    		Query<Policy> query2=null;
	    		session = sessionFactory.getCurrentSession();
	    		query2=session.createQuery(query);
	    		List<Policy> policies = query2.getResultList();
	    		if(policies==null)
	    			return null;
	    		else
	    			return policies;
	    			} catch (Exception e) {
	    				e.printStackTrace();
	    			}
		return null;
	}
	
	@Transactional
	public List<Policy> getAllPolicyForUser(String userId) {
		Session session = null;
		  try {
			  System.out.println("hi from getall");
	    	  	String query= "from Policy where policyId NOT IN(select policyId from UserPolicy where userId=?)";
	    		Query<Policy> query2=null;
	    		session = sessionFactory.getCurrentSession();
	    		query2=session.createQuery(query);
	    		query2.setParameter(0, userId);
	    		List<Policy> policies = query2.getResultList();
	    		if(policies==null)
	    			return null;
	    		else
	    			return policies;
	    			} catch (Exception e) {
	    				e.printStackTrace();
	    			}
		return null;
	}

	@Transactional
	public String updatePolicy(Policy policy) {
		Session session = null;
		try {
		session = sessionFactory.getCurrentSession();
		session.update(policy);
			return "true";
		}
		catch(Exception e)
		{
		      e.printStackTrace();
		}
		return null;
	}

	@Transactional
	public Policy getPolicyById(String policyId) {
		Session session = null;
		
		String query= "from Policy where policyId = ?";
		Query<Policy> query2=null;
		try {
			session = sessionFactory.getCurrentSession();
			query2=session.createQuery(query);
			query2.setParameter(0, policyId);
			Policy policy = query2.getSingleResult();
			if(policy==null)
				return null;
			else
				return policy;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	public List<Policy> searchPolicyByValues(String userId, String search_by, String search_value) {
		Session session =null;
		String query;
		if("By Name".equals(search_by)){
		query="from Policy where policyName=? AND policyId NOT IN(select policyId from UserPolicy where userId=?)";
		org.hibernate.query.Query<Policy> query2 = null;
		session=sessionFactory.getCurrentSession();
		query2=session.createQuery(query);
		query2.setParameter(0, search_value);
		query2.setParameter(1, userId);
		List<Policy> list=query2.getResultList();
		return list;
		}
		else if("By Id".equals(search_by)){
	    query="from Policy where policyId=? AND policyId NOT IN(select policyId from UserPolicy where userId=?)";
	    org.hibernate.query.Query<Policy> query2 = null;
	    session=sessionFactory.getCurrentSession();
		query2=session.createQuery(query);
		query2.setParameter(0, search_value);
		query2.setParameter(1, userId);
		List<Policy> list=query2.getResultList();
		return list;
		}
		else if("By Type".equals(search_by)){
		    query="from Policy where policyType=? AND policyId NOT IN(select policyId from UserPolicy where userId=?)";
		    org.hibernate.query.Query<Policy> query2 = null;
		    session=sessionFactory.getCurrentSession();
			query2=session.createQuery(query);
			query2.setParameter(0, search_value);
			query2.setParameter(1, userId);
			List<Policy> list=query2.getResultList();
			return list;
		}
		
		else{
		query="from Policy where duration=? AND policyId NOT IN(select policyId from UserPolicy where userId=?)";
		org.hibernate.query.Query<Policy> query2 = null;
		session=sessionFactory.getCurrentSession();
		query2=session.createQuery(query);
		query2.setParameter(0, search_value);
		query2.setParameter(1, userId);
		List<Policy> list=query2.getResultList();
		return list;
		}
	}
	@Transactional
	public List<Policy> allPolicy(String userId) {
		Session session = null;
		  try {
			  System.out.println("hi from getall");
	    	  	String query= "from Policy where policyId IN (select policyId from UserPolicy where userId=?)";
	    		Query<Policy> query2=null;
	    		
	    		session = sessionFactory.getCurrentSession();
	    		query2=session.createQuery(query);
				query2.setParameter(0, userId);

	    		List<Policy> policies = query2.getResultList();
	    		if(policies==null)
	    			return null;
	    		else
	    			return policies;
	    			} catch (Exception e) {
	    				e.printStackTrace();
	    			}
		return null;
	}

	@Transactional
	public String removePolicy(String policyId, String userId) {
		Session session=null;
		System.out.println("In DAO " +policyId + userId);
		session= sessionFactory.getCurrentSession();
		try{
			
			String query="from UserPolicy where policyId=? AND userId=?";
			Query<UserPolicy> query2=null;
			query2=session.createQuery(query);
			query2.setParameter(0, policyId);
			query2.setParameter(1, userId);
    		List<UserPolicy> policies = query2.getResultList();
    		for(UserPolicy y : policies)
    		{
    			session.delete(y);

    		
    		}
			return "deleted";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}

	@Transactional
	public List<String> getPolicyStatus(String userId, String policyId) {
		// TODO Auto-generated method stub
		Session session= null;
		session= sessionFactory.getCurrentSession();
		try{
		String query= "select paymentStatus from UserPolicy where userId=? AND policyId=?"; 
		Query<String> query2=null;
		query2=session.createQuery(query);
		query2.setParameter(0, userId);
		query2.setParameter(1, policyId);
		List<String> a=query2.getResultList();
		System.out.println(a);
		return a;
	}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
}
	
	@Transactional
	public boolean updatePolicyStatus(String policyId, String userId){
		
		System.out.println("In DAO Update"+ policyId + userId);
		Session session=null;
		session = sessionFactory.getCurrentSession();
		
try{
			
			String query="from UserPolicy where policyId=? AND userId=?";
			Query<UserPolicy> query2=null;
			query2=session.createQuery(query);
			query2.setParameter(0, policyId);
			query2.setParameter(1, userId);
    		List<UserPolicy> policies = query2.getResultList();
    		for(UserPolicy y : policies)
    		{
    			y.setPaymentStatus("Paid");
    			session.saveOrUpdate(y);

    		
    		
    		}
    		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	@Transactional
	public List<Policy> searchPolicyByValuesAdmin(String userId, String search_by, String search_value) {
		// TODO Auto-generated method stub
		Session session =null;
		String query;
		if("By Name".equals(search_by)){
		query="from Policy where policyName=?";
		org.hibernate.query.Query<Policy> query2 = null;
		session=sessionFactory.getCurrentSession();
		query2=session.createQuery(query);
		query2.setParameter(0, search_value);
		
		List<Policy> list=query2.getResultList();
		return list;
		}
		else if("By Id".equals(search_by)){
	    query="from Policy where policyId=?";
	    org.hibernate.query.Query<Policy> query2 = null;
	    session=sessionFactory.getCurrentSession();
		query2=session.createQuery(query);
		query2.setParameter(0, search_value);
		List<Policy> list=query2.getResultList();
		return list;
		}
		else if("By Type".equals(search_by)){
		    query="from Policy where policyType=?";
		    org.hibernate.query.Query<Policy> query2 = null;
		    session=sessionFactory.getCurrentSession();
			query2=session.createQuery(query);
			query2.setParameter(0, search_value);
			
			List<Policy> list=query2.getResultList();
			return list;
		}
		
		else{
		query="from Policy where duration=?";
		org.hibernate.query.Query<Policy> query2 = null;
		session=sessionFactory.getCurrentSession();
		query2=session.createQuery(query);
		query2.setParameter(0, search_value);
		List<Policy> list=query2.getResultList();
		return list;
		}
	}
		
}
