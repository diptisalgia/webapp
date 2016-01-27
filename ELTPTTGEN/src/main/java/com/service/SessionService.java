package com.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.SessionDao;

public class SessionService {
	ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
	
	public SessionDao getSessionDaoObj(){
		SessionDao sdao=(SessionDao)context.getBean("sdao");
		return sdao;
	}

}
