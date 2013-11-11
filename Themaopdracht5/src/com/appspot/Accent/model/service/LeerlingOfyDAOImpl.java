package com.appspot.Accent.model.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.appspot.Accent.model.Leerling;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class LeerlingOfyDAOImpl implements LeerlingOfyDAO {
	   private Objectify ofy;

	public LeerlingOfyDAOImpl(){
		  ofy = ObjectifyService.begin();

		
		
	}
	public void deleteLeerling(Leerling lu) {
		  //TODO delete user ofy
		   ofy.delete((lu));
	   }
	   
	   
	   public void createLeerling(String us, String pw, String em, String call, String achternm, Date gebdat, String kl, String doc){
	       ofy.put(new Leerling( us,  pw,  em, call,  achternm,  gebdat,  kl,  doc));

		   
	   }

	   
	   public List<Leerling> getAllLeerlingen() {
	      ArrayList<Leerling> result = new ArrayList<Leerling>();
	      Iterable<Key<Leerling>> allKeys= ofy.query(Leerling.class).fetchKeys();
	      for (Key k : allKeys){
	    	  Leerling lu = ofy.get(Leerling.class, k.getId());
	    	  result.add(lu);
	      }
		   return result;
	   }

	   public Leerling getLeerling(String username) {
		   Leerling result = null;
		   ArrayList<Leerling> leerlingen = (ArrayList<Leerling>) getAllLeerlingen();
	      for (Leerling lu : leerlingen){
	    	  if (lu.getUsername().equals(username)){
	    		  result = lu;
	    	  }
	      }
	      return result;
	   }

	   
	   public void updateLeerling(Leerling lu) {
			  //TODO update user ofy

	      System.out.println("LocalUser: " + lu.getUsername() +", activated in the database");
	   }



	
}
