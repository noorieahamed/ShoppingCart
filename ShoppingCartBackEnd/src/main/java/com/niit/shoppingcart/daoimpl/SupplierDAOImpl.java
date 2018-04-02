package com.niit.shoppingcart.daoimpl;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Supplier;

@Transactional
@Repository("supplierDAO") // will create instance of SupplierDAOImpl
public class SupplierDAOImpl implements SupplierDAO {

	// first inject hibernate session
	// @Autowired

	@Autowired // session factory will automatically inject in this class
	private SessionFactory sessionFactory;

	@Autowired
	private Supplier supplier;

	public boolean save(Supplier supplier) {
		// store in the DB
		try {
			
			sessionFactory.getCurrentSession().save(supplier);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Supplier supplier) {

		try {
			
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}

	}

	public Supplier get(String emailID) {
		// fetch record based on email id and store in the class
		try {
			Supplier supplier = sessionFactory.getCurrentSession().get(Supplier.class,emailID);

		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
		return supplier;

	}

	public boolean delete(String emailID) {
		try {
			supplier = get(emailID);
			if (supplier != null) {
				sessionFactory.getCurrentSession().delete(supplier);
			} else {
				return false;
			}
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	/*public List<Supplier> list() {
		return sessionFactory.getCurrentSession().createQuery("from Supplier").list();
	}
*/
	/*public Supplier validate(String id, String mobilename) {
		Object Description = null;
		return (Supplier)sessionFactory.getCurrentSession().
		createCriteria(Supplier.class).
		add(Restrictions.eq("id",id )).
		add(Restrictions.eq("Address",address)).
		uniqueResult();
	}
*/
	public List<Supplier> list() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Supplier").list();
	}

}
