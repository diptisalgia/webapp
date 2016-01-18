package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Trainer;
import com.bean.TrainerDao;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	      
	  TrainerDao dao=(TrainerDao)context.getBean("d");  
	      
	   Trainer e=new Trainer();  
	   e.setTrainer_name("Santosh");
	   e.setEmail("abc@gmail.com");
	   e.setCity("nagpur");
	  dao.saveTrainer(e);  
	  System.out.println(dao.getById(1));
	}

}
