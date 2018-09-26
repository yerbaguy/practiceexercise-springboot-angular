package com.ebartmedia.practiceexercise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebartmedia.practiceexercise.model.EngWord;
import com.ebartmedia.practiceexercise.repository.EngwordRepository;

@Service
public class EngwordService {

	
	@Autowired
	private EngwordRepository engwordRepository;
	
	
	
	
	public EngWord save(EngWord engWord) {
		
	    return engwordRepository.save(engWord);
	}
	
	public void updEngWord(String engword) {
		
		engwordRepository.updengword(engword);
	}
	
//	public String findTypedEngword() {
//		
//		return engwordRepository.findTypedEngword();
//	}
	
	
    public String findTypedEngword() {
		
		return engwordRepository.findTypedEngword();
	}
	
}
