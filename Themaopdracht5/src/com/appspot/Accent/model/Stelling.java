package com.appspot.Accent.model;

public class Stelling {
private String deStelling;
private String deWaarde;


public Stelling(String stel, String val){
	setDeStelling(stel);
	setDeWaarde(val);
}


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
