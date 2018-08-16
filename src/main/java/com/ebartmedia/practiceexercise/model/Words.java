package com.ebartmedia.practiceexercise.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Words {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="id")
private int id;

public Words(int id, String engword, String plword) {
	
	this.id = id;
	this.engword = engword;
	this.plword = plword;
}


public Words() {
}

//public Words(int id) {
//this.id = id;
//}
@Column(name="engword")
private String engword;
@Column(name="plword")
private String plword;
public void setId(int id) {
this.id = id;
}
public int getId() {
return this.id;
}
public void setEngword(String engword) {
this.engword = engword;
}
public String getEngword() {
return this.engword;
}
public void setPlword(String plword) {
this.plword = plword;
}

public String getPlword() {
	
	return this.plword;
}

}