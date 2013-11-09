package com.appspot.Accent.model.service;

import java.util.ArrayList;
import java.util.List;

import com.appspot.Accent.model.Beoordeling;
import com.appspot.Accent.model.Leerling;
import com.appspot.Accent.model.Stage;
import com.appspot.Accent.model.StageBedrijf;
import com.appspot.Accent.model.StageOpleider;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class StageOfyDAOImpl implements StageOfyDAO {
	   private Objectify ofy;

	public StageOfyDAOImpl(){
		  ofy = ObjectifyService.begin();
	
	}  

	@Override
	public List<Stage> getAllStages() {
		ArrayList<Stage> result = new ArrayList<Stage>();
	      Iterable<Key<Stage>> allKeys= ofy.query(Stage.class).fetchKeys();
	      for (Key k : allKeys){
	    	 Stage s = ofy.get(Stage.class, k.getId());
	    	  result.add(s);
	      }
		   return result;
	}
	@Override
	public Stage getStage(int id) {
		  Stage result = null;
		  ArrayList<Stage> stages = (ArrayList<Stage>) getAllStages();
	      for (Stage s : stages){
	    	  if (s.getId()==(id)){
	    		  result = s;
	    	  }
	      }
	      return result;
	}
	@Override
	public void updateStage(Stage s) {
		System.out.println("Stage: " + s.getId() +", geupdate");
		
	}
	@Override
	public void deleteStage(Stage s) {
		ofy.delete(s);		
	}
	@Override
	public void createStage(int id, String deLeerling, String opl, String bedr, java.util.Date begin,
			java.util.Date eind) {
			ofy.put(new Stage(id, deLeerling, opl, bedr, begin, eind));
	}	
}
