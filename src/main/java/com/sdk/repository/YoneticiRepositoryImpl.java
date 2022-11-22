package com.sdk.repository;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sdk.domain.Yonetici;

@Component
public class YoneticiRepositoryImpl implements YoneticiRepository{

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void save(Yonetici yonetici) {
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		session.saveOrUpdate(yonetici);
		tx.commit();
		session.close();
		
	}

	@Override
	public List<Yonetici> getAll() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		List<Yonetici> yoneticiList=session.createQuery("From Yonetici",Yonetici.class).getResultList();
		tx.commit();
		session.close();
		return yoneticiList;
	}

	@Override
	public List<String> getAllUserName() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		List<String> usernameList=session.createQuery("select username From Yonetici",String.class).getResultList();
		tx.commit();
		session.close();
		return usernameList;
	}

	@Override
	public List<String> getAllPassword() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		List<String> passwordList=session.createQuery("select password From Yonetici",String.class).getResultList();
		tx.commit();
		session.close();
		return passwordList;
	}

	@Override
	public void update(Yonetici yonetici) {
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		session.update(yonetici);
		tx.commit();
		session.close();
	}

	@Override
	public void delete(Integer id) {
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		Yonetici yonetici=session.load(Yonetici.class, id);
		session.delete(yonetici);
		tx.commit();
		session.close();
	}

	@Override
	public Optional<Yonetici> findById(Integer id) {
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		Yonetici yonetici= session.get(Yonetici.class, id);
		Optional<Yonetici> opt=null;
		opt=Optional.ofNullable(yonetici);
		tx.commit();
		session.close();
		return opt;
	}
}
