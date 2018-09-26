package com.ebartmedia.practiceexercise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebartmedia.practiceexercise.dao.IWordsDAO;
import com.ebartmedia.practiceexercise.model.Words;


public interface IWordssService {
	
   
	
	public boolean wordExists(String engword);
	
	List<Words> getAllWords();

}
