package com.main;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Batch;
import com.bean.Batch_type;
import com.service.AddBatchAndCreateTTwithSubPriority;
import com.service.EmailService;

public class RelationTest {

	public static void main(String[] args) {
		
		/*Batch b = new Batch("ELTP JAVA", Batch_type.DEVELOPMENT, "Nagpur", "Atharva", 18, new Date());
		Batch b1 = new Batch("ELTP JAV2A", Batch_type.DEVELOPMENT, "Nagpur", "Atharva", 18, new Date());
		Batch b2 = new Batch("ELTP JAV3A", Batch_type.DEVELOPMENT, "Nagpur", "Atharva", 18, new Date());
		Batch b3 = new Batch("ELTP JAV4A", Batch_type.DEVELOPMENT, "Nagpur", "Atharva", 18, new Date());
		Batch b4 = new Batch("ELTP JAV5A", Batch_type.DEVELOPMENT, "Nagpur", "Atharva", 18, new Date());
		Batch b5 = new Batch("ELTP JAV6A", Batch_type.DEVELOPMENT, "Nagpur", "Atharva", 18, new Date());
	
		new AddBatchAndCreateTTwithSubPriority().createTT(b);
		new AddBatchAndCreateTTwithSubPriority().createTT(b1);
		new AddBatchAndCreateTTwithSubPriority().createTT(b2);
		new AddBatchAndCreateTTwithSubPriority().createTT(b3);
		new AddBatchAndCreateTTwithSubPriority().createTT(b4);
		new AddBatchAndCreateTTwithSubPriority().createTT(b5);
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		SessionFactory sf=(SessionFactory)context.getBean("mysessionFactory");
		Session session;
		session= sf.openSession();
		Transaction tx;
		tx= session.beginTransaction();
		
		session.save(b);
		session.save(b1);
		session.save(b2);
		session.save(b3);
		session.save(b4);
		session.save(b5);
		tx.commit();
		session.close();
		EmailService email=(EmailService)context.getBean("email");
		email.sendEmails(b);*/
	}

}
