package com.cts.policyManagmentSystem.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.cts.policyManagmentSystem.bean.Policy;
import com.cts.policyManagmentSystem.bean.User;
import java.util.List;

@Repository("registrationDAO")
public class RegistrationDAOImpl implements RegistrationDAO{

	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory;
	private static final DateFormat sdf = new SimpleDateFormat("MM/DD/YYYY");
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/DD/YYYY");
    
    
	@Transactional
	public String addUser(User user) {
		Session session = null;
		session = sessionFactory.getCurrentSession();
		try {
	
				session.save(user);
				return "true";
			}
		catch(Exception e)
		{
		      e.printStackTrace();
		      return null;
		}
		
	}

	@Transactional
	public String addAdmin(User user) {
		Session session = null;
		session = sessionFactory.getCurrentSession();
		try {
				session.save(user);
				return "true";		
		}
		catch(Exception e)
		{
		      e.printStackTrace();
		      return null;
		}
		
		
	}
	
	@Transactional
	public String checkPrimaryUserId(String userId)
	{
		Session session = null;
		session = sessionFactory.getCurrentSession();
		try {
			String query= "select userId from User where userId=?";
			Query<String> query2=null;
				
				query2=session.createQuery(query);
				query2.setParameter(0, userId);
				String user1 = query2.getSingleResult();
				return user1;
	}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
}
