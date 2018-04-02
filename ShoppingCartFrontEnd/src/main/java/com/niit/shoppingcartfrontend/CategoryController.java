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

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;

import antlr.collections.List;

@Controller
public class CategoryController {
	//we need to call CategoryDAO methodss
	//get,save,update,delete,list
	
	//private static final Category Id = null;

	//1.inject the CategoryDAO and Category
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private Category category;
	
	@Autowired HttpSession httpSession;
	
	
	//http://localhost:8080/shoppingcart/category/get/cate_001
	//@GetMapping("/Category/get/{ID}")
	@RequestMapping(name="/category/get/{ID}",method=RequestMethod.GET)
	public ModelAndView getCategory(@RequestParam("id") String id)
	{
		//based on id,fetch the details from categoryDAO
		category = categoryDAO.get(id);
		
		//navigate to home page
		ModelAndView mv=new ModelAndView("home");
		mv.addObject("category",category);
		return mv;
		
		
		
	}

	@PostMapping("/category/save/")
	
	//public ModelAndView saveCategory(@RequestParam("Id") String Id, @RequestParam("Id") String name,@RequestParam("Id") String description,)
	
	
	public  ModelAndView saveCategory(@RequestParam("id") String id, @RequestParam("name") String name,@RequestParam("description") String description)
	{
		//navigate to home page
		ModelAndView mv = new ModelAndView("home");
		
		category.setId(id);
		category.setName(name);
		category.setDescription(description);
		//save into db
		if(categoryDAO.save(category))
		{
			//add success message
			mv.addObject("categorySuccessMessage","The category created successfully");
			//fetch all the categories again
			
		
		}
		
		else
		{
			//add failuare messsage
			mv.addObject("categoryErrorMessage","could not create the category.Please contract the admin");
		}
		return mv;
	}
		
		
		

		@PutMapping("/category/update/")
		
		//public ModelAndView saveCategory(@RequestParam("Id") String Id, @RequestParam("Id") String name,@RequestParam("Id") String description,)
		
		
		public ModelAndView updateCategory(@RequestBody String id,String name,String description )
		{
			//navigate to home page
			ModelAndView mv = new ModelAndView("home");
			
			//call update method of categoryDAO
			if(categoryDAO.update(category)==true)
			{
				//add success message
				mv.addObject("successMessage","The category update successfully");
				
			}
			
			else
			{
				//add failuare messsage
				mv.addObject("errorMessage","could not update the category.");
			}
			return mv;
			
		}
			
			@GetMapping("/category/delete")
			
			//public ModelAndView saveCategory(@RequestParam("id") String Id, @RequestParam("Id") String name,@RequestParam("Id") String description,)
			
			
			public ModelAndView deleteCategory(@RequestParam  String id)
			{
				//navigate to home page
				ModelAndView mv = new ModelAndView("redirect:/managecategories");
				
				//we supposed to fetch the latest categories
				//and add to httpSession
				//based on id,fetch the deatials from categoryDAO
				
				if(categoryDAO.delete(id)==true)
				{
					//add success message
					mv.addObject("successMessage","The category delete successfully");
					
				}
				
				else
				{
					//add failuare messsage
					mv.addObject("errorMessage","could not delete the category.");
				}
				return mv;
			
			}
			
			
			@GetMapping("/category/edit")
			public ModelAndView editCategory(@RequestParam String id)
		
			{
				ModelAndView mv = new ModelAndView("redirect:/managecategories");
				//based on category id fetch category details
				category = categoryDAO.get(id);
				mv.addObject("selectedCategory",category);
				httpSession.setAttribute("selectedCategory",category);
				return mv;
				
			}
			
			@GetMapping("/categories")
			
			public ModelAndView getAllCategories()
			{
				ModelAndView mv=new ModelAndView("home");
				java.util.List<Category>  categories= categoryDAO.list();
				mv.addObject("categories",categories);
				return mv;
				
	}
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


