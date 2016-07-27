package com.niit.shoppingcartbackend.dao;

import java.util.List;

import javax.management.Query;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcartbackend.model.Category;
import com.niit.shoppingcartbackend.model.Supplier;

@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SupplierDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public void saveOrUpdate(Supplier supplier) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		Session session = (Session) sessionFactory.getCurrentSession();
		session.saveOrUpdate(supplier);
	}

	@Transactional
	public void delete(String id)
	{
		// TODO Auto-generated method stub
		Supplier Ctd = new Supplier();
		Ctd.setId(id);
		sessionFactory.getCurrentSession().delete(Ctd);

	}

	@Transactional
	public Supplier get(String id) {
		String hql = "from Category where id=" + "'" + id + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		List<Supplier> listSupplier = ((Criteria) query).list();
		if (listSupplier != null && !listSupplier.isEmpty()) {
			return listSupplier.get(0);
		}
		return null;
	}


	@Transactional
	public List<Supplier> list() {
		@SuppressWarnings("unchecked")
		List<Supplier> listSupplier = (List<Supplier>) sessionFactory.getCurrentSession().createCriteria(Supplier.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listSupplier;
	}

	

}
