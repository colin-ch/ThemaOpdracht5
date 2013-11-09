package com.appspot.Accent.model;

import javax.persistence.Id;

public class Stelling {
	@Id Long id;
	private int eigenId;
private String deStelling;
private String deWaarde;


public Stelling(int idee, String stel, String val){
	deStelling = stel;
	deWaarde = val;
	eigenId = idee;
}
public Stelling(){}

public String getDeStelling() {
	return deStelling;
}


public void setDeStelling(String deStelling) {
	this.deStelling = deStelling;
}


public String getDeWaarde() {
	return deWaarde;
}


public void setDeWaarde(String deWaarde) {
	this.deWaarde = deWaarde;
}

public String toString(){
	String s = "test";
	return s;
}
public int getEigenId() {
	return eigenId;
}

public void setEigenId(int eigenId) {
	this.eigenId = eigenId;
}

}
