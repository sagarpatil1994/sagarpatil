package com.niit.chatappbackend.dao;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.chatappbackend.model.Chat;
import com.niit.chatappbackend.model.Chat;

@Repository("chatDAO")
public class ChatDAOImpl implements ChatDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public ChatDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public void saveOrUpdate(Chat chat) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(chat);
		Session session = (Session) sessionFactory.getCurrentSession();
		session.saveOrUpdate(chat);
	}

	@Transactional
	public void delete(int id)
	{
		// TODO Auto-generated method stub
		Chat Ctd = new Chat();
		Ctd.setId(id);
		sessionFactory.getCurrentSession().delete(Ctd);

	}

	@Transactional
	public Chat get(String id)
	{
		System.out.println("Inside get "+id);
		String hql = "from Chat where name=" + "'" + id + "'";
		//SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		//Session session=sessionFactory.getCurrentSession();
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Chat> listChat = query.list();
		System.out.println("Inside get "+listChat.size());
		if (listChat != null && !listChat.isEmpty()) 
		{
			//System.out.println("Inside get if"+listChat.size());
			return listChat.get(0);
		}
		return null;
	}
	@Transactional
	public boolean isValidCredentials(String name,String password)
	{
		//select * from Chat where id= 'niit' and password= 'niit' 
		String hql = "from Chat where name = '" 
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
	public List<Chat> list() {
		@SuppressWarnings("unchecked")
		List<Chat> listChat = (List<Chat>) sessionFactory.getCurrentSession().createCriteria(Chat.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listChat;
	}
	
	@Transactional
	public boolean isValidChat(String chatID, String password) {
		// select * from Chat where id= 'niit' and password= 'niit'
		System.out.println(chatID + " " + password);
		String hql = "from Chat where name = '" + chatID + "' and password = '" + password + "'";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println("Inside isValidChat");
		//List list = q.list();
		List<Chat> list =  q.list();
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
