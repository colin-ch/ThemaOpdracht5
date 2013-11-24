package com.appspot.Accent.model.service;

import java.util.List;

import com.appspot.Accent.model.Stelling;
import com.appspot.Accent.model.StellingBeoordeeld;


public interface StellingBeoordeeldOfyDAO {
	   public List<Stelling> getAllStellingen();
	   public List<StellingBeoordeeld> getAllStellingenBeoordeeld();
	   public StellingBeoordeeld getStelling(int idee);
	   public void updateStellingBeoordeeld(StellingBeoordeeld s);
	   public void deleteStellingBeoordeeld(StellingBeoordeeld s);
	   public void createStellingBeoordeeld(String wd, int uniek, int stage);
	}


