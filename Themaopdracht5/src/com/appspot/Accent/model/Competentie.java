package com.appspot.Accent.model;

import java.util.ArrayList;

import javax.persistence.Id;

public class Competentie {
	@Id Long id;
	private String titel;
	private ArrayList<Stelling> deStellingen = new ArrayList<Stelling>();

	
	public Competentie(String ti){
		setTitel(ti);
	}
	public Competentie(){}
	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public ArrayList<Stelling> getDeStellingen() {
		return deStellingen;
	}

	public void setDeStellingen(ArrayList<Stelling> deStellingen) {
		this.deStellingen = deStellingen;
	}


}
