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

import com.niit.shoppingcartbackend.model.Cart;

@Repository("cartDAO")
public class CartDAOImpl implements CartDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public CartDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public void saveOrUpdate(Cart cart) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
		Session session = (Session) sessionFactory.getCurrentSession();
		session.saveOrUpdate(cart);
	}

	@Transactional
	public void delete(String id)
	{
		// TODO Auto-generated method stub
		Cart Ctd = new Cart();
		Ctd.setId(id);
		sessionFactory.getCurrentSession().delete(Ctd);

	}

	@Transactional
	public Cart get(String id) {
		String hql = "from Cart where id=" + "'" + id + "'";
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		List<Cart> listCart = query.list();
		if (listCart != null && !listCart.isEmpty()) {
			return listCart.get(0);
		}
		return null;
	}

	@Transactional
	public List<Cart> list() {
		@SuppressWarnings("unchecked")
		List<Cart> listCart = (List<Cart>) sessionFactory.getCurrentSession().createCriteria(Cart.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listCart;
	}
	
	

}