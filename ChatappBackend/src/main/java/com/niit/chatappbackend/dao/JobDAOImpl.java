package com.niit.chatappbackend.dao;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.chatappbackend.model.Job;

@Repository("jobDAO")
public class JobDAOImpl implements JobDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public JobDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public void saveOrUpdate(Job job) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(job);
		Session session = (Session) sessionFactory.getCurrentSession();
		session.saveOrUpdate(job);
	}

	@Transactional
	public void delete(int id)
	{
		// TODO Auto-generated method stub
		Job Ctd = new Job();
		Ctd.setId(id);
		sessionFactory.getCurrentSession().delete(Ctd);

	}

	@Transactional
	public Job get(String id)
	{
		System.out.println("Inside get "+id);
		String hql = "from Job where name=" + "'" + id + "'";
		//SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		//Session session=sessionFactory.getCurrentSession();
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Job> listJob = query.list();
		System.out.println("Inside get "+listJob.size());
		if (listJob != null && !listJob.isEmpty()) 
		{
			//System.out.println("Inside get if"+listJob.size());
			return listJob.get(0);
		}
		return null;
	}
	@Transactional
	public boolean isValidCredentials(String name,String password)
	{
		//select * from Job where id= 'niit' and password= 'niit' 
		String hql = "from Job where name = '" 
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
	public List<Job> list() {
		@SuppressWarnings("unchecked")
		List<Job> listJob = (List<Job>) sessionFactory.getCurrentSession().createCriteria(Job.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listJob;
	}
	
	@Transactional
	public boolean isValidJob(String jobID, String password) {
		// select * from Job where id= 'niit' and password= 'niit'
		System.out.println(jobID + " " + password);
		String hql = "from Job where name = '" + jobID + "' and password = '" + password + "'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println("Inside isValidJob");
		//List list = q.list();
		List<Job> list =  q.list();
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
