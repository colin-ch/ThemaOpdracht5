package com.appspot.Accent.controller;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.appspot.Accent.model.Beoordeling;
import com.appspot.Accent.model.Leerling;
import com.appspot.Accent.model.Stage;
import com.appspot.Accent.model.StageBedrijf;
import com.appspot.Accent.model.StageBegeleider;
import com.appspot.Accent.model.StageOpleider;
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
		Date date = new Date();
		StageBegeleider stagebeg = new StageBegeleider("stage", "begeleider", "yahoo@gmail.com");
	Leerling stud = new Leerling("123", "123", "123@gmail.com", "leerling1", " ", "Student", "leerling1", 16, date, "V1IE", stagebeg );	
	StageBedrijf bedrijf1 = new StageBedrijf("bedrijf1", "123","bedrijf@gmail.com", "utrecht", "123456");
	StageOpleider opleider = new StageOpleider("jopie");
		Stage stage = new Stage(stud, opleider, bedrijf1, date, date);
	
	
	ArrayList<User> allUsers = new ArrayList<User>();
		allUsers.add(u);
		allUsers.add(u1);
		sce.getServletContext().setAttribute("users", allUsers);
		Beoordeling b = new Beoordeling("01/01/2013", 5, "Eerste competentie");

		
		
		
		ArrayList<Stage> allStages = new ArrayList<Stage>();
		allStages.add(stage);
		ArrayList<Beoordeling> allBeoordelingen = new ArrayList<Beoordeling>();
		allBeoordelingen.add(b);
		sce.getServletContext().setAttribute("stages", allStages);

		
	}

}
