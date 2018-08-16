package com.ebartmedia.practiceexercise.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Word {

	
	private @Id
	@GeneratedValue
//	Long id;
	int id;
//	private String engword;
	private String plword;
	
	
	public Word() {
		
		
	}
	
//	public Word(String engword, String plword) {
//		
//		this.engword = engword;
//		this.plword = plword;
//	}
	

	public Word(String plword) {
		
//		this.id = id;
		this.plword = plword;
	}

	
	
	
	
//	public void setEngword(String engword) {
//		
//		this.engword = engword;
//	}
//	
//	public String getEngword() {
//		
//		return this.engword;
//	}
//	
	public void setPlword(String plword) {
	
		this.plword = plword;
	
	}
	
	public String getPlword() {
		
		return this.plword;
	}

	
	
	
}
