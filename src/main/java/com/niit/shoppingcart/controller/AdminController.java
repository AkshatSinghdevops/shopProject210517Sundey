package com.niit.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Supplier;

@Controller
public class AdminController {
	
	
	//define 3 methods
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	Category  category;
	
	@Autowired
	SupplierDAO supplierDAO;
	
	@Autowired
	Supplier supplier;
	
   	
	
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
	
	@RequestMapping("/ManageSupplier")
	public ModelAndView manageSupplier()
	{
		System.out.println("Manage Suppplier");
		ModelAndView mv = new ModelAndView("/index");
		mv.addObject("ClickedSupplier",true);
		mv.addObject("Entry","SupplierPage");
		
		List<Supplier> supplierList = supplierDAO.list();
		mv.addObject("supplierList", supplierList);
		mv.addObject("supplier",supplier);
		
		
		return mv;
	}
	
	
	
	

}

