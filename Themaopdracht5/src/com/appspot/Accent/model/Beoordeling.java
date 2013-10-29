package com.appspot.Accent.model;

import java.util.ArrayList;
import java.util.Date;

public class Beoordeling {
	private ArrayList<Competentie> competenties = new ArrayList<Competentie>();
	private Date datum;
	public Beoordeling(Date dt){
		datum = dt;
	}

}
