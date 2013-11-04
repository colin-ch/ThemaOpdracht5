package com.appspot.Accent.model.service;

import java.util.List;

import com.appspot.Accent.model.Docent;


public interface DocentOfyDAO {
	   public List<Docent> getAllDocenten();
	   public Docent getDocent(String em);
	   public void updateDocent(Docent d);
	   public void deleteDocent(Docent d);
	   public void createDocent(String us, String pw, String em);
	}


