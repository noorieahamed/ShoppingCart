package com.niit.shoppingcart.testcase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

//import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Supplier;

public class SupplierDAOTestCase{

	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static SupplierDAO supplierDAO;
	
	@Autowired
	private static Supplier supplier;
	 
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
		//ask the context to get instance of SupplierDAO		
		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
		//ask the context to get instance of Supplier
		supplier = (Supplier) context.getBean("supplier");
	}
	
	@Test
	public void saveSupplierTestCase()
	{
		supplier = new Supplier();
		supplier.setId("SUP-001");
		supplier.setName("Big Bazaar");
		supplier.setAddress("Niit,Chennai");
		
				
		
		boolean status = supplierDAO.save(supplier);		
		assertEquals("save supplier test case",true,status);
	}
	
	/*@Test
	public void updateSupplierTestCase()
	{
		
		supplier.setId("SUP-002");
		supplier.setName("DeMart");
		supplier.setAddress("Royapuram,Chennai");
		
		boolean status=supplierDAO.update(supplier);
		assertEquals("update test case",true,status );
	}
*/	
	@Test
	public void getSupplierSuccessTestCase()
	{
		supplier = supplierDAO.get("SUP-001");
		assertNotNull("get supplier test case", supplier);
	}
	
	@Test
	public void getSupplierFailureTestCase()
	{
		supplier = supplierDAO.get("SUP-001");
		assertNull("get supplier test case", supplier);
	}
	
	@Test
	public void deleteSupplierSuccessTestCase()
	{
		boolean status = supplierDAO.delete("SUP-001");
		assertEquals("delete supplier success test case",true,status);
	}
	
	@Test
	public void deleteSupplierFailureTestCase()
	{
		boolean status = supplierDAO.delete("SUP-001");
		assertEquals("delete supplier failure test case",false,status);
	}
	
	/*@Test
	public void getAllSuppliersTestCase()
	{
		java.util.List<Supplier> suppliers=supplierDAO.list();
		assertEquals("get all suppliers",3,suppliers.size());
	}
	*/
	
}
