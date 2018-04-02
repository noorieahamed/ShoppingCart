package com.niit.shoppingcart.daoimpl;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;

@Transactional
@Repository("categoryDAO") // will create instance of CategoryDAOImpl
public class CategoryDAOImpl implements CategoryDAO {

	// first inject hibernate session
	// @Autowired

	@Autowired // session factory will automatically inject in this class
	private SessionFactory sessionFactory;

	@Autowired
	private Category category;

	public boolean save(Category category) {
		// store in the DB
		try {
			
			sessionFactory.getCurrentSession().saveOrUpdate(category);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Category category) {

		try {
			if(get(category.getId())==null) {
				return false;
			}
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}

	}

	public Category get(String id) {
		// fetch record based on email id and store in the class
		try {
			Category category = sessionFactory.getCurrentSession().get(Category.class,id);

		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
		return category;

	}

	public boolean delete(String id) {
		try {
			category = get(id);
			if (category != null) {
				sessionFactory.getCurrentSession().delete(category);
			} else {
				return false;
			}
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Category> list() {
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

	/*public Category validate(String id, String mobilename) {
		Object Description = null;
		return (Category)sessionFactory.getCurrentSession().
		createCriteria(Category.class).
		add(Restrictions.eq("id",id )).
		add(Restrictions.eq("description",Description)).
		uniqueResult();
	}
*/
//	public List<Category> list() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
