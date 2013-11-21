package com.appspot.Accent.model;

import java.util.ArrayList;

import javax.persistence.Id;

import com.googlecode.objectify.Objectify;



public class Beoordeling {
	private ArrayList<Competentie> competenties = new ArrayList<Competentie>();
	
	private ArrayList<Integer> deCompetenties = new ArrayList<Integer>();
	private ArrayList<Integer> deWaardesLeerling = new ArrayList<Integer>();
	private ArrayList<Integer> deIDsPerWaarde = new ArrayList<Integer>();
	@Id Long id;
	private String datum;
	private String opmerking;

	public Beoordeling(String dt, String op, ArrayList c, ArrayList l, ArrayList w){
		datum = dt;
		opmerking = op;
		deCompetenties = c;
		deWaardesLeerling = l;
		deIDsPerWaarde = w;
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

	public ArrayList<Integer> getDeWaardesLeerling() {
		return deWaardesLeerling;
	}

	public void setDeWaardesLeerling(ArrayList<Integer> deWaardesLeerling) {
		this.deWaardesLeerling = deWaardesLeerling;
	}
	public ArrayList<Integer> getDeIDsPerWaarde() {
		return deIDsPerWaarde;
	}
	public void setDeIDsPerWaarde(ArrayList<Integer> deIDsPerWaarde) {
		this.deIDsPerWaarde = deIDsPerWaarde;
	}



}
