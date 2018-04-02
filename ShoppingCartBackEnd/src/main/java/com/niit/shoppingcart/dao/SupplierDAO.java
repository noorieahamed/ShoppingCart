package com.niit.shoppingcart.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.niit.shoppingcart.domain.Supplier;

@Service
public interface SupplierDAO {
	
	public boolean save(Supplier supplier);
	
	public boolean update(Supplier supplier);
	
	public Supplier get(String id);
	
	public boolean delete(String id);

	public List<Supplier> list();
	

	
	//public Supplier validate(String id,String password);

}
