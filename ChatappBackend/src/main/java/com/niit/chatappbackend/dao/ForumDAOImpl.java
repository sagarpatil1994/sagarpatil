package com.niit.chatappbackend.dao;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.chatappbackend.model.Forum;

@Repository("forumDAO")
public class ForumDAOImpl implements ForumDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public ForumDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public void saveOrUpdate(Forum forum) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(forum);
		Session session = (Session) sessionFactory.getCurrentSession();
		session.saveOrUpdate(forum);
	}

	@Transactional
	public void delete(int id)
	{
		// TODO Auto-generated method stub
		Forum Ctd = new Forum();
		Ctd.setId(id);
		sessionFactory.getCurrentSession().delete(Ctd);

	}

	@Transactional
	public Forum get(String id)
	{
		System.out.println("Inside get "+id);
		String hql = "from Forum where name=" + "'" + id + "'";
		//SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		//Session session=sessionFactory.getCurrentSession();
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Forum> listForum = query.list();
		System.out.println("Inside get "+listForum.size());
		if (listForum != null && !listForum.isEmpty()) 
		{
			//System.out.println("Inside get if"+listForum.size());
			return listForum.get(0);
		}
		return null;
	}
	@Transactional
	public boolean isValidCredentials(String name,String password)
	{
		//select * from Forum where id= 'niit' and password= 'niit' 
		String hql = "from Forum where name = '" 
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
	public List<Forum> list() {
		@SuppressWarnings("unchecked")
		List<Forum> listForum = (List<Forum>) sessionFactory.getCurrentSession().createCriteria(Forum.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listForum;
	}
	
	@Transactional
	public boolean isValidForum(String forumID, String password) {
		// select * from Forum where id= 'niit' and password= 'niit'
		System.out.println(forumID + " " + password);
		String hql = "from Forum where name = '" + forumID + "' and password = '" + password + "'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println("Inside isValidForum");
		//List list = q.list();
		List<Forum> list =  q.list();
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
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	

}
