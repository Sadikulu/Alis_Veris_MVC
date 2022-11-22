package com.sdk.repository;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sdk.domain.Market;

@Component
public class MarketRepositoryImpl implements MarketRepository{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Market> getAll() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		List<Market> marketList=session.createQuery("From Market order by id",Market.class).getResultList();
		tx.commit();
		session.close();
		return marketList;
	}

	@Override
	public Optional<Market> findById(Integer id) {
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		Market market= session.get(Market.class, id);
		Optional<Market> opt=null;
		opt=Optional.ofNullable(market);
		tx.commit();
		session.close();
		return opt;
	}

	@Override
	public void save(Market market) {
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		session.saveOrUpdate(market);
		tx.commit();
		session.close();
	}

	@Override
	public void update(Market market) {
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		session.update(market);
		tx.commit();
		session.close();
	}

	@Override
	public void delete(Integer id) {
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		Market market=session.load(Market.class, id);
		session.delete(market);
		tx.commit();
		session.close();
	}

}
