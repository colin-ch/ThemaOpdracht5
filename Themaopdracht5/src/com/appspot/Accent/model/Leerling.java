package com.appspot.Accent.model;

import java.util.Date;

public class Leerling extends User{
	private String klas;
	private StageBegeleider begeleider;
	private Date geboortedatum;
	private int leeftijd;
	private String roepnaam;
	private String tussenvoegsel;
	private String achternaam;
	private String naam;
	

	public Leerling(String us, String pw, String em, String call, String tussen, String achternm, String nm, int age, Date gebdat, String kl, StageBegeleider doc) {
		super(us, pw, em);
		klas = kl;
		setBegeleider(doc);
		geboortedatum = gebdat;
		leeftijd = age;
		roepnaam = call;
		tussenvoegsel = tussen;
		achternaam = achternm;
		naam = nm;
		// TODO Auto-generated constructor stub
	}


	public String getNaam() {
		return naam;
	}


	public String getKlas() {
		return klas;
	}


	public void setKlas(String klas) {
		this.klas = klas;
	}


	public Date getGeboortedatum() {
		return geboortedatum;
	}


	public void setGeboortedatum(Date geboortedatum) {
		this.geboortedatum = geboortedatum;
	}


	public int getLeeftijd() {
		return leeftijd;
	}


	public void setLeeftijd(int leeftijd) {
		this.leeftijd = leeftijd;
	}


	public String getTussenvoegsel() {
		return tussenvoegsel;
	}


	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;
	}


	public String getAchternaam() {
		return achternaam;
	}


	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}


	public void setNaam(String naam) {
		this.naam = naam;
	}


	public String getRoepnaam() {
		return roepnaam;
	}


	public void setRoepnaam(String roepnaam) {
		this.roepnaam = roepnaam;
	}


	public StageBegeleider getBegeleider() {
		return begeleider;
	}


	public void setBegeleider(StageBegeleider begeleider) {
		this.begeleider = begeleider;
	}

}
