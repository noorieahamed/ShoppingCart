package com.niit.shoppingcart.daoimpl;

import java.sql.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.User;

@Transactional
@Repository("userDAO") // will create instance of UserDAOImpl
public class UserDAOImpl implements UserDAO {

	//Logger Log = LoggerFactory.getLogger(UserDAOImpl.class);
	//private static final Logger log = LoggerFactory.getLogger(UserDAOImpl.class);
	// first inject hibernate session
	// @Autowired

	@Autowired // session factory will automatically inject in this class
	private SessionFactory sessionFactory;

	@Autowired
	private User user;

	public boolean save(User user) {
		
		//Log.debug("Starting of the save method");
		// store in the DB
		try {
			user.setRole('c');
			user.setRegisteredDate(new Date(System.currentTimeMillis()) + "");
			sessionFactory.getCurrentSession().save(user);
			//log.debug("starting of the get method");
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(User user) {
		//Log.debug("Ending of the update method");
		try {
			if(get(user.getEmailId())==null) {
				return false;
			}
			sessionFactory.getCurrentSession().update(user);
			//Log.debug("Ending of the update method");
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			//Log.error("error occured in update method"+e.printStackTrace());
			return false;
		}

	}

	public User get(String EmailID) {
		// fetch record based on email id and store in the class
		try {
			User user = sessionFactory.getCurrentSession().get(User.class, EmailID);
			return user;

		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}

	}

	public boolean delete(String EmailID) {
		try {
			user = get(EmailID);
			if (user != null) {
				sessionFactory.getCurrentSession().delete(user);
			} else {
				return false;
			}
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<User> list() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	public User validate(String EmailID, String password) {
		//Log.debug("Starting of the validate method");
		//Log.info("user"+ emailId + "trying to login");
		return (User)sessionFactory.getCurrentSession().
		createCriteria(User.class).
		add(Restrictions.eq("EmailID",EmailID )).
		add(Restrictions.eq("pwd",password)).
		uniqueResult();
		
	}

	public User getUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
