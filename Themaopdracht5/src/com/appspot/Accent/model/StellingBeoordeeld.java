package com.appspot.Accent.model;

import javax.persistence.Id;

public class StellingBeoordeeld {
	@Id Long id;
private String deWaarde;
private int uniekID;
private int deStage;


public StellingBeoordeeld(String val, int uniq, int destage){
	
	deWaarde = val;
	
	uniekID = uniq;
	deStage = destage;
}
public StellingBeoordeeld(){}


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


public int getUniekID() {
	return uniekID;
}
public void setUniekID(int uniekID) {
	this.uniekID = uniekID;
}
public int getDeStage() {
	return deStage;
}
public void setDeStage(int deStage) {
	this.deStage = deStage;
}

}
