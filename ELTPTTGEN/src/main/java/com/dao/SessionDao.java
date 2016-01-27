package com.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.bean.Session;

public class SessionDao
{

	SessionFactory sf;  

	public SessionFactory getSf() {
		return sf;
	}
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	public List<Session> getAllSessions()
	{
		org.hibernate.Session s=sf.openSession();
		Query query= s.createQuery("from Session");
		List<Session> s_lst=query.list();
		//Query query=s.createQuery("from ")
		return s_lst;

	}
	
	public List<Session> getSessionsByDate(Date date)
	{
		org.hibernate.Session s=sf.openSession();
		SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
		String d= sdf.format(date);
		try {
			date = sdf.parse(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Query query= s.createQuery("from Session S where S.startDate <=:date and S.endDate >=:date");
		query.setParameter("date", date);
		List<Session> s_lst=query.list();
		//Query query=s.createQuery("from ")
		return s_lst;

	}

}
