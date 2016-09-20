package com.niit.shoppingcartbackend.dao;
import java.util.List;
import org.hibernate.Query;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcartbackend.model.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public void saveOrUpdate(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		Session session = (Session) sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
	}

	@Transactional
	public void delete(String id)
	{
		// TODO Auto-generated method stub
		User Ctd = new User();
		Ctd.setId(id);
		sessionFactory.getCurrentSession().delete(Ctd);

	}

	@Transactional
	public User get(String id)
	{
		System.out.println("Inside get "+id);
		String hql = "from User where name=" + "'" + id + "'";
		//SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		//Session session=sessionFactory.getCurrentSession();
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> listUser = query.list();
		System.out.println("Inside get "+listUser.size());
		if (listUser != null && !listUser.isEmpty()) 
		{
			//System.out.println("Inside get if"+listUser.size());
			return listUser.get(0);
		}
		return null;
	}
	@Transactional
	public boolean isValidCredentials(String name,String password)
	{
		//select * from User where id= 'niit' and password= 'niit' 
		String hql = "from User where name = '" 
				+ name + "' and password = '" + password + "'";
		Query q= sessionFactory.getCurrentSession().createQuery(hql);
		List list= q.list();
		if(list == null || list.isEmpty())
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	@Transactional
	public List<User> list() {
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUser;
	}
	
	@Transactional
	public boolean isValidUser(String userID, String password) {
		// select * from User where id= 'niit' and password= 'niit'
		System.out.println(userID + " " + password);
		String hql = "from User where name = '" + userID + "' and password = '" + password + "'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println("Inside isValidUser");
		//List list = q.list();
		List<User> list =  q.list();
		System.out.println(list.size());
		/*if (list == null && !list.isEmpty()) {
			return true;
		} else {
			return false;
		}*/
		if(list.size()==1)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

	

}
