package com.niit.shoppingcart.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.niit.shoppingcart.domain.Cart;

@Service
public interface CartDAO {
	
	public boolean save(Cart cart);
	
	public boolean update(Cart cart);
	
	public Cart get(String ID);
	
	public boolean delete(String ID);
	
	
	//to get all the carts add by a particular user
	public List<Cart> list(String emailID);
	
	//public Cart validate(String ID,String mobilename);

	



}
