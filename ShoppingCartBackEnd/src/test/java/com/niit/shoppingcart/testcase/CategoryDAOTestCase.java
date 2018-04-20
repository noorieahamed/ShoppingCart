package com.niit.shoppingcart.testcase;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;


public class CategoryDAOTestCase{

	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static CategoryDAO categoryDAO;
	
	@Autowired
	private static Category category;
	
	
	 
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		//scan the complete package and check for annotations like
		//@component,@controller,@repository,@service
		context.scan("com.niit");
		//clear the context(bean factory and recreate all the
		//instances of the classes which are there in com.niit
		//with proper annotations
		context.refresh();
		//ask the context to get instance of CategoryDAO		
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		//ask the context to get instance of Category
		category = (Category) context.getBean("category");
	}
	
	@Test
	public void saveCategoryTestCase()
	{
		category = new Category();
		category.setId("vase001");
		category.setName("flower vase");
		category.setDescription("this is a vase");
				
		
		boolean status = categoryDAO.save(category);		
		assertEquals("save category test case",true,status);
	}
	
	@Test
	public void updateCategoryTestCase()
	{
		
		category.setId("mob-001");
		/*category.setName("Mobile");
		category.setDescription("This is a mobile category");
		
		boolean status=categoryDAO.update(category);
		assertEquals("update category test case",true,status );*/
	}
	
	@Test
	public void getCategorySuccessTestCase()
	{
		category = categoryDAO.get("noorie@gmail.com");
		assertNotNull("get category test case", category);
	}
	
	@Test
	public void getCategoryFailureTestCase()
	{
		category = categoryDAO.get("sara@gmail.com");
		assertNull("get category test case", category);
	}
	
	@Test
	public void deleteCategorySuccessTestCase()
	{
		boolean status = categoryDAO.delete("soni@gmail.com");
		assertEquals("delete category success test case",true,status);
	}
	
	@Test
	public void deleteCategoryFailureTestCase()
	{
		boolean status = categoryDAO.delete("fiza@gmail.com");
		assertEquals("delete category failure test case",false,status);
	}
	
	@Test
	public void getAllCategorysTestCase()
	{
		List<Category> categorys = categoryDAO.list();
		assertEquals("get all users",3,categorys.size());
	}
	
	
	
	
	
	
	
	

}
