package com.ebartmedia.practiceexercise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebartmedia.practiceexercise.repository.WordnumberRepository;


@Service
public class WordnumberService {
	
	
	@Autowired
	private WordnumberRepository wordnumberRepository;
	
	
	
////	public void updWordnumber(int wordnumber) {
//	public void updWordnumber(int randplword) {	 // here
////	public void updWordnumber(float wordnumber) {	
//		
//		wordnumberRepository.updwordnumber(randplword);
//		
//	}
	
	public int findRandEngWordNumber() {
		
		int wordrandengnumber = 0;
		
		return wordrandengnumber = wordnumberRepository.findRandEngWordNumber();
				
	}
	
	public void updWordNumber(int randplword) {
		
		wordnumberRepository.updWordNumber(randplword);
	}

}
