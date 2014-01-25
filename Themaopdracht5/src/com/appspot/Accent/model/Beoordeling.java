package com.appspot.Accent.model;

import java.util.ArrayList;

import javax.persistence.Id;

import com.googlecode.objectify.Objectify;



public class Beoordeling {
	private ArrayList<Integer> deCompetenties = new ArrayList<Integer>();
	private ArrayList<Integer> stellingBeoordeeld = new ArrayList<Integer>();
	@Id Long id;
	private int stage;
	private String datumLeerling;
	private String datumBedrijf;
	private String opmerkingBedrijf;
	private String opmerkingLeerling;

	public Beoordeling(String dtl , String dtb, String opl, String opb, int sta,  ArrayList c, ArrayList w){
		datumLeerling = dtl;
		datumBedrijf = dtb;
		opmerkingLeerling = opl;
		opmerkingBedrijf = opb;
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

	public String getDatumLeerling() {
		return datumLeerling;
	}

	public void setDatumLeerling(String datum) {
		this.datumLeerling = datum;
	}	
	public String getDatumBedrijf() {
		return datumBedrijf;
	}

	public void setDatumBedrijf(String datum) {
		this.datumBedrijf = datum;
	}	
	public String getOpmerkingLeerling() {
		return opmerkingLeerling;
	}

	public void setOpmerkingLeerling(String opmerking) {
		this.opmerkingLeerling = opmerking;
	}
	public String getOpmerkingBedrijf() {
		return opmerkingBedrijf;
	}

	public void setOpmerkingBedrijf(String opmerking) {
		this.opmerkingBedrijf = opmerking;
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
