package com.appspot.Accent.model;

import java.util.ArrayList;

public class School {
	private String naam;
	private String adres;
	private String plaats;
	private String postCode;
	private ArrayList<StageBedrijf> bedrijven = new ArrayList<StageBedrijf>();
	private ArrayList<Leerling> leerlingen = new ArrayList<Leerling>();
	private ArrayList<Docent> docenten = new ArrayList<Docent>();
	private ArrayList<StageBegeleider> begeleiders = new ArrayList<StageBegeleider>();
	private ArrayList<Stage> Stages = new ArrayList<Stage>();
	
	
	
	public School(String nm, String ad, String pl, String pc){
		setNaam(nm);
		setAdres(ad);
		setPlaats(pl);
		setPostCode(pc);
	}

	
	public ArrayList<StageBedrijf> getBedrijven() {
		return bedrijven;
	}

	public void setBedrijven(ArrayList<StageBedrijf> bedrijven) {
		this.bedrijven = bedrijven;
	}

	public ArrayList<Leerling> getLeerlingen() {
		return leerlingen;
	}

	public void setLeerlingen(ArrayList<Leerling> leerlingen) {
		this.leerlingen = leerlingen;
	}

	public ArrayList<Docent> getDocenten() {
		return docenten;
	}

	public void setDocenten(ArrayList<Docent> docenten) {
		this.docenten = docenten;
	}

	public ArrayList<StageBegeleider> getBegeleiders() {
		return begeleiders;
	}

	public void setBegeleiders(ArrayList<StageBegeleider> begeleiders) {
		this.begeleiders = begeleiders;
	}

	public ArrayList<Stage> getStages() {
		return Stages;
	}

	public void setStages(ArrayList<Stage> stages) {
		Stages = stages;
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
