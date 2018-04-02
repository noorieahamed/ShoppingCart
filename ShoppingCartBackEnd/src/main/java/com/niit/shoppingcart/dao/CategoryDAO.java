package com.niit.shoppingcart.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.niit.shoppingcart.domain.Category;

@Service
public interface CategoryDAO {
	
	public boolean save(Category category);
	
	public boolean update(Category category);
	
	public Category get(String ID);
	
	public boolean delete(String ID);
	
	public List<Category> list();
	
	//public Category validate(String ID,String mobilename);

	



}
