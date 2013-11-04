package com.appspot.Accent.model.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.appspot.Accent.model.Leerling;
import com.appspot.Accent.model.StageBegeleider;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class StageBegeleiderOfyDAOImpl implements StageBegeleiderOfyDAO {
	   private Objectify ofy;

	public StageBegeleiderOfyDAOImpl(){
		  ofy = ObjectifyService.begin();

		
		
	}
	public void deleteBegeleider(StageBegeleider lu) {
		  //TODO delete user ofy
		   ofy.delete((lu));
	   }
	   
	   
	   public void createBegeleider(String us, String pw, String em){
	       ofy.put(new StageBegeleider( us,  pw,  em));

		   
	   }

	   
	   public List<StageBegeleider> getAllBegeleiders() {
	      ArrayList<StageBegeleider> result = new ArrayList<StageBegeleider>();
	      Iterable<Key<StageBegeleider>> allKeys= ofy.query(StageBegeleider.class).fetchKeys();
	      for (Key k : allKeys){
	    	  StageBegeleider lu = ofy.get(StageBegeleider.class, k.getId());
	    	  result.add(lu);
	      }
		   return result;
	   }

	   public StageBegeleider getBegeleider(String username) {
		   StageBegeleider result = null;
		   ArrayList<StageBegeleider> begeleiders = (ArrayList<StageBegeleider>) getAllBegeleiders();
	      for (StageBegeleider lu : begeleiders){
	    	  if (lu.getUsername().equals(username)){
	    		  result = lu;
	    	  }
	      }
	      return result;
	   }

	   
	   public void updateBegeleider(StageBegeleider lu) {
			  //TODO update user ofy

	    
	   }



	
}
