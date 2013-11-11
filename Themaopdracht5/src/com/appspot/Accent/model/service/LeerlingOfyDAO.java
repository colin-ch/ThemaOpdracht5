package com.appspot.Accent.model.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.appspot.Accent.model.Leerling;
import com.googlecode.objectify.Key;


public interface LeerlingOfyDAO {
	   public List<Leerling> getAllLeerlingen();
	   public Leerling getLeerling(String username);
	   public void updateLeerling(Leerling lu);
	   public void deleteLeerling(Leerling lu);
	   public void createLeerling(String us, String pw, String em, String achternm, String nm, Date gebdat, String kl, String doc);
	}


