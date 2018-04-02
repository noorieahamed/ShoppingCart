package com.niit.shoppingcart.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.domain.User;
import com.niit.shoppingcart.dao.UserDAO;


public class UserTestCase {

	
	
	@Autowired
	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static User user;
	
	@Autowired
	private static UserDAO userDAO;
	
	
	@BeforeClass
	public static void initialize()
	{
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		user = (User)context.getBean("user");
		userDAO = (UserDAO)context.getBean("userDAO");
		
	}
	
	
	@Test
	public void validateCredentialsTestCase()
	{
		
	  User flag	= userDAO.validate("niit", "niittttt");
	  
	  assertEquals("validateCredentialsTestCase " , true,flag );
		
	}
	
	
	
	
}











