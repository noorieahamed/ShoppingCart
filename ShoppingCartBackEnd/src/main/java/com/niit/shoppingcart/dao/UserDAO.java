package com.niit.shoppingcart.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.niit.shoppingcart.domain.User;

@Service
public interface UserDAO {
	
	public boolean save(User user);
	
	public boolean update(User user);
	
	public User get(String EmailID);
	
	public boolean delete(String EmailID);
	
	public List<User> list();
	
	public User validate(String EmailID,String password);

}
