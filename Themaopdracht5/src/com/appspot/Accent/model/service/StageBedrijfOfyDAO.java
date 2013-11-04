package com.appspot.Accent.model.service;

import java.util.List;

import com.appspot.Accent.model.StageBedrijf;


public interface StageBedrijfOfyDAO {
	   public List<StageBedrijf> getAllStageBedrijven();
	   public StageBedrijf getStageBedrijf(String email);
	   public void updateStageBedrijf(StageBedrijf lu);
	   public void deleteStageBedrijf(StageBedrijf lu);
	   public void createStageBedrijf(String us, String pw, String em, String place, String cd);
	}