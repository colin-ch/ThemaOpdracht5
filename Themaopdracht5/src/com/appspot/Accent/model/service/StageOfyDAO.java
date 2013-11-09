package com.appspot.Accent.model.service;

import java.util.Date;
import java.util.List;

import com.appspot.Accent.model.Leerling;
import com.appspot.Accent.model.Stage;
import com.appspot.Accent.model.StageBedrijf;
import com.appspot.Accent.model.StageOpleider;


public interface StageOfyDAO {
	   public List<Stage> getAllStages();
	   public Stage getStage(int id);
	   public void updateStage(Stage s);
	   public void deleteStage(Stage s);
	   public void createStage(int id, String deLeerling, String opl, String bedr, Date begin, Date eind);
	}


