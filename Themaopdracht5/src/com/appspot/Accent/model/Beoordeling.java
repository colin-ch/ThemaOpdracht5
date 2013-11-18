package com.appspot.Accent.model;

import java.util.ArrayList;

import javax.persistence.Id;

import com.googlecode.objectify.Objectify;



public class Beoordeling {
	private ArrayList<Competentie> competenties = new ArrayList<Competentie>();
	
	private ArrayList<Integer> deCompetenties = new ArrayList<Integer>();
	private ArrayList<Integer> deWaardesLeerling = new ArrayList<Integer>();
	@Id Long id;
	private String datum;
	private String opmerking;

	public Beoordeling(String dt, String op, ArrayList c, ArrayList l){
		datum = dt;
		opmerking = op;
		deCompetenties = c;
		setDeWaardesLeerling(l);
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
	/**
	 * @return the deWaardesLeerling
	 */
	public ArrayList<Integer> getDeWaardesLeerling() {
		return deWaardesLeerling;
	}
	/**
	 * @param deWaardesLeerling the deWaardesLeerling to set
	 */
	public void setDeWaardesLeerling(ArrayList<Integer> deWaardesLeerling) {
		this.deWaardesLeerling = deWaardesLeerling;
	}



}
