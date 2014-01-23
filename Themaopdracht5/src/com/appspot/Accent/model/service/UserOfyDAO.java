package com.appspot.Accent.model.service;

import java.util.List;

import com.appspot.Accent.model.User;


public interface UserOfyDAO {
	   public List<User> getAllUsers();
	   public User getUser(String em);
	   public void updateUser(User d);
	   public void deleteUser(User d);
	   public void createUser(String us, String pw, String em);
	}


