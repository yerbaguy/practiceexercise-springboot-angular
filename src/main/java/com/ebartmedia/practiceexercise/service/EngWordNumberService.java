package com.ebartmedia.practiceexercise.service;

import org.springframework.stereotype.Service;


import org.springframework.beans.factory.annotation.Autowired;

import com.ebartmedia.practiceexercise.dao.WordDAO;
import com.ebartmedia.practiceexercise.model.EngWordNumber;
import com.ebartmedia.practiceexercise.repository.EngWordNumberRepository;
import java.util.List;


@Service
public class EngWordNumberService {
	
	@Autowired
	private EngWordNumberRepository engWordNumberRepository;
	
	
	
	public EngWordNumber save(EngWordNumber engWordNumber) {
		
		return engWordNumberRepository.save(engWordNumber);
	}
	
	public int findEngWordNumber() {
		
		int engwordnumber;
		
		return engWordNumberRepository.findEngWordNumber();
	}
	
	public void updEngWordNumber(int getengwordnumber) {
		
		engWordNumberRepository.updEngWordNumber(getengwordnumber);
	}
	

}
