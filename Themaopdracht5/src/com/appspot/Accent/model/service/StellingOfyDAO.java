package com.appspot.Accent.model.service;

import java.util.List;

import com.appspot.Accent.model.Stelling;


public interface StellingOfyDAO {
	   public List<Stelling> getAllStellingen();
	   public Stelling getStelling(String stel);
	   public void updateStelling(Stelling s);
	   public void deleteStelling(Stelling s);
	   public void createStelling(String stel, String wd);
	}


