package com.niit.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
public class ProductController {
	
	
	/*@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private Product product;
	
	
	@PostMapping(value="/saveProduct")
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
	
	
	
	
	@Autowired(required = true)
	private ProductDAO productDAO;

	@Autowired(required = true)
	private CategoryDAO categoryDAO;
	
	@Autowired(required = true)
	private Product product;

	@Autowired(required = true)
	private SupplierDAO supplierDAO;

	//Actually we have to keep this path in a property file
	//private String path = "D:\\ShoppingCart\\Images";
	
	//private String path = "resources/img/";
  private String path   ="C:\\Users\\Vaio\\Searches\\Desktop\\New folder\\MainNiitProject-master\\src\\main\\webapp\\resources\\images";
	
	// get the path where you downloaded tomcat
  //D:\Softwares\Server\apache-tomcat-9.0.0.M6
  //private  String path =System.getProperty("catalina.home");
    
	
	@RequestMapping("/search_product/{search_string}")
	public ModelAndView getAllProductBySearchString(@PathVariable("search_string")
		String search_string)
	{
	  List<Product> products=	 productDAO.getSimilarProducts(search_string);
	  ModelAndView mv= new ModelAndView("/Home");
	  
	  if(products.isEmpty())
	  {
		  mv.addObject("msg", "No products are available with the search text :" +search_string );
	  }
	  else
	  {
		  mv.addObject("productList", products);
	  }
  
	  return mv;
	
	}
 	@RequestMapping(value = "/manage_products", method = RequestMethod.GET)
	public String listProducts(Model model) {
		model.addAttribute("product", new Product());
		/*model.addAttribute("category", new Category());
		model.addAttribute("supplier", new Supplier());*/
		model.addAttribute("productList", this.productDAO.list());
		/*model.addAttribute("categoryList", this.categoryDAO.list());
		model.addAttribute("supplierList", this.supplierDAO.list());*/
		model.addAttribute("isAdminClickedProducts", "true");
		return "/Home";
	}

	// For add and update product both
	@RequestMapping(value = "/manage_product_add", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") Product product,
			 @RequestParam("image") MultipartFile file, Model model) {
	
		
		Category category = categoryDAO.getCategoryByName(product.getCategory().getId());
		// categoryDAO.saveOrUpdate(category); // why to save??

		Supplier supplier = supplierDAO.getSupplierByName(product.getSupplier().getId());
		// supplierDAO.saveOrUpdate(supplier); // Why to save??

		product.setCategory(category);
		product.setSupplier(supplier);

		product.setCategory_id(category.getId());
		product.setSupplier_id(supplier.getId());
		product.setId(Util.removeComman(product.getId()));
		productDAO.save(product);

		FileUtil.upload(path, file, product.getId() + ".jpg");
		model.addAttribute("isAdminClickedProducts", "true");
		model.addAttribute("productList", this.productDAO.list());
		model.addAttribute("product", new Product());
		model.addAttribute("categoryList", this.categoryDAO.list());
		model.addAttribute("category", new Category());
		
		return "/AdminHome";
		// return "redirect:/uploadFile";

	}

	@RequestMapping("manage_product/remove/{id}")
	public String removeProduct(@PathVariable("id") String id, ModelMap model) throws Exception {
		try {
			productDAO.delete(id);
			model.addAttribute("message", "Successfully Added");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}
		return "forward:/manage_products";
	}

	@RequestMapping("manage_product/edit/{id}")
	public String editProduct(@PathVariable("id") String id, Model model) {
		//categoryDAO.saveOrUpdate(category);
		
		product = productDAO.get(id);
		model.addAttribute("selectedProduct", product);
		return "forward:/manage_products";
	}

	// Get select product details
	@RequestMapping("manage_product/get/{id}")
	public ModelAndView getSelectedProduct(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView("redirect:/");
		redirectAttributes.addFlashAttribute("selectedProduct",  productDAO.get(id));
	
		return mv;

	}

		

	

}
