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

import com.niit.shoppingcartbackend.model.Product;
import com.niit.shoppingcartbackend.model.Supplier;

@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public ProductDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public void saveOrUpdate(Product product) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		Session session = (Session) sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
	}

	@Transactional
	public void delete(String id)
	{
		// TODO Auto-generated method stub
		Product Ctd = new Product();
		Ctd.setId(id);
		sessionFactory.getCurrentSession().delete(Ctd);

	}

	@Transactional
	public Product get(String id) {
		String hql = "from Product where id=" + "'" + id + "'";
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		List<Product> listProduct = query.list();
		if (listProduct != null && !listProduct.isEmpty()) {
			return listProduct.get(0);
		}
		return null;
	}

	@Transactional
	public List<Product> list() {
		@SuppressWarnings("unchecked")
		List<Product> listProduct = (List<Product>) sessionFactory.getCurrentSession().createCriteria(Product.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listProduct;
	}

	

}
