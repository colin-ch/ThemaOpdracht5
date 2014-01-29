package com.appspot.Accent.model.service;

import java.util.ArrayList;
import java.util.List;

import com.appspot.Accent.model.Beoordeling;


public interface BeoordelingOfyDAO {
	   public List<Beoordeling> getAllBeoordelingen();
	   public List<Beoordeling> getBeoordelingen(int id);
	   public Beoordeling getBeoordeling(String datum);
	   public void updateBeoordeling(Beoordeling b);
	   public void deleteBeoordeling(Beoordeling b);
	   public void createBeoordeling(String id, String dt, String dtb, String sopl, String opm, String opmb,int sta, ArrayList c, ArrayList l);
	}


