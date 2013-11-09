package com.appspot.Accent.model;

import javax.persistence.Id;

public class StageOpleider {
	@Id Long id;
private String naam;

public StageOpleider(String nm){
	
	naam = nm;
}
public StageOpleider(){}
public String getNaam() {
	return naam;
}

public void setNaam(String naam) {
	this.naam = naam;
}

}
