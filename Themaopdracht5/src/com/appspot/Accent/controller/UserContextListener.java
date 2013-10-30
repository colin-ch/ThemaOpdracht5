package com.appspot.Accent.controller;

import java.util.ArrayList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.appspot.Accent.model.Beoordeling;
import com.appspot.Accent.model.User;

public class UserContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		User u = new User("123", "123", "123@gmail.com");
		User u1 = new User("12345", "12345", "12345@gmail.com");
		ArrayList<User> allUsers = new ArrayList<User>();
		allUsers.add(u);
		allUsers.add(u1);
		sce.getServletContext().setAttribute("users", allUsers);
		Beoordeling b = new Beoordeling("01/01/2013", 5, "Eerste competentie");
		
	}

}
