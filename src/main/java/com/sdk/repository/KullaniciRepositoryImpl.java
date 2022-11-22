package com.sdk.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sdk.domain.Kullanici;

@Component
public class KullaniciRepositoryImpl implements KullaniciRepository{

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void save(Kullanici kullanici) {
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		session.saveOrUpdate(kullanici);
		tx.commit();
		session.close();
		
	}

	@Override
	public List<Kullanici> getAll() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		List<Kullanici> kullaniciList=session.createQuery("From Kullanici",Kullanici.class).getResultList();
		tx.commit();
		session.close();
		return kullaniciList;
	}

	@Override
	public List<String> getAllUserName() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		List<String> usernameList=session.createQuery("select username From Kullanici",String.class).getResultList();
		tx.commit();
		session.close();
		return usernameList;
	}

	@Override
	public List<String> getAllPassword() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		List<String> passwordList=session.createQuery("select password From Kullanici",String.class).getResultList();
		tx.commit();
		session.close();
		return passwordList;
	}
}
