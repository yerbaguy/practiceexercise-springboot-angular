package com.ebartmedia.practiceexercise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ebartmedia.practiceexercise.dao.IWordsDAO;
import com.ebartmedia.practiceexercise.model.Words;

@Service
public class WordssService implements IWordssService{

	@Autowired
	private IWordsDAO iwordsDAO;

    @PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public boolean wordExists(String engword) {
		// TODO Auto-generated method stub
		
//		if (iwordsDAO.wordExists(engword)) 
//			return true;
//		 else
//    		return false;
		
		
		String hql = "id FROM Words w WHERE w.engword = ?";
	//	int count = entityManager.createQuery(hql).setParameter(1, engword).getFirstResult();
		int count = entityManager.createQuery(hql).setParameter(1, engword).getMaxResults();
			
		return count > 0 ? true : false;
		
		
	}

	@Override
	public List<Words> getAllWords() {
		// TODO Auto-generated method stub
		
		return iwordsDAO.getAllWords();
		
	//	return null;
	}
	
	
	
	

}
