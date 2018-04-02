package com.niit.shoppingcartfrontend;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Supplier;

import antlr.collections.List;

@Controller
public class SupplierController {
	//we need to call SupplierDAO methodss
	//get,save,update,delete,list
	
	//private static final Supplier Id = null;

	//1.inject the SupplierDAO and Supplier
	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	private Supplier supplier;
	
	@Autowired HttpSession httpSession;
	
	
	//http://localhost:8080/shoppingcart/supplier/get/cate_001
	//@GetMapping("/Supplier/get/{ID}")
	@RequestMapping(name="/supplier/get/{ID}",method=RequestMethod.GET)
	public ModelAndView getSupplier(@RequestParam("id") String id)
	{
		//based on id,fetch the details from supplierDAO
		supplier = supplierDAO.get(id);
		
		//navigate to home page
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("supplier",supplier);
		return mv;
		
		
		
	}

	@PostMapping("/supplier/save/")
	
	//public ModelAndView saveSupplier(@RequestParam("Id") String Id, @RequestParam("Id") String name,@RequestParam("Id") String description,)
	
	
	public  ModelAndView saveSupplier(@RequestParam("id") String id, @RequestParam("name") String name,@RequestParam("address") String address)
	{
		//navigate to home page
		ModelAndView mv = new ModelAndView("redirect:/managesuppliers");
		
		supplier.setId(id);
		supplier.setName(name);
		supplier.setAddress(address);
		//save into db
		if(supplierDAO.save(supplier))
		{
			//add success message
			mv.addObject("supplierSuccessMessage","The supplier created successfully");
			//fetch all the categories again
			
		
		}
		
		else
		{
			//add failuare messsage
			mv.addObject("supplierErrorMessage","could not able to create the supplier.Please contract the admin");
		}
		return mv;
	}
		
		
		

		@PutMapping("/supplier/update/")
		
		//public ModelAndView saveSupplier(@RequestParam("Id") String Id, @RequestParam("Id") String name,@RequestParam("Id") String description,)
		
		
		public ModelAndView updateSupplier(@RequestBody String id,String name,String address )
		{
			//navigate to home page
			ModelAndView mv = new ModelAndView("home");
			
			//call update method of supplierDAO
			if(supplierDAO.update(supplier)==true)
			{
				//add success message
				mv.addObject("successMessage","The supplier update successfully");
				
			}
			
			else
			{
				//add failuare messsage
				mv.addObject("errorMessage","could not update the supplier.");
			}
			return mv;
			
		}
			
			@GetMapping("/supplier/delete")
			
			//public ModelAndView saveSupplier(@RequestParam("id") String Id, @RequestParam("Id") String name,@RequestParam("Id") String description,)
			
			
			public ModelAndView deleteSupplier(@RequestParam  String id)
			{
				//navigate to home page
				ModelAndView mv = new ModelAndView("redirect:/managesuppliers");
				
				//we supposed to fetch the latest categories
				//and add to httpSession
				//based on id,fetch the deatials from supplierDAO
				
				if(supplierDAO.delete(id)==true)
				{
					//add success message
					mv.addObject("SupplierSuccessMessage","The supplier delete successfully");
					
				}
				
				else
				{
					//add failuare messsage
					mv.addObject("SupplierErrorMessage","could not delete the supplier.");
				}
				return mv;
			
			}
			
			
			@GetMapping("/supplier/edit")
			public ModelAndView editSupplier(@RequestParam String id)
		
			{
				ModelAndView mv = new ModelAndView("redirect:/managesuppliers");
				//based on supplier id fetch supplier details
				supplier = supplierDAO.get(id);
				mv.addObject("selectedSupplier",supplier);
				httpSession.setAttribute("selectedSupplier",supplier);
				return mv;
				
			}
			
			@GetMapping("/suppliers")
			
			public ModelAndView getAllSuppliers()
			{
				ModelAndView mv=new ModelAndView("home");
				java.util.List<Supplier> suppliers=supplierDAO.list();
				mv.addObject("suppliers",suppliers);
				return mv;
				
	}
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


