package com.appspot.Accent.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Id;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;

public class Leerling implements Serializable{

	  @Id Long id;
    private Objectify ofy;
    private String username;
    private String password;
    private String email;
	private String klas;
	private String begeleider;
	private Date geboortedatum;
	private int leeftijd;
	private String roepnaam;
	private String tussenvoegsel;
	private String achternaam;
	private String naam;
	
	public Leerling(String us, String pw, String em, String call, String tussen, String achternm, String nm, int age, Date gebdat, String kl, String doc) {
		username = us;
		password =pw;
		email =em;
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



	
	
	 
	   public String getBegeleider() {
		return begeleider;
	}

	public void setBegeleider(String begeleider) {
		this.begeleider = begeleider;
	}

	public void deleteLeerling(Leerling lu) {
		  //TODO delete user ofy
		   ofy.delete((lu));
	   }
	   
	   
	   public void createLeerling(String us, String pw, String em, String call, String tussen, String achternm, String nm, int age, Date gebdat, String kl, String doc){
	       ofy.put(new Leerling( us,  pw,  em, call, tussen,  achternm,  nm,  age,  gebdat,  kl,  doc));

		   
	   }

	   
	   public List<Leerling> getAllLeerlingen() {
	      ArrayList<Leerling> result = new ArrayList<Leerling>();
	      Iterable<Key<Leerling>> allKeys= ofy.query(Leerling.class).fetchKeys();
	      for (Key k : allKeys){
	    	  Leerling lu = ofy.get(Leerling.class, k.getId());
	    	  result.add(lu);
	      }
		   return result;
	   }

	   public Leerling getLeerling(String username) {
		   Leerling result = null;
		   ArrayList<Leerling> leerlingen = (ArrayList<Leerling>) getAllLeerlingen();
	      for (Leerling lu : leerlingen){
	    	  if (lu.getUsername().equals(username)){
	    		  result = lu;
	    	  }
	      }
	      return result;
	   }

	   
	   public void updateLeerling(Leerling lu) {
			  //TODO update user ofy

	      System.out.println("LocalUser: " + lu.getUsername() +", activated in the database");
	   }
	
	

}
