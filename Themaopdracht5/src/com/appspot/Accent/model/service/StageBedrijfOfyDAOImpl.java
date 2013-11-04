package com.appspot.Accent.model.service;

import java.util.ArrayList;
import java.util.List;

import com.appspot.Accent.model.StageBedrijf;
import com.appspot.Accent.model.StageBegeleider;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class StageBedrijfOfyDAOImpl implements StageBedrijfOfyDAO {
	   private Objectify ofy;

	public StageBedrijfOfyDAOImpl(){
		  ofy = ObjectifyService.begin();
	}
	
	
	public void deleteStageBedrijf(StageBedrijf lu) {
		  //TODO delete user ofy
		   ofy.delete((lu));
	   }
	   
	   
	   public void createStageBedrijf(String us, String pw, String em, String place, String cd){
	       ofy.put(new StageBedrijf(  us,  pw,  em,  place,  cd));
	   }

	   
	   public List<StageBedrijf> getAllStageBedrijven() {
	      ArrayList<StageBedrijf> result = new ArrayList<StageBedrijf>();
	      Iterable<Key<StageBedrijf>> allKeys= ofy.query(StageBedrijf.class).fetchKeys();
	      for (Key k : allKeys){
	    	  StageBedrijf lu = ofy.get(StageBedrijf.class, k.getId());
	    	  result.add(lu);
	      }
		   return result;
	   }

	   public StageBedrijf getStageBedrijf(String email) {
		   StageBedrijf result = null;
		   ArrayList<StageBedrijf> stagebedrijven = (ArrayList<StageBedrijf>) getAllStageBedrijven();
	      for (StageBedrijf lu : stagebedrijven){
	    	  if (lu.getEmail().equals(email)){
	    		  result = lu;
	    	  }
	      }
	      return result;
	   }

	   
	   public void updateStageBedrijf(StageBedrijf lu) {
			  //TODO update user ofy

	    
	   }



	
}
