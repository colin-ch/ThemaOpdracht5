package com.appspot.Accent.model;

import java.util.ArrayList;

import javax.persistence.Id;

import com.googlecode.objectify.Objectify;



public class Beoordeling {
	private ArrayList<Integer> deCompetenties = new ArrayList<Integer>();
	private ArrayList<Integer> stellingBeoordeeld = new ArrayList<Integer>();
	@Id Long id;
	private int stage;
	private String datum;
	private String opmerking;

	public Beoordeling(String dt, String op,int sta,  ArrayList c, ArrayList w){
		datum = dt;
		opmerking = op;
		setStage(sta);
		deCompetenties = c;
		stellingBeoordeeld = w;
		
	}
	public Beoordeling(){}
	
	public ArrayList<Integer> getCompetenties() {
		return deCompetenties;
	}

	public void setCompetenties(ArrayList<Integer> array) {
		this.deCompetenties = array;
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

	public int getStage() {
		return stage;
	}
	public void setStage(int stage) {
		this.stage = stage;
	}
	
	public ArrayList<Integer> getStellingBeoordeeld() {
		return stellingBeoordeeld;
	}
	public void setStellingBeoordeeld(ArrayList<Integer> stellingBeoordeeld) {
		this.stellingBeoordeeld = stellingBeoordeeld;
	}



}
