package com.niit.shoppingcart.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.Supplier;
import com.niit.shoppingcart.util.FileUtil;
import com.niit.shoppingcart.util.Util;




@Controller
public class ProductController2 {
	
	
	
	
		@Autowired
	private Category category;

	@Autowired
	private Supplier supplier;
	
	@Autowired(required = true)
	private ProductDAO productDAO;

	@Autowired(required = true)
	private CategoryDAO categoryDAO;
	
	@Autowired(required = true)
	private Product product;

	@Autowired(required = true)
	private SupplierDAO supplierDAO;
	
	
	/*@PostMapping(value="/saveProduct")
	public ModelAndView saveMCQuestion(@RequestParam(value = "id", required =   
			true)String id,@RequestParam("name")String name,
			@RequestParam("description") String description,@RequestParam("price") String price,
			@RequestParam("category_id") String category_id,@RequestParam("supplier_id") String supplier_id,
			
			@RequestParam("image") MultipartFile image,
			
		
			
			@ModelAttribute Product Product)throws IOException
	
	{
		ModelAndView modelAndView = new ModelAndView("redirect:/ManageProduct");
		
//begin the uploading section

		byte[] imageFile=null;
		
		if(!image.isEmpty() ){
		try{
			imageFile= image.getBytes();
		
			BufferedOutputStream stream= 
					new BufferedOutputStream(new FileOutputStream(new File(id)));
			stream.write(imageFile);
			
			stream.close();
			System.out.println("Successful Upload");
		}catch(Exception e){
			return null;
		}	}
		
		
//end Uploading section
		product.setId(id);
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setCategory_id(category_id);
        product.setSupplier_id(supplier_id);
        product.setImage(image);
		
	 
		if(productDAO.save(Product))
		{
			modelAndView.addObject("message", "Successfully created the category");
		}
		else
		{
			modelAndView.addObject("message", "Not able to create Category.  Pl contact Administrator");
		}
		return modelAndView;
		
	}
	*/
	
	
	
	
	
	
	

//===========================================================================================================================

	//Actually we have to keep this path in a property file
	//private String path = "D:\\ShoppingCart\\Images";
	
	//private String path = "resources/img/";
 // private String path   ="C://Users//Vaio//Searches//Desktop//New folder//MainNiitProject-master//src//main//webapp//resources//images";
	
	// get the path where you downloaded tomcat
  //D:\Softwares\Server\apache-tomcat-9.0.0.M6
  //private  String path =System.getProperty("catalina.home");
    
 /* @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String addProductPost1(@ModelAttribute("product") Product product, @RequestParam("image") MultipartFile file,
			BindingResult result, Model model, HttpServletRequest request) {
	  
	  
	  
	  List<Category> categoryList=	categoryDAO.list();
	//To access category domain object in category.jsp
	  
	  List<Supplier> supplierList  = supplierDAO.list();
		
		
		if (result.hasErrors()) {
			
			model.addAttribute("error", "Binding Result has error");
			return "error";
		}

		List<Product> productList = productDAO.getAllProducts();

		try {
			for (int i = 0; i < productList.size(); i++) {
				if (product.getName().equalsIgnoreCase(productList.get(i).getName())) {
					model.addAttribute("duplicateProduct", "This product is already exists");
					
					return "Admin/Product";
				}
			}

			
			product.setStatus("Running");
			boolean flag = productDAO.save(product);
			
			file = product.getImage();
		

			
			String filename = product.getId() + ".jpg";
			
			FileUtil.upload(path, file, filename);
			if (flag) {
				model.addAttribute("success", "Product added successfully");
				
				return "Admin/Product";
			} else {
				model.addAttribute("error", "Adding product Failed, Please try again !");
				
				return "Admin/AdminHome";
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			model.addAttribute("catchError", "Server is not responding please try again letter.\n" + e);
			return "error";
		}
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public String filterProduct1(@RequestParam("filter") String filter, Model model) {
		try {
			
			model.addAttribute("product", product);
			List<Product> productList = productDAO.viewByStatus(filter);
			model.addAttribute("productList", productList);
			
			return "Admin/Product";
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("catchError", "Server is not responding please try again letter.\n" + e);
			return "error";
		}
	}*/
//===========================================================================================================================
	
	
	@RequestMapping(value = "/add_Product_Value" , method = {RequestMethod.POST})
	public String addProduct(@Valid @ModelAttribute("product") Product product,BindingResult result,
			HttpServletRequest request,@RequestParam String action ,Model model)
	{
		/*log.debug("The Starting  of Add Method");
		log.info("the product id is"+product.getId());
		log.info("the product id is"+product.getName());
		log.info("the product id is"+product.getDescription());
		log.info("the product id is"+product.getCategory_id());
		log.info("the product id is"+product.getSupplier_id());
		log.info("the product id is"+product.getFile());
		*/
		
		if (result.hasErrors()) {
			model.addAttribute("product", product);
			model.addAttribute("products", productDAO.list());
			System.out.println("Found Errors in inputs");
			return "/Admin";
		}
		
		if(action.equals("save")){
			
			
			
			productDAO.save(product);
			
			MultipartFile file = product.getImage();
			String originalFile = file.getOriginalFilename();

			String path = request.getSession().getServletContext().getRealPath("C:\\Users\\Vaio\\Searches\\Desktop\\New folder\\MainNiitProject-master\\src\\main\\webapp\\resources\\images\\");
			System.out.println("File path is " + path);
			String filename = path + "\\" + product.getId() + ".jpg";
			System.out.println("File path is " + path);

			try {
				byte image[] = product.getImage().getBytes();
				BufferedOutputStream bof = new BufferedOutputStream(new FileOutputStream(filename));
				bof.write(image);
				bof.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}else {
			productDAO.update(product);
			
			MultipartFile file = product.getImage();
			String originalFile = file.getOriginalFilename();

			String path = request.getSession().getServletContext().getRealPath("resources/images/");
			System.out.println("File path is " + path);
			String filename = path + "\\" + product.getId() + ".jpg";
			System.out.println("File path is " + path);

			try {
				byte image[] = product.getImage().getBytes();
				BufferedOutputStream bof = new BufferedOutputStream(new FileOutputStream(filename));
				bof.write(image);
				bof.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}
		model.addAttribute("product", product);
		model.addAttribute("productList", productDAO.list());
		model.addAttribute("category", category);
		model.addAttribute("categoryList", categoryDAO.list());
		model.addAttribute("supplier", supplier);
		model.addAttribute("supplierList", supplierDAO.list());
		model.addAttribute("isAdminClickedproducts", true);		
	return "/Admin/AdminHome";
	}
	

}
