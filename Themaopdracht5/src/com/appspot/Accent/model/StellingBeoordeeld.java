package com.appspot.Accent.model;

import javax.persistence.Id;

public class StellingBeoordeeld {
	@Id Long id;
private String deWaardeStagebedrijf;
private int uniekID;
private int deStage;
private String deWaardeLeerling;


public StellingBeoordeeld(String val, String vall,  int uniq, int destage){
	
	deWaardeStagebedrijf = val;
	deWaardeLeerling = vall;
	uniekID = uniq;
	deStage = destage;
}
public StellingBeoordeeld(){}


public String getDeWaardeStagebedrijf() {
	return deWaardeStagebedrijf;
}


public void setDeWaardeStagebedrijf(String deWaardeStagebedrijf) {
	this.deWaardeStagebedrijf = deWaardeStagebedrijf;
}

public String getDeWaardeLeerling() {
	return deWaardeLeerling;
}
public void setDeWaardeLeerling(String deWaardeLeerling) {
	this.deWaardeLeerling = deWaardeLeerling;
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
