package com.controller;

import java.awt.print.Book;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

	

		@RequestMapping("/onlogin")
		public ModelAndView showBookForm(ModelMap map)throws Exception{
			
			
			return new ModelAndView("bookForm");
		}
		
		@RequestMapping("/addBook")
		public ModelAndView addBook(@ModelAttribute("book")Book book)throws Exception{
			//bookdao.addBook(book);
			System.out.println("Adding Book");
			return new ModelAndView("ShowBook","book",book);
		}
		
		
	
}
