package com.ebartmedia.practiceexercise.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EngwordSupport {
	
	
	private @Id
	@GeneratedValue
//	Long id;
	int id;
//	private String engword;
//	private int wordnumber;
//	private float wordnumber; /here
	private String engwordsupport;
	
	
	
	public EngwordSupport() {
		
		
	}
	
	public EngwordSupport(String engwordsupport) {
		
		this.engwordsupport = engwordsupport;
	}
	
	
	public void setEngwordSupport(String engwordsupport) {
		
		this.engwordsupport = engwordsupport;
	}
	
	public String getEngwordSupport() {
		
		return this.engwordsupport;
	}

}
