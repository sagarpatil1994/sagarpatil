package com.niit.shoppingcartbackend.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcartbackend.model.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;
	public UserDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}

	@Transactional
	public List<User> list() {
		List<User> listUser=(List<User>)
				sessionFactory.getCurrentSession().createCriteria(User.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		// TODO Auto-generated method stub
		return listUser;
	}

	@Transactional
	public User get(String id) {
		String hql = "from User where id=" + "'" + id + "'";
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		List<User> listUser = query.list();
		if (listUser != null && !listUser.isEmpty()) {
		   return listUser.get(0);
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public void saveOrUpdate(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		Session session = (Session) sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
		// TODO Auto-generated method stub
		
	}

	@Transactional
	public void delete(String id) {
		User Ctd = new User();
		Ctd.setId(id);
		sessionFactory.getCurrentSession().delete(Ctd);
		// TODO Auto-generated method stub
		
	}

}
