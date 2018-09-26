package com.ebartmedia.practiceexercise.dao;

import java.util.List;


import com.ebartmedia.practiceexercise.model.Words;

public interface IWordsDAO {	
	
	boolean wordExists(String engword);
	
	List<Words> getAllWords();

}
