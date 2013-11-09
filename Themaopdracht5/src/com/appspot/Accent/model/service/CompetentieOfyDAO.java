package com.appspot.Accent.model.service;

import java.util.List;

import com.appspot.Accent.model.Competentie;


public interface CompetentieOfyDAO {
	   public List<Competentie> getAllCompetenties();
	   public Competentie getCompetentie(int idee, String titel);
	   public void updateCompetentie(Competentie c);
	   public void deleteCompetentie(Competentie c);
	   public void createCompetentie(int idee, String titel);
	}


