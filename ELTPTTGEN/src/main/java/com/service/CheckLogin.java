package com.service;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.bean.User;
import com.dao.UserDao;

public class CheckLogin 
{
	private static ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
	public User checkLogin (String un,String pw) 
	{
		
		
		UserDao udao=(UserDao)context.getBean("udao");
		List<User> users = udao.getAllUsers();
        User var=null;
		for(User u:users){
			if(un.equalsIgnoreCase(u.getUsername())&&pw.equalsIgnoreCase(u.getPassword()))
			{
				var=u;
				
			}
		  }
		
			return var;
	}
	public void create_user (User u) 
	{
		
		
		UserDao udao=(UserDao)context.getBean("udao");
		
		udao.addUser(u);
		
			
		
		
		
	}


}
