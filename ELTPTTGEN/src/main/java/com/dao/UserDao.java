package com.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.bean.User;

public class UserDao
{
	SessionFactory sf;  
	
	public SessionFactory getSf() {
		return sf;
	}
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	public List<User> getAllUsers()
	{
		Session s=sf.openSession();
		Query query= s.createQuery("from User");
		List<User> usr_lst=query.list();
		//Query query=s.createQuery("from ")
		return usr_lst;
		
	}
	
	public void addUser(User u){
		Session s=sf.openSession();
		Transaction tx= s.beginTransaction();
		s.save(u);
		tx.commit();
	}

}
