package com.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.bean.Batch;

public class BatchDao
{
	SessionFactory sf;  

	public SessionFactory getSf() {
		return sf;
	}
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	public List<Batch> getAllBatch()
	{
		Session s=sf.openSession();
		Query query= s.createQuery("from Batch");
		List<Batch> b_lst=query.list();
		return b_lst;

	}

	public void addBatch(Batch b){
		
		Session s=sf.openSession();
		Transaction tx= s.beginTransaction();
		s.save(b);
		tx.commit();
	}
	public void deleteBatch(Batch b){
		Session s=sf.openSession();
		Transaction tx= s.beginTransaction();
		s.delete(b);
		tx.commit();
	}
}
