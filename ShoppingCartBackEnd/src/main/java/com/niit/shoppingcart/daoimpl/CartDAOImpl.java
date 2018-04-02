package com.niit.shoppingcart.daoimpl;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.domain.Cart;

@Transactional
@Repository("cartDAO") // will create instance of CartDAOImpl
public class CartDAOImpl implements CartDAO {

	// first inject hibernate session
	// @Autowired

	@Autowired // session factory will automatically inject in this class
	private SessionFactory sessionFactory;

	@Autowired
	private Cart cart;

	public boolean save(Cart cart) {
		// store in the DB
		try {
			
			sessionFactory.getCurrentSession().saveOrUpdate(cart);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Cart cart) {

		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}

	}

	public Cart get(String id) {
		// fetch record based on email id and store in the class
		try {
			Cart cart = sessionFactory.getCurrentSession().get(Cart.class,id);

		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
		return cart;

	}

	public boolean delete(String id) {
		try {
			cart = get(id);
			if (cart != null) {
				sessionFactory.getCurrentSession().delete(cart);
			} else {
				return false;
			}
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Cart> list(String emailID) {
		return sessionFactory.getCurrentSession().createQuery("from Cart").list();
	}

	/*public Cart validate(String id, String mobilename) {
		Object Description = null;
		return (Cart)sessionFactory.getCurrentSession().
		createCriteria(Cart.class).
		add(Restrictions.eq("id",id )).
		add(Restrictions.eq("description",Description)).
		uniqueResult();
	}
*/
//	public List<Cart> list() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
