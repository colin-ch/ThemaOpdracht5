package com.appspot.Accent.model.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.appspot.Accent.model.Beoordeling;
import com.appspot.Accent.model.Leerling;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class BeoordelingOfyDAOImpl implements BeoordelingOfyDAO {
	   private Objectify ofy;

	public BeoordelingOfyDAOImpl(){
		  ofy = ObjectifyService.begin();
	
	}  
	@Override
	public List<Beoordeling> getAllBeoordelingen() {
		ArrayList<Beoordeling> result = new ArrayList<Beoordeling>();
	      Iterable<Key<Beoordeling>> allKeys= ofy.query(Beoordeling.class).fetchKeys();
	      for (Key k : allKeys){
	    	 Beoordeling b = ofy.get(Beoordeling.class, k.getId());
	    	  result.add(b);
	      }
		   return result;
	}
	@Override
	public Beoordeling getBeoordeling(String datum) {
		  Beoordeling result = null;
		  ArrayList<Beoordeling> beoordelingen = (ArrayList<Beoordeling>) getAllBeoordelingen();
	      for (Beoordeling b : beoordelingen){
	    	  if (b.getDatum().equals(datum)){
	    		  result = b;
	    	  }
	      }
	      return result;
	}
	@Override
	public void updateBeoordeling(Beoordeling b) {
		// TODO Auto-generated method stub
		System.out.println("Beoordeling: " + b.getDatum() +", geupdate");
	}
	@Override
	public void deleteBeoordeling(Beoordeling b) {
		ofy.delete(b);
	}
	@Override
	public void createBeoordeling(String dt, String opm, ArrayList c, ArrayList l) {
		ofy.put(new Beoordeling(dt, opm, c, l));
	}



	
}
