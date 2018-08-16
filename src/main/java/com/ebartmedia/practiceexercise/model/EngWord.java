package com.ebartmedia.practiceexercise.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EngWord {
	
	
	private @Id
	@GeneratedValue
	int id;
	
	private String typedengword;
	
	
	
	public EngWord() {
		
		
	}
	
	
	public EngWord(String typedengword) {
		
		this.typedengword = typedengword;
	}
	
	
	public void setEngwordId(int id) {
		
		this.id = id;
	}
	
	public int getEngwordId() {
		
		return this.id;
	}
	
	
	public void setTypedengword(String typedengword) {
		
		this.typedengword = typedengword;
	}
	
	public String getTypedEngword() {
		
		return this.typedengword;
	}

}
