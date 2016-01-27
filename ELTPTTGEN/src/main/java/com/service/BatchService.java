package com.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Batch;
import com.dao.BatchDao;

public class BatchService 
{
	private static ApplicationContext context= new ClassPathXmlApplicationContext("beans.xml");
	public List<Batch> getbatchlist(){
		
		BatchDao bdao=(BatchDao)context.getBean("bdao");
		
		return bdao.getAllBatch();
		
	}

}
