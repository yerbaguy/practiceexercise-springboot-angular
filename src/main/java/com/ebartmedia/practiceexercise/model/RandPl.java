package com.ebartmedia.practiceexercise.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class RandPl {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
//	@GeneratedValue
	private int id;
	
	@Column(name="randPlWord")
	private int randPlWord;

//	public RandPl(int id, int randPlWord) {
//		
//		this.id = id;
//		this.randPlWord = randPlWord;
//	}
	
public RandPl(int randPlWord) {
		
	//	this.id = id;
		this.randPlWord = randPlWord;
	}


	public RandPl() {
	}

//	public Word(int id) {
//	this.id = id;
//	}
	
	
	public void setId(int id) {
 
		this.id = id;
	}
	public int getId() {

		return this.id;
	}
	public void setRandPlWord(int randPlWord) {
	
		this.randPlWord = randPlWord;
	}
	
	public int getRandPlWord() {

		return this.randPlWord;
	}

}