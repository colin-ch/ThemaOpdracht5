package com.appspot.Accent.model.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.appspot.Accent.model.Beoordeling;
import com.appspot.Accent.model.Leerling;
import com.appspot.Accent.model.Stelling;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class StellingOfyDAOImpl implements StellingOfyDAO {
	   private Objectify ofy;

	public StellingOfyDAOImpl(){
		  ofy = ObjectifyService.begin();
	}  

	@Override
	public List<Stelling> getAllStellingen() {
		ArrayList<Stelling> result = new ArrayList<Stelling>();
	      Iterable<Key<Stelling>> allKeys= ofy.query(Stelling.class).fetchKeys();
	      for (Key k : allKeys){
	    	 Stelling s = ofy.get(Stelling.class, k.getId());
	    	  result.add(s);
	      }
		   return result;
	}
	@Override
	public void updateStelling(Stelling s) {
		System.out.println("Stelling: " + s.getDeStelling() +", geupdate");
	}
	@Override
	public void deleteStelling(Stelling s) {
		ofy.delete(s);
	}
	@Override
	public void createStelling(int idee, String stel, String wd) {
		ofy.put(new Beoordeling(stel, wd));
	}

	@Override
	public Stelling getStelling(int idee) {
		  Stelling result = null;
		  ArrayList<Stelling> stellingen = (ArrayList<Stelling>) getAllStellingen();
	      for (Stelling s : stellingen){
	    	  if (s.getEigenId() == idee){
	    		  result = s;
	    	  }
	      }
	      return result;
	}

}
