package com.appspot.Accent.model.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.appspot.Accent.model.Stelling;
import com.appspot.Accent.model.StellingBeoordeeld;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class StellingBeoordeeldOfyDAOImpl implements StellingBeoordeeldOfyDAO {
	   private Objectify ofy;

	public StellingBeoordeeldOfyDAOImpl(){
		  ofy = ObjectifyService.begin();
	}  

	@Override
	public List<StellingBeoordeeld> getAllStellingenBeoordeeld() {
		ArrayList<StellingBeoordeeld> result = new ArrayList<StellingBeoordeeld>();
	      Iterable<Key<StellingBeoordeeld>> allKeys= ofy.query(StellingBeoordeeld.class).fetchKeys();
	      for (Key k : allKeys){
	    	 StellingBeoordeeld s = ofy.get(StellingBeoordeeld.class, k.getId());
	    	  result.add(s);
	      }
		   return result;
	}
	
	public List<Stelling> getAllStellingen() {
		ArrayList<Stelling> result2 = new ArrayList<Stelling>();
	      Iterable<Key<Stelling>> allKeys= ofy.query(Stelling.class).fetchKeys();
	      for (Key k : allKeys){
	    	 Stelling s = ofy.get(Stelling.class, k.getId());
	    	  result2.add(s);
	      }
		   return result2;
	}
	@Override
	public void updateStellingBeoordeeld(StellingBeoordeeld s) {
		System.out.println("Stelling: " + s.getUniekID() +", geupdate");
	}
	@Override
	public void deleteStellingBeoordeeld(StellingBeoordeeld s) {
		ofy.delete(s);
	}
	@Override
	public void createStellingBeoordeeld(String wd, int uniek, int stage) {
		ofy.put(new StellingBeoordeeld(wd, uniek, stage));
	}

	@Override
	public StellingBeoordeeld getStelling(int idee) {
		  StellingBeoordeeld result = null;
		  ArrayList<Stelling> stellingen = (ArrayList<Stelling>) getAllStellingen();
		  ArrayList<StellingBeoordeeld> stellingenbeoordeeld = (ArrayList<StellingBeoordeeld>) getAllStellingenBeoordeeld();
		  
	      for (StellingBeoordeeld s : stellingenbeoordeeld){
	    	  for(Stelling s2 : stellingen){
	    	  if (s.getUniekID() == s2.getUniekID() ){
	    		  result = s;
	    	  }
	    	  }
	      }
	      return result;
	}

}
