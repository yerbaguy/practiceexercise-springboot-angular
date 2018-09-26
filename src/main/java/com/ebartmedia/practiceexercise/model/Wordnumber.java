package com.ebartmedia.practiceexercise.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Wordnumber {

	
	private @Id
	@GeneratedValue
//	Long id;
	int id;
//	private String engword;
//	private int wordnumber;
//	private float wordnumber; /here
	private int wordnumber;
	
	public Wordnumber() {
		
		
	}
	
//	public Word(String engword, String plword) {
//		
//		this.engword = engword;
//		this.plword = plword;
//	}
	

	public Wordnumber(int wordnumber) { //float wordnumber
	
		
//		this.id = id;
		this.wordnumber = wordnumber;
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
	public void setWordnumber(int wordnumber) {
	
	     this.wordnumber = wordnumber;
	
	}
	
	public float getWordnumber() {
		
		return this.wordnumber;
	}

	
	
	
}
