package com.appspot.Accent.model;

import java.util.Date;

public class Leerling extends User{
	private String klas;
	private Docent docent;
	private Date geboortedatum;
	private int leeftijd;
	private String roepnaam;
	private St
	

	public Leerling(String us, String pw, String em, String kl) {
		super(us, pw, em);
		klas = kl;
		// TODO Auto-generated constructor stub
	}

}
