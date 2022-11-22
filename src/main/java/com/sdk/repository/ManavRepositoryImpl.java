package com.sdk.repository;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sdk.domain.Manav;

@Component
public class ManavRepositoryImpl implements ManavRepository{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Manav> getAll() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		List<Manav> manavList=session.createQuery("From Manav order by id",Manav.class).getResultList();
		tx.commit();
		session.close();
		return manavList;
	}

	@Override
	public Optional<Manav> findById(Integer id) {
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		Manav manav= session.get(Manav.class, id);
		Optional<Manav> opt=null;
		opt=Optional.ofNullable(manav);
		tx.commit();
		session.close();
		return opt;
	}

	@Override
	public void save(Manav manav) {
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		session.saveOrUpdate(manav);
		tx.commit();
		session.close();
	}

	@Override
	public void update(Manav manav) {
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		session.update(manav);
		tx.commit();
		session.close();
	}

	@Override
	public void delete(Integer id) {
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		Manav manav=session.load(Manav.class, id);
		session.delete(manav);
		tx.commit();
		session.close();
	}

}
