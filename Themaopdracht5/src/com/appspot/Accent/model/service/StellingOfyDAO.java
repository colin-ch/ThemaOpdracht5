package com.appspot.Accent.model.service;

import java.util.List;

import com.appspot.Accent.model.Stelling;


public interface StellingOfyDAO {
	   public List<Stelling> getAllStellingen();
	   public Stelling getStelling(int idee);
	   public void updateStelling(Stelling s);
	   public void deleteStelling(Stelling s);
	   public void createStelling(int idee, String stel, String wd);
	}


