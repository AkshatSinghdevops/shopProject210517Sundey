package com.niit.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;

@Controller
public class AdminController {
	
	
	//define 3 methods
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	Category  category;
	
	
	
	@RequestMapping("/ManageCategory")
	public ModelAndView manageCategories()
	{
		System.out.println("manageCategories");
		ModelAndView mv = new ModelAndView("/index");
		mv.addObject("isUserClickedCategories", "true");
		
		//get the categories from db.
		
	  List<Category> categoryList=	categoryDAO.list();
	  mv.addObject("categoryList", categoryList);
	  mv.addObject("category", category);//To access category domain object in category.jsp
		
		return mv;
		
	}
	
	@RequestMapping("/ManageProduct")
	public ModelAndView manageProduct()
	{
		System.out.println("Manage Products");
		ModelAndView mv = new ModelAndView("/index");
		mv.addObject("isUserClickedProduct","true");
		
		
		return mv;
	}
	
	
	
	

}

