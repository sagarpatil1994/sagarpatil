package com.niit.chatappbackend.dao;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.chatappbackend.model.Event;

@Repository("eventDAO")
public class EventDAOImpl implements EventDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public EventDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public void saveOrUpdate(Event event) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(event);
		Session session = (Session) sessionFactory.getCurrentSession();
		session.saveOrUpdate(event);
	}

	@Transactional
	public void delete(int id)
	{
		// TODO Auto-generated method stub
		Event Ctd = new Event();
		Ctd.setId(id);
		sessionFactory.getCurrentSession().delete(Ctd);

	}

	@Transactional
	public Event get(String id)
	{
		System.out.println("Inside get "+id);
		String hql = "from Event where name=" + "'" + id + "'";
		//SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		//Session session=sessionFactory.getCurrentSession();
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Event> listEvent = query.list();
		System.out.println("Inside get "+listEvent.size());
		if (listEvent != null && !listEvent.isEmpty()) 
		{
			//System.out.println("Inside get if"+listEvent.size());
			return listEvent.get(0);
		}
		return null;
	}
	@Transactional
	public boolean isValidCredentials(String name,String password)
	{
		//select * from Event where id= 'niit' and password= 'niit' 
		String hql = "from Event where name = '" 
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
	public List<Event> list() {
		@SuppressWarnings("unchecked")
		List<Event> listEvent = (List<Event>) sessionFactory.getCurrentSession().createCriteria(Event.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listEvent;
	}
	
	@Transactional
	public boolean isValidEvent(String eventID, String password) {
		// select * from Event where id= 'niit' and password= 'niit'
		System.out.println(eventID + " " + password);
		String hql = "from Event where name = '" + eventID + "' and password = '" + password + "'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println("Inside isValidEvent");
		//List list = q.list();
		List<Event> list =  q.list();
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
