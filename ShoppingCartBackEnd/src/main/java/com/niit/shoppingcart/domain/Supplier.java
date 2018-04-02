package com.niit.shoppingcart.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

//whenever it scans all the classes under particular package,
//will create instance of this class.
	
	@Component
	@Entity
	@Table(name="supplier")
	public class Supplier {
 
		@Id
		private String id;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		private String name;
		private String address;
		public void setProduct(Set<Product> products) {
			this.products = products;
		}
		
		@OneToMany(mappedBy="supplier",fetch=FetchType.EAGER)
		private Set<Product> products;
		
		
		
		public Set<Product> getProducts(){
			
			return products;
		}
		public void setProducts(Set<Product> products) {
			this.products=products;
		}
	}
		