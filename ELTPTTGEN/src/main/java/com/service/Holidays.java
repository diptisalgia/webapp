package com.service;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;


public class Holidays {
	private static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	private static List<Date> holidays=new ArrayList<Date>();
	private static boolean flag=false;
	public List<Date> getHolidays(){
		if(flag==false){
			flag=true;
			Scanner sc=null;
			String str="";
			int mon=1;
			try{
				CustomResourceLoader crl=(CustomResourceLoader)context.getBean("holidaysResourceLoader");
				Resource r=crl.getResource();
				File file=r.getFile();
				sc=new Scanner(file);

				while (sc.hasNext())
				{
					str=sc.nextLine();
					String datesinmon[]=str.split(",");
					for(String s: datesinmon)
					{
						if(s!=null && !s.isEmpty())
						{
							String x=s+"/"+(mon)+"/"+2016;
							SimpleDateFormat sf=new SimpleDateFormat("dd/MM/yyyy");
							Date date = null;
							try 
							{
								date = sf.parse(x);
							} catch (ParseException e) 
							{
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							holidays.add(date);
						}

					}
					mon++;
				}

			} catch (Exception e) 
			{
				System.out.println("EXCEPTION OCCURED IN TRAINER DAO");
			}
		}
		return holidays;
	}
}
