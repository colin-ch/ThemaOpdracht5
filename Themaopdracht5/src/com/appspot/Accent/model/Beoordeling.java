package com.appspot.Accent.model;

import java.util.ArrayList;

import com.googlecode.objectify.Objectify;

public class Beoordeling {
	
	private ArrayList<Competentie> competenties = new ArrayList<Competentie>();
	private String datum;
	private String opmerking;
	private Objectify ofy;

	public Beoordeling(String dt, String op){
		datum = dt;
		opmerking = op;
	}
	
	public ArrayList<Competentie> getCompetenties() {
		return competenties;
	}

	public void setCompetenties(ArrayList<Competentie> competenties) {
		this.competenties = competenties;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}	

	public String getOpmerking() {
		return opmerking;
	}

	public void setOpmerking(String opmerking) {
		this.opmerking = opmerking;
	}
	public void createBeoordeling(String d, String opm){
	       ofy.put(new Beoordeling(d, opm));

	}


}
