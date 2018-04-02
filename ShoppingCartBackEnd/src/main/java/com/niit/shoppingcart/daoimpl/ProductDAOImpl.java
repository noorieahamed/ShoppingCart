package com.niit.shoppingcart.daoimpl;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Product;

@Transactional
@Repository("productDAO") // will create instance of ProductDAOImpl
public class ProductDAOImpl implements ProductDAO {

	// first inject hibernate session
	// @Autowired

	@Autowired // session factory will automatically inject in this class
	private SessionFactory sessionFactory;

	@Autowired
	private Product product;

	public boolean save(Product product) {
		// store in the DB
		try {
			
			sessionFactory.getCurrentSession().save(product);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Product product) {

		try {
			
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}

	}

	public Product get(String id) {
		// fetch record based on email id and store in the class
		try {
			Product product = sessionFactory.getCurrentSession().get(Product.class,id);

		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
		return product;

	}

	public boolean delete(String id) {
		try {
			product = get(id);
			if (product != null) {
				sessionFactory.getCurrentSession().delete(product);
			} else {
				return false;
			}
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Product> list() {
		// TODO Auto-generated method stub
		return null;
	}

	/*public List<Product> list() {
		return sessionFactory.getCurrentSession().createQuery("from Product").list();
	}
*/
	/*public Product validate(String id, String mobilename) {
		Object Description = null;
		return (Product)sessionFactory.getCurrentSession().
		createCriteria(Product.class).
		add(Restrictions.eq("id",id )).
		add(Restrictions.eq("description",Description)).
		uniqueResult();
	}

	public List<Product> list() {
		// TODO Auto-generated method stub
		return null;
	}*/

	
}
