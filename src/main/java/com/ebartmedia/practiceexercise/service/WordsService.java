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
//public int getWord(int randplword) {	
	
//  int n1 = 1;
	
	String getword = "";
//	int getword = 1;
	
	System.out.println(getword = wordsRepository.getWord(countrandom));
//	System.out.println(getword = wordsRepository.getWord(getword));
	
	return getword;
	
//	return getword = wordsRepository.findWord(n1);

	
//	return getword;
	
}

//public int getWordNumber(String engword) {
//public Float getWordNumber(String engword) {
public Integer getWordNumber(String engword) {	
	
//	Integer count = 1;
	
	 Integer wordnumber;
	
	wordnumber = wordsRepository.getWordNumber(engword);
	
	if (wordnumber == null)
		return 0;
	else
		return wordnumber;
	
//	return wordsRepository.getWordNumber(engword);
	
//	count = wordsRepository.getWordNumber(engword);
//	
//	if (count == null) {
//		
//		count = 0;
//	}
	
//	return count;
	
//    return wordsRepository.getWordNumber(engword);	
}

//public String getEngWordNumber(String engword) {
//public boolean getEngWordNumber(String engword) {
//public Float getEngWordNumber(String engword) {	


public String getRandEngWord(int randengwordnumber) {
	
	String randengword = "";
	return randengword = wordsRepository.getRandEngWord(randengwordnumber);
	
}

public Integer getEngWordNumber(String engword) {		
   // Float wordnumber;
    
  //  boolean wordnumber;
	
    String wordnumb;
    Integer wordnumber;
    
	 wordnumber = wordsRepository.getEngWordNumber(engword);

	 if (wordnumber == null)
		 return 0;
	 else
		 return 1;
	 
	 
//	wordnumb = Float.toString(wordnumber);
	
//	System.out.println("getEngWordNumber - wordnumb" + wordnumb);
	
	
//	return wordnumber;
	
	 
//	return wordsRepository.getWordNumber(engword);
	
	// return wordsRepository.getEngWordNumber(engword);
	
	 
	 
  //  return wordnumber > 0 ? true : false; 
	 
//	return wordnumber ? true : false;
	
	
	
}



public int getWordIdNumber(String plword) {
	
	return wordsRepository.getWordsIdNumber(plword);
}

public boolean wordExists(String engword) {
	
	return wordsRepository.wordExists(engword);
}

}