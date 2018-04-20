package com.niit.shoppingcart.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.niit.shoppingcart.domain.Product;

@Service
public interface ProductDAO {
	
	public boolean save(Product product);
	
	public boolean update(Product product);
	
	public Product get(String id);
	
	public boolean delete(String id);
	
	public List<Product> list();

	public List<Product> search(String searchString);

	



	
	//public Product validate(String id,String password);

}
