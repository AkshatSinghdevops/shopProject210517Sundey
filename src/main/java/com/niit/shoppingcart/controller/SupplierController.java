package com.niit.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Supplier;

@Controller
public class SupplierController {
	
	
	@Autowired
	private Supplier supplier;
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	
	
	@PostMapping("/manage_supplier_create")
	public ModelAndView createSupplier(@RequestParam("id")String id, 
			@RequestParam("name")String name, @RequestParam("address")String address)
	{
		
		supplier.setId(id);
		supplier.setName(name);
		supplier.setAddress(address);
		
		ModelAndView mv = new ModelAndView("redirect:/ManageSupplier");
		
		if (supplierDAO.save(supplier))
		{
			mv.addObject("message", "Successfully created the category");
		}
		else
		{
			mv.addObject("message", "Not able to create Category.  Pl contact Administrator");
		}
		
		return mv;
		
	}

}
