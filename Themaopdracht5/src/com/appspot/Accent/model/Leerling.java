package com.appspot.Accent.model;

public class Leerling extends User{
	private String klas;
	private Docent docent;

	public Leerling(String us, String pw, String em, String kl) {
		super(us, pw, em);
		klas = kl;
		// TODO Auto-generated constructor stub
	}

}
