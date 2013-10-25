package com.appspot.Accent.model;

public class Competentie {
	private String beschrijving;
	private int waarde;
	//opmerking in beoordeling of competentie?
	
	public Competentie(String be, int wa){
		setBeschrijving(be);
		setWaarde(wa);
	}


	public String getBeschrijving() {
		return beschrijving;
	}


	public void setBeschrijving(String beschrijving) {
		this.beschrijving = beschrijving;
	}

	public int getWaarde() {
		return waarde;
	}

	public void setWaarde(int waarde) {
		this.waarde = waarde;
	}

}
