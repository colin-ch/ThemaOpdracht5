package com.appspot.Accent.model.service;

import java.util.ArrayList;
import java.util.List;

import com.appspot.Accent.model.Docent;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class DocentOfyDAOImpl implements DocentOfyDAO {
	   private Objectify ofy;

	public DocentOfyDAOImpl(){
		  ofy = ObjectifyService.begin();
	
	}  
	@Override
	public List<Docent> getAllDocenten() {
		ArrayList<Docent> result = new ArrayList<Docent>();
	      Iterable<Key<Docent>> allKeys= ofy.query(Docent.class).fetchKeys();
	      for (Key k : allKeys){
	    	  Docent d = ofy.get(Docent.class, k.getId());
	    	  result.add(d);
	      }
		   return result;
	}
	@Override
	public Docent getDocent(String em) {
		Docent result = null;
		  ArrayList<Docent> docenten = (ArrayList<Docent>) getAllDocenten();
	      for (Docent d : docenten){
	    	  if (d.getEmail().equals(em)){
	    		  result = d;
	    	  }
	      }
	      return result;
	}
	@Override
	public void updateDocent(Docent d) {
		// TODO Auto-generated method stub
		System.out.println("Docent: " + d.getEmail() +", geupdate");
	}
	@Override
	public void deleteDocent(Docent d) {
		ofy.delete(d);
	}
	@Override
	public void createDocent(String us, String pw, String em) {
		ofy.put(new Docent(us, pw, em));
	}



	
}
