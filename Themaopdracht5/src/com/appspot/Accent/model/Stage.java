package com.appspot.Accent.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Id;

public class Stage implements Serializable {
	@Id Long id;
private int eigenid;	
private String deLeerling;
private String deBegeleider;
private String deOpleider;
private String hetBedrijf;
private Date begindatum;
private Date einddatum;



public Stage(int idee, String lrl,String beg, String opl, String bedr, Date begin, Date eind){
	eigenid = idee;
	deLeerling = lrl;
	setDeBegeleider(beg);
	deOpleider = opl;
	hetBedrijf = bedr;
	begindatum = begin;
	einddatum = eind;
}
public Stage(){}

public String getDeLeerling() {
	return deLeerling;
}


public void setDeLeerling(String deLeerling) {
	this.deLeerling = deLeerling;
}


public String getDeOpleider() {
	return deOpleider;
}


public void setDeOpleider(String deOpleider) {
	this.deOpleider = deOpleider;
}


public String getHetBedrijf() {
	return hetBedrijf;
}


public void setHetBedrijf(String hetBedrijf) {
	this.hetBedrijf = hetBedrijf;
}


public Date getBegindatum() {
	return begindatum;
}


public void setBegindatum(Date begindatum) {
	this.begindatum = begindatum;
}


public Date getEinddatum() {
	return einddatum;
}


public void setEinddatum(Date einddatum) {
	this.einddatum = einddatum;
}




public int getId() {
	return eigenid;
}


public void setId(int id) {
	this.eigenid = id;
}
public String getDeBegeleider() {
	return deBegeleider;
}
public void setDeBegeleider(String deBegeleider) {
	this.deBegeleider = deBegeleider;
}
}
