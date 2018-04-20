package com.niit.shoppingcart.testcase;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.domain.Cart;


public class CartDAOTestCase{

	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static CartDAO cartDAO;
	
	@Autowired
	private static Cart cart;
	
	
	 
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
		//ask the context to get instance of CartDAO		
		cartDAO = (CartDAO) context.getBean("cartDAO");
		//ask the context to get instance of Cart
		cart = (Cart) context.getBean("cart");
	}
	
	@Test
	public void saveCartTestCase()
	{
		cart = new Cart();
		cart.setId();
		cart.setEmailID("noorie@gmail.com");
		cart.setProductName("Lenova");
		cart.setPrice(15000);
		cart.setQuantity(1);
		cart.setProductID("Lenova001");
				
		
		boolean status = cartDAO.save(cart);		
		assertEquals("save cart test case",true,status);
	}
	
	@Test
	public void updateCartTestCase()
	{
		
		cart.setEmailID("sara@gmail.com");
		/*cart.setName("Mobile");
		cart.setDescription("This is a mobile cart");
		
		boolean status=cartDAO.update(cart);
		assertEquals("update cart test case",true,status );*/
	}
	
	@Test
	public void getCartSuccessTestCase()
	{
		cart = cartDAO.get("noorie@gmail.com");
		assertNotNull("get cart test case", cart);
	}
	
	@Test
	public void getCartFailureTestCase()
	{
		cart = cartDAO.get("sara@gmail.com");
		assertNull("get cart test case", cart);
	}
	
	@Test
	public void deleteCartSuccessTestCase()
	{
		boolean status = cartDAO.delete("soni@gmail.com");
		assertEquals("delete cart success test case",true,status);
	}
	
	@Test
	public void deleteCartFailureTestCase()
	{
		boolean status = cartDAO.delete("fiza@gmail.com");
		assertEquals("delete cart failure test case",false,status);
	}
	
	@Test
	public void getAllCartsTestCase()
	{
		List<Cart> carts = cartDAO.list("EmailID");
		assertEquals("get all users",3,carts.size());
	}
	
	
	
	
	
	
	
	

}
