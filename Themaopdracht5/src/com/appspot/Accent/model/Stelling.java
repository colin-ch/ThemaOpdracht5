package com.appspot.Accent.model;

import javax.persistence.Id;

public class Stelling {
	@Id Long id;
	private int eigenId;
private String deStelling;
private int deWaarde;
private int uniekID;


public Stelling(int idee, String stel, int val, int uniq){
	deStelling = stel;
	deWaarde = val;
	eigenId = idee;
	setUniekID(uniq);
}
public Stelling(){}

public String getDeStelling() {
	return deStelling;
}


public void setDeStelling(String deStelling) {
	this.deStelling = deStelling;
}


public int getDeWaarde() {
	return deWaarde;
}


public void setDeWaarde(int deWaarde) {
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
public int getUniekID() {
	return uniekID;
}
public void setUniekID(int uniekID) {
	this.uniekID = uniekID;
}

}
