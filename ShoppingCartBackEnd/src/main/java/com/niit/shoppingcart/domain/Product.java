package com.niit.shoppingcart.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.niit.shoppingcart.dao.SupplierDAO;

//whenever it scans all the classes under particular package,
//will create instance of this class.
	
	@Component
	@Entity
	@Table(name="product")
	public class Product {
 
		@Id
        private String id;
		private String name;
		private String description;
		private int price;
		
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		private String categoryId;
		private String supplierId;
		
		
		@ManyToOne
		@JoinColumn(name = "categoryId",updatable = false,insertable = false,nullable = false)
		private Category category;
		
		@ManyToOne
		@JoinColumn(name = "supplierid",nullable = false , updatable = false,insertable = false)
		private Supplier supplier;
		
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
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getCategoryId() {
			return categoryId;
		}
		
		public Category getCategory() {
			return category;
		}
		
		public void setSupplierId(String string) {
			// TODO Auto-generated method stub
			
		}
		public void setSupplierId(Supplier supplierId) {
			// TODO Auto-generated method stub
			this.supplier=supplier;

			
		}
		public void setCategoryId(Category category) {
			// TODO Auto-generated method stub
			this.categoryId=categoryId;

		}
		public void setCategoryId(String string) {
			// TODO Auto-generated method stub
			
		}
						
		
	}
		
		