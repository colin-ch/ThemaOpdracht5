package com.appspot.Accent.model;

import javax.persistence.Id;

public class Stelling {
	@Id Long id;
private String deStelling;
private String deWaarde;


public Stelling(String stel, String val){
	setDeStelling(stel);
	setDeWaarde(val);
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

}
