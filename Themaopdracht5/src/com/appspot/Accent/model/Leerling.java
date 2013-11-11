package com.appspot.Accent.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Id;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class Leerling implements Serializable{

	  @Id Long id;
    private Objectify ofy;
    private String username;
    private String password;
    private String email;
	private String klas;
	private String begeleider;
	private Date geboortedatum;
	private String roepnaam;
	private String achternaam;

	
	
	
	public Leerling(String us, String pw, String em, String call, String achternm, Date gebdat, String kl, String doc) {

		username = us;
		password =pw;
		email =em;
		klas = kl;
		setBegeleider(doc);
		geboortedatum = gebdat;
		roepnaam = call;
		achternaam = achternm;
	
		// TODO Auto-generated constructor stub
	}

	public Leerling(){}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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




	public String getAchternaam() {
		return achternaam;
	}


	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}




	public String getRoepnaam() {
		return roepnaam;
	}


	public void setRoepnaam(String roepnaam) {
		this.roepnaam = roepnaam;
	}



	
	
	 
	   public String getBegeleider() {
		return begeleider;
	}

	public void setBegeleider(String begeleider) {
		this.begeleider = begeleider;
	}


	

}
