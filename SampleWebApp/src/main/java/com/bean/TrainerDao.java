package com.bean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class TrainerDao {
	SessionFactory sf;  
	
	public SessionFactory getSf() {
		return sf;
	}
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
 
	public void saveTrainer(Trainer e){ 
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
	    s.save(e);
	    
			tx.commit();
		
		s.close();
	}  
	 
	public Trainer getById(int id){  
		Session s=sf.openSession();
		Transaction tx= s.beginTransaction();
		Trainer e=(Trainer)s.get(Trainer.class,id); 

			tx.commit();
		
		s.close();
sf.close();
	    return e;  
	}
	

}
