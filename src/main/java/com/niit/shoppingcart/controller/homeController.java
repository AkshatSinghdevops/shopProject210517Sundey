package com.niit.shoppingcart.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.User;

@Controller
public class homeController {
	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private User user;
	
	@RequestMapping("/")
	public ModelAndView showHomePage()
	{
		
		//Specifying which page you have navigateion
		ModelAndView mv = new ModelAndView("/index");
		
		//Specify what data you have to carry to home page
		
		mv.addObject("msg", "WELCOME TO SHOPPING CART");
		
		return mv;
	}
	@RequestMapping("/Login")
	public ModelAndView showLoginPage()
	{
		ModelAndView mv = new ModelAndView("/index");
		mv.addObject("msg", " Home Page");
		mv.addObject("isUserClickedLogin","true");
		return mv;
	}

	@RequestMapping("/Registration")
	public ModelAndView showRegistrationPage()
	{
		ModelAndView mv = new ModelAndView("/index");
		mv.addObject("msg", " WELCOME TO Registration page ");
		mv.addObject("isUserClickedRegistration","true");
		return mv;
	}
	
	@RequestMapping("/Contact")
	public ModelAndView showContactPage()
	{
		ModelAndView mv = new ModelAndView("/index");
		mv.addObject("msg", " WELCOME TO LOGIN PAGE");
		mv.addObject("isUserClickedContact","true");
		return mv;
	}
	@RequestMapping("/Menu")
	public ModelAndView showMenuPage()
	{
		ModelAndView mv = new ModelAndView("/index");
		mv.addObject("msg", "  WELCOME TO LOGIN PAGE");
		mv.addObject("isUserClickedMenu","true");
		return mv;
	}
	

	
	@RequestMapping("/validate")
	public ModelAndView showValidatePage(@RequestParam("userID") String id, @RequestParam("password") String pwd )
	{
		
				
		       ModelAndView mv = new ModelAndView("/index");
				
			
				
				if(userDAO.validate(id,pwd)==true)
				
				{
					user = userDAO.getUser(id);
					
					if(user.getRole().equals("Role_Admin"))
					{
						mv.addObject("isAdmin","true");
						mv.addObject("role","Admin");
					}
					else
					{
						mv.addObject("isAdmin","false");
						mv.addObject("role","User");
					}
					
					mv.addObject("successMessage", "Valid Credentials");
					session.setAttribute("loginMessage", "Welcome :"+id );
				}
				else
				{
					mv.addObject("errorMessage", "InValid Credentials...please try again");
				}
				
				return mv;
				
			}
			
			
			
			@RequestMapping("/logout")
			public ModelAndView logout()
			{
				ModelAndView mv =new ModelAndView("/index");
				
				//session.invalidate();
				session.removeAttribute("loginMessage");
				return mv;
				
			}
			
			
			@RequestMapping("/Product")
			public ModelAndView showProductPage()
			{
				ModelAndView mv = new ModelAndView("/index");
				mv.addObject("msg", " Shop now hurry up ");
				mv.addObject("isUserClickedProduct","true");
				return mv;
			}
			
			
			
			
			
			
			
			
			
			
			

}
