package com.appspot.Accent.model;

public class School {
	private String naam;
	private String adres;
	private String plaats;
	private String postCode;
	
	public School(String nm, String ad, String pl, String pc){
		setNaam(nm);
		setAdres(ad);
		setPlaats(pl);
		setPostCode(pc);
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getPlaats() {
		return plaats;
	}

	public void setPlaats(String plaats) {
		this.plaats = plaats;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

}
