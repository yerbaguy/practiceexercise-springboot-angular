package com.ebartmedia.practiceexercise.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EngWordNumber {

	
	private @Id
	@GeneratedValue
//	Long id;
	int id;
//	private String engword;
//	private String engwordnumberOk;
//	private String engwordnumberNo;
	private int engwordnumber;
//	private int idplword;
	
	
	
	public EngWordNumber() {
		
		
	}
	
//	public Word(String engword, String plword) {
//		
//		this.engword = engword;
//		this.plword = plword;
//	}
	

//	public EngWordNumber(String engwordnumberOk, String engwordnumberNo) {
	public EngWordNumber(int engwordnumber) {

//    public Word(int idplword) {		
//		this.id = id;
//	    this.engwordnumberOk = engwordnumberOk;
//	    this.engwordnumberNo = engwordnumberNo;
		
		this.engwordnumber = engwordnumber;
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
//	public void setEngWordNumberOk(String engwordnumberOk) {
	public void setEngWordNumber(int engwordnumber) {
//	public void setIdplword(int idplword) {	
	
//		this.engwordnumberOk = engwordnumberOk;
		
		this.engwordnumber = engwordnumber;
	
	}
	
	public int getEngWordNumber() {
//	public int getIdplword() {	
		
//		return this.engwordnumberOk;
		
		return this.engwordnumber;
	}

	
//	public void setEngWordNumberNo(String engwordnumberNo) {
//		
//		this.engwordnumberNo = engwordnumberNo;
//	}
//	
//	
//	public String getEngWordNumberNo() {
//		
//		return this.engwordnumberNo;
//	}
}
