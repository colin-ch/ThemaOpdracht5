package com.appspot.Accent.model;

import java.util.ArrayList;
import java.util.Date;

public class Stage {
private int id;	
private Leerling deLeerling;
private StageOpleider deOpleider;
private StageBedrijf hetBedrijf;
private Date begindatum;
private Date einddatum;
private ArrayList<Beoordeling> beoordelingen = new ArrayList<Beoordeling>();


public Stage(int idee, Leerling lrl, StageOpleider opl, StageBedrijf bedr, Date begin, Date eind){
	id = idee;
	deLeerling = lrl;
	deOpleider = opl;
	hetBedrijf = bedr;
	begindatum = begin;
	einddatum = eind;
}


public Leerling getDeLeerling() {
	return deLeerling;
}


public void setDeLeerling(Leerling deLeerling) {
	this.deLeerling = deLeerling;
}


public StageOpleider getDeOpleider() {
	return deOpleider;
}


public void setDeOpleider(StageOpleider deOpleider) {
	this.deOpleider = deOpleider;
}


public StageBedrijf getHetBedrijf() {
	return hetBedrijf;
}


public void setHetBedrijf(StageBedrijf hetBedrijf) {
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


public ArrayList<Beoordeling> getBeoordelingen() {
	return beoordelingen;
}


public void setBeoordelingen(ArrayList<Beoordeling> beoordelingen) {
	this.beoordelingen = beoordelingen;
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}
}
