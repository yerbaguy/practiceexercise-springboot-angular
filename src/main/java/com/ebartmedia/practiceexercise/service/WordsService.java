package com.ebartmedia.practiceexercise.service;

import org.springframework.stereotype.Service;


import org.springframework.beans.factory.annotation.Autowired;

import com.ebartmedia.practiceexercise.dao.WordDAO;
import com.ebartmedia.practiceexercise.model.Words;
import com.ebartmedia.practiceexercise.repository.WordsRepository;
import java.util.List;


@Service
public class WordsService {
@Autowired
private WordsRepository wordsRepository;
@Autowired
private WordDAO wordDAO;
public List<Words> getAll() {
// return wordRepository.findAll();
// return wordRepository.getAll();
return wordDAO.getAll();
}
public int showCount() {
int showcount = wordsRepository.countWord();
System.out.println(showcount);
return wordsRepository.countWord();
}

public Words save(Words words) {
	
	return wordsRepository.save(words);
}

public String findWord(int randplword) {
	
	String plword = "";
	
//	plword = wordRepository.findWord(randplword);
	
	return plword;
}

public String getWord(int countrandom) {
	
//  int n1 = 1;
	
	String getword = "";
	
	System.out.println(getword = wordsRepository.getWord(countrandom));
	
	return getword;
	
//	return getword = wordsRepository.findWord(n1);

	
//	return getword;
	
}

public int getWordNumber(String engword) {
	
	return wordsRepository.getWordNumber(engword);
}

}