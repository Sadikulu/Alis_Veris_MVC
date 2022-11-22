package com.sdk.repository;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sdk.domain.Sarkuteri;

@Component
public class SarkuteriRepositoryImpl implements SarkuteriRepository{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Sarkuteri> getAll() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		List<Sarkuteri> sarkuteriList=session.createQuery("From Sarkuteri order by id",Sarkuteri.class).getResultList();
		tx.commit();
		session.close();
		return sarkuteriList;
	}

	@Override
	public Optional<Sarkuteri> findById(Integer id) {
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		Sarkuteri sarkuteri= session.get(Sarkuteri.class, id);
		Optional<Sarkuteri> opt=null;
		opt=Optional.ofNullable(sarkuteri);
		tx.commit();
		session.close();
		return opt;
	}

	@Override
	public void save(Sarkuteri sarkuteri) {
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		session.saveOrUpdate(sarkuteri);
		tx.commit();
		session.close();
	}

	@Override
	public void update(Sarkuteri sarkuteri) {
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		session.update(sarkuteri);
		tx.commit();
		session.close();
	}

	@Override
	public void delete(Integer id) {
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		Sarkuteri sarkuteri=session.load(Sarkuteri.class, id);
		session.delete(sarkuteri);
		tx.commit();
		session.close();
	}
}
