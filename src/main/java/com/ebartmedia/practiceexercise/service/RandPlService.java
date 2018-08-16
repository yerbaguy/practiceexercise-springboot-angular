package com.ebartmedia.practiceexercise.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebartmedia.practiceexercise.model.RandPl;
import com.ebartmedia.practiceexercise.repository.RandPlRepository;

@Service
public class RandPlService {

	@Autowired
	RandPlRepository randPlRepository;
	
	
//    public RandPl save(int randplword) {
	public RandPl save(RandPl randPl) { 
//	public boolean save(RandPl randPl) {	
	
		return randPlRepository.save(randPl);
		
//		if (randPlRepository.save(randPl)) {
//			
//			return true;
//		} else {
//			
//			return false;
//		}
	}
	
	
	public void updIdAndRandPl(int randPlWord) {
		
		randPlRepository.updIdAndRandPl(randPlWord);
	}
	
	public void deleteRandPl(int n1) {
		
		
		int randPlWord = n1;
		
	//	int x = 5;
	//	int randPlWord = 2;
		
		randPlRepository.updIdAndRandPl(randPlWord);
		
//		randPlRepository.deleteRandPl();
	//	this.alterTableRandPl();
	}
	
	public void alterTableRandPl() {
		
		randPlRepository.alterRandPl();
	}
	
	
//	public int idAndRandPlWord() {
//	public List<RandPl> idAndRandPl() {
	public ArrayList<RandPl> idAndRandPl() {	
		
		int idrandpl = 0;
		int randplword = 0;
		
	//	List<RandPl> idAndRandPl = new ArrayList<RandPl>();
		
	//	idAndRandPl = randPlRepository.findIdAndRandPl();
		
		ArrayList<RandPl> idAndRandPl = new ArrayList<RandPl>(randPlRepository.findIdAndRandPl());
		
//		System.out.println(idrandpl = idAndRandPl.get(0).getId());
//		System.out.println(randplword = idAndRandPl.get(1).getRandPlWord());
		
		
		return idAndRandPl;
		
	//	return randPlRepository.idAndRandPl();
	}
	
	public int findRandPlWord() {
		
		int randplword = randPlRepository.findRandPlWord();
		
		return randplword;
	}
	
	
}
