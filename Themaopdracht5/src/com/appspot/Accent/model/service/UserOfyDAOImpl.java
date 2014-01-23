package com.appspot.Accent.model.service;

import java.util.ArrayList;
import java.util.List;

import com.appspot.Accent.model.Docent;
import com.appspot.Accent.model.User;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class UserOfyDAOImpl implements UserOfyDAO {
	   private Objectify ofy;

	public UserOfyDAOImpl(){
		  ofy = ObjectifyService.begin();
	
	}  
	@Override
	public List<User> getAllUsers() {
		ArrayList<User> result = new ArrayList<User>();
	      Iterable<Key<User>> allKeys= ofy.query(User.class).fetchKeys();
	      for (Key k : allKeys){
	    	  User d = ofy.get(User.class, k.getId());
	    	  result.add(d);
	      }
		   return result;
	}
	@Override
	public User getUser(String em) {
		User result = null;
		  ArrayList<User> users = (ArrayList<User>) getAllUsers();
	      for (User d : users){
	    	  if (d.getEmail().equals(em)){
	    		  result = d;
	    	  }
	      }
	      return result;
	}
	@Override
	public void updateUser(User d) {
		// TODO Auto-generated method stub
		System.out.println("User: " + d.getEmail() +", geupdate");
	}
	@Override
	public void deleteUser(User d) {
		ofy.delete(d);
	}
	@Override
	public void createUser(String us, String pw, String em) {
		ofy.put(new User(us, pw, em));
	}



	
}
