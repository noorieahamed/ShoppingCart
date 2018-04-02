package com.niit.shoppingcartfrontend;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Supplier;

@Controller
public class HomeController {
	@Autowired
	private CategoryDAO categoryDAO;
	
	/*@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	private Supplier supplier;*/
	@Autowired
	private Category category;
	@Autowired
	private HttpSession httpSession;
	//http://localhost:8080/ShoppingCartFrontEnd/
		@GetMapping("/")
		public ModelAndView  home()
		{
			
			ModelAndView mv = new ModelAndView("home");
			//add the data to mv
			//mv.addObject("categories", "Categories");
			httpSession.setAttribute("categories","categories");
			
			return mv;
			
		}
//		@GetMapping("/")
//		//@RequestMapping(name="/supplier/get/{ID}",method=RequestMethod.GET)
//		public ModelAndView getSupplier(@RequestParam("id") String id)
//		{
//			//based on id,fetch the details from supplierDAO
//			supplier = supplierDAO.get(id);
//			
//			//navigate to home page
//			ModelAndView mv=new ModelAndView("home");
//			mv.addObject("supplier",supplier);
//			return mv;
//		}
		@GetMapping("/login")
		public ModelAndView  login()
		{
			
			ModelAndView mv = new ModelAndView("home");
			mv.addObject("isUserClickedLogin", true);
			return mv;
			
		}
		
		
		@GetMapping("/logout")
		public ModelAndView logout()
		{
			//at the time of login,we add user id in http session
			//at the time of logout,we need to remove user id from http session,
			ModelAndView mv = new ModelAndView("home");
			httpSession.invalidate();
			mv.addObject("logoutMessage","you are successfully logged out");
			return mv;
			
		}
		
		@GetMapping("/register")
		public ModelAndView  registration()
		{
			
			ModelAndView mv = new ModelAndView("home");
			mv.addObject("isUserClickedRegister", true);
			return mv;
			
		}

	}



