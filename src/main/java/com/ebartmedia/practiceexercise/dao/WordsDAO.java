package com.ebartmedia.practiceexercise.dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ebartmedia.practiceexercise.model.Words;

//import com.ebartmedia.practiceexercise.HibernateConfig;

import com.ebartmedia.practiceexercise.model.Words;


@Transactional
@Repository
public class WordsDAO implements IWordsDAO {

	@PersistenceContext
	private EntityManager entityManager;

	
	List<Words> words = new ArrayList<Words>();
	
	
//	private SessionFactory sessionFactory;
	
//	@Autowired
//	private HibernateConfig hibernateConfig;
	
	@Autowired
	public WordsDAO(EntityManager entityManager) {
		
//		this.sessionFactory = sessionFactory;
		this.entityManager = entityManager;
//		this.hibernateConfig = hibernateConfig;
		
	}
	
	
	@Override
	public boolean wordExists(String engword) {
		// TODO Auto-generated method stub
		
		int count = 1;
		
	//	String hql = "w.id FROM Words w WHERE w.engword = ?";
//		String hql = "SELECT w.id, w.engword FROM Words w WHERE w.engword = ?";
//		int count = entityManager.createQuery(hql).setParameter(1, engword).getResultList().size();

	//	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
//		Session session = sessionFactory.getCurrentSession();
		
//		Transaction tx = session.beginTransaction();
		
//		Query query = session.createQuery("SELECT id FROM Words WHERE engword= :engword");
//	    query.setString(1, engword);
	    
//	    count = (int) query.uniqueResult();
		
		
	    
	//	return false;
		
		return count > 0 ? true : false;
	}

  //  @SuppressWarnings("unchecked")
	@Override
	public List<Words> getAllWords() {	
		// TODO Auto-generated method stub
		
	//	String hql = "FROM Words as w ORDER BY w.id";
		String hql = "FROM Words";
		
	//	return null;
		
		List<Words> words = entityManager.createQuery(hql).getResultList();
		
		
		return words;
		
	//	return (List<Words>) entityManager.createQuery(hql).getResultList();
	}

	
	
}
