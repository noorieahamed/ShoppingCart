package com.niit.shoppingcartfrontend;


import java.util.List;
import java.util.function.Supplier;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;


@Controller

public class AdminController {

	@Autowired
	
private CategoryDAO categoryDAO;
	@Autowired
	
	private SupplierDAO supplierDAO;
@Autowired
	
	private ProductDAO productDAO;

	

@Autowired
	
private Category category;
	
@Autowired

private Product product;
	
@Autowired

private Supplier supplier;
	
@Autowired HttpSession httpSession;
	
	
@GetMapping("/managecategories")
	
public ModelAndView admincClickedCategories()
	{
		
	ModelAndView mv = new ModelAndView("home");
	mv.addObject("isAdminClickedManageCategories", true);
	//fetch all the categories again 
	List<Category> categories = categoryDAO.list();
	//and set to http session.
	httpSession.setAttribute("categories", categories);

		
return mv;
	
}
	
	
@GetMapping("/managesuppliers")

	public ModelAndView admincClickedSupplier()
	
{
		
ModelAndView mv = new ModelAndView("home");
		
mv.addObject("isAdminClickedManageSuppliers", true);
 List<com.niit.shoppingcart.domain.Supplier> suppliers = supplierDAO.list();
 httpSession.setAttribute("suppliers", suppliers);
 
		
return mv;
	
}
	
	
@GetMapping("/manageproducts")
	
public ModelAndView admincClickedProducts()
	
{
		
ModelAndView mv = new ModelAndView("home");
		

mv.addObject("isAdminClickedManageProducts", true);
//we have to fetch all categories and suppliers
//and set it to http session
List<Category> categories = categoryDAO.list();
List<com.niit.shoppingcart.domain.Supplier> suppliers = supplierDAO.list();
List<Product> products = productDAO.list();

httpSession.setAttribute("categories", categories);
httpSession.setAttribute("supppliers", suppliers);
httpSession.setAttribute("products", products);

return mv;
	
}


}







