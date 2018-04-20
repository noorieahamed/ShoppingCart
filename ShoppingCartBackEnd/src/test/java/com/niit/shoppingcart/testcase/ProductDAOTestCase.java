package com.niit.shoppingcart.testcase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

//import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Product;

public class ProductDAOTestCase {

	private static AnnotationConfigApplicationContext context;

	@Autowired
	private static ProductDAO productDAO;

	@Autowired
	private static Product product;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		// scan the complete package and check for annotations like
		// @component,@controller,@repository,@service
		context.scan("com.niit");
		// clear the context(bean factory and recreate all the
		// instances of the classes which are there in com.niit
		// with proper annotations
		context.refresh();
		// ask the context to get instance of ProductDAO
		productDAO = (ProductDAO) context.getBean("productDAO");
		// ask the context to get instance of Product
		product = (Product) context.getBean("product");
	}

	@Test
	public void saveProductTestCase() {
		product.setId("Lenova-001");
		product.setName("Lenova -- product");
		product.setDescription("this is a Lenova product");
		product.setCategoryId("WomensCategory001");
		product.setSupplierId("SUP-001");
		product.setPrice(15000);

		boolean status = productDAO.save(product);
		assertEquals("save product test case", true, status);
	}

	
	  @Test public void updateProductTestCase() {
	  
	  product.setId("Lenova-001"); 
	  product.setName("Lenova -- product");
	  product.setDescription("This is Lenova product");
	  
	  
	  boolean status=productDAO.update(product);
	  assertEquals("update test case",true,status ); }
	 

	@Test
	public void getProductSuccessTestCase() {
		product = productDAO.get("Lenova-001");
		assertNotNull("get product test case", product);
	}

	@Test
	public void getProductFailureTestCase() {
		product = productDAO.get("Lenova-001");
		assertNull("get product test case", product);
	}

	@Test
	public void deleteProductSuccessTestCase() {
		boolean status = productDAO.delete("Lenova-001");
		assertEquals("delete product success test case", true, status);
	}

	@Test
	public void deleteProductFailureTestCase() {
		boolean status = productDAO.delete("Lenova-001");
		assertEquals("delete product failure test case", false, status);
	}

	/*
	 * @Test public void getAllProductsTestCase() { java.util.List<Product>
	 * products=productDAO.list();
	 * assertEquals("get all products",3,products.size()); }
	 */

}
