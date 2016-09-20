package com.niit.chatappbackend.dao;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.chatappbackend.model.Blog;

@Repository("blogDAO")
public class BlogDAOImpl implements BlogDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public BlogDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public void saveOrUpdate(Blog blog) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(blog);
		Session session = (Session) sessionFactory.getCurrentSession();
		session.saveOrUpdate(blog);
	}

	@Transactional
	public void delete(int id)
	{
		// TODO Auto-generated method stub
		Blog Ctd = new Blog();
		Ctd.setId(id);
		sessionFactory.getCurrentSession().delete(Ctd);

	}

	@Transactional
	public Blog get(String id)
	{
		System.out.println("Inside get "+id);
		String hql = "from Blog where name=" + "'" + id + "'";
		//SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		//Session session=sessionFactory.getCurrentSession();
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Blog> listBlog = query.list();
		System.out.println("Inside get "+listBlog.size());
		if (listBlog != null && !listBlog.isEmpty()) 
		{
			//System.out.println("Inside get if"+listBlog.size());
			return listBlog.get(0);
		}
		return null;
	}
	@Transactional
	public boolean isValidCredentials(String name,String password)
	{
		//select * from Blog where id= 'niit' and password= 'niit' 
		String hql = "from Blog where name = '" 
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
	public List<Blog> list() {
		@SuppressWarnings("unchecked")
		List<Blog> listBlog = (List<Blog>) sessionFactory.getCurrentSession().createCriteria(Blog.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listBlog;
	}
	
	@Transactional
	public boolean isValidBlog(String blogID, String password) {
		// select * from Blog where id= 'niit' and password= 'niit'
		System.out.println(blogID + " " + password);
		String hql = "from Blog where name = '" + blogID + "' and password = '" + password + "'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println("Inside isValidBlog");
		//List list = q.list();
		List<Blog> list =  q.list();
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
