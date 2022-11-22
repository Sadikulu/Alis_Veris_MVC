package com.sdk.repository;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sdk.domain.Sepet;

@Component
public class SepetRepositoryImpl implements SepetRepository{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Sepet> getAll() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		List<Sepet> sepetList=session.createQuery("From Sepet order by id",Sepet.class).getResultList();
		tx.commit();
		session.close();
		return sepetList;
	}
	
	@Override
	public Optional<Sepet> findById(Integer id) {
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		Sepet sepet= session.get(Sepet.class, id);
		Optional<Sepet> opt=null;
		opt=Optional.ofNullable(sepet);
		tx.commit();
		session.close();
		return opt;
	}

	@Override
	public void save(Sepet sepet) {
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		session.saveOrUpdate(sepet);
		tx.commit();
		session.close();
	}

	@Override
	public void update(Sepet sepet) {
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		session.update(sepet);
		tx.commit();
		session.close();
	}

	@Override
	public void delete(Integer id) {
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		Sepet sepet=session.load(Sepet.class, id);
		session.delete(sepet);
		tx.commit();
		session.close();
	}

}
