package com.cts.policyManagmentSystem.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.policyManagmentSystem.bean.User;

@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO{

	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory;
	
	
	@Transactional(readOnly = true)
	public User authenticate(String userId, String password) {		
		Session session = null;
		
				String query= "from User where userId = ? AND password = ?";
			Query<User> query2=null;
				try {
					System.out.println("hi");
					session = sessionFactory.getCurrentSession();
					query2=session.createQuery(query);
					query2.setParameter(0, userId);
					query2.setParameter(1, password);
					User user = query2.getSingleResult();
					System.out.println(user.toString());
					if(user==null)
						return null;
					else
						return user;
				} catch (Exception e) {
					e.printStackTrace();
				}
		return null;
	}
	
}
