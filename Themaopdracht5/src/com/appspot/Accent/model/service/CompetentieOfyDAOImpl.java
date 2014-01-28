package com.appspot.Accent.model.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.appspot.Accent.model.Competentie;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class CompetentieOfyDAOImpl implements CompetentieOfyDAO {
	   private Objectify ofy;

	public CompetentieOfyDAOImpl(){
		  ofy = ObjectifyService.begin();
	}  

	@Override
	public List<Competentie> getAllCompetenties() {
		ArrayList<Competentie> result = new ArrayList<Competentie>();
		for(int t = 0; t <10 ; t++){
			result.add(null);
		}
	      Iterable<Key<Competentie>> allKeys= ofy.query(Competentie.class).fetchKeys();
	      for (Key k : allKeys){
	    	  Competentie c = ofy.get(Competentie.class, k.getId());
	    	  int i = c.getEigenId();
	    	  i--;
	    	  result.add(i, c);
	      }
	      
	      result.removeAll(Collections.singleton(null));
		   return result;
	}
	@Override
	public void updateCompetentie(Competentie c) {
		System.out.println("Competentie: " + c.getTitel() +", geupdate");
	}
	@Override
	public void deleteCompetentie(Competentie c) {
		ofy.delete(c);
	}
	@Override
	public void createCompetentie(int idee, String titel) {
		ofy.put(new Competentie(idee, titel));
	}

	@Override
	public Competentie getCompetentie(int idee, String titel) {
		  Competentie result = null;
		  ArrayList<Competentie> Competenties = (ArrayList<Competentie>) getAllCompetenties();
	      for (Competentie c : Competenties){
	    	  if (c.getTitel().equals(titel)){
	    		  result = c;
	    	  }
	      }
	      return result;
	}

}
