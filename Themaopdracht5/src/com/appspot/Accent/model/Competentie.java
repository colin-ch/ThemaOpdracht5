package com.appspot.Accent.model;

import java.util.ArrayList;

public class Competentie {
	private String titel;
	private ArrayList<String> beschrijving = new ArrayList<String>();

	
	public Competentie(String ti){
		setTitel(ti);
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}


}
