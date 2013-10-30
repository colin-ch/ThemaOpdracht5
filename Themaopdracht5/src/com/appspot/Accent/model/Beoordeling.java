package com.appspot.Accent.model;

import java.util.ArrayList;
import java.util.Date;

public class Beoordeling {
	private ArrayList<Competentie> competenties = new ArrayList<Competentie>();
	private Date datum;
	private int waarde;	
	private String opmerking;
	
	public ArrayList<Competentie> getCompetenties() {
		return competenties;
	}

	public void setCompetenties(ArrayList<Competentie> competenties) {
		this.competenties = competenties;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}


	public Beoordeling(Date dt, int wa, String op){
		datum = dt;
		waarde = wa;
		opmerking = op;
	}
	
	public int getWaarde() {
		return waarde;
	}

	public void setWaarde(int waarde) {
		this.waarde = waarde;
	}

	public String getOpmerking() {
		return opmerking;
	}

	public void setOpmerking(String opmerking) {
		this.opmerking = opmerking;
	}


}
