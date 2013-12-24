package com.appspot.Accent.tests;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.appspot.Accent.controller.BeoordelingAanmakenServlet;
import com.appspot.Accent.model.Leerling;
import com.appspot.Accent.model.service.LeerlingOfyDAOImpl;
import com.googlecode.objectify.Objectify;

public class TestData {
	private Objectify ofy;
	private static final Logger log = Logger.getLogger(BeoordelingAanmakenServlet.class.getName());
	LeerlingOfyDAOImpl lod = new LeerlingOfyDAOImpl();
	ArrayList<Leerling>leerlingen = (ArrayList<Leerling>) lod.getAllLeerlingen();
	public TestData(){
		
	}
	public void aanmaken(){
		Leerling l1 = new Leerling("123user", "123pass", null, null, null, null, null, null);
		for(Leerling l : leerlingen){
			if(l.getUsername().equals(l1.getUsername())){
				log.info("gebruiker bestaat al");
			}
			else{
				ofy.put(l1);
			}
		}
	}
}
