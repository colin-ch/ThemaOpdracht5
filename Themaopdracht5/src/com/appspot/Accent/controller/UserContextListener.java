package com.appspot.Accent.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appspot.Accent.model.Beoordeling;
import com.appspot.Accent.model.Competentie;
import com.appspot.Accent.model.Leerling;
import com.appspot.Accent.model.Stage;
import com.appspot.Accent.model.StageBedrijf;
import com.appspot.Accent.model.StageBegeleider;
import com.appspot.Accent.model.StageOpleider;
import com.appspot.Accent.model.Stelling;
import com.appspot.Accent.model.User;

public class UserContextListener implements ServletContextListener {
	private static final Logger log = Logger.getLogger(UserContextListener.class.getName());
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
	
	

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		User u1 = new User("12345", "12345", "12345@gmail.com");
		Date date = new Date();
		StageBegeleider stagebeg = new StageBegeleider("stage", "begeleider", "yahoo@gmail.com");
	Leerling u = new Leerling("123", "123", "123@gmail.com", "leerling1", " ", "Student", "leerling1", 16, date, "V1IE", stagebeg );	
	StageBedrijf bedrijf1 = new StageBedrijf("bedrijf1", "123","bedrijf@gmail.com", "utrecht", "123456");
	StageOpleider opleider = new StageOpleider("jopie");
		Stage stage = new Stage(1, u, opleider, bedrijf1, date, date);
	
	ArrayList<User> allUsers = new ArrayList<User>();
		allUsers.add(u);
		allUsers.add(u1);
		sce.getServletContext().setAttribute("users", allUsers);
		
		Beoordeling b = new Beoordeling(null, 5, "Eerste competentie");
		ArrayList<Beoordeling> allBeoordelingen = new ArrayList<Beoordeling>();
		allBeoordelingen.add(b);
		 stage.getBeoordelingen().add(b);
		ArrayList<Stage> allStages = new ArrayList<Stage>();
		allStages.add(stage);
		sce.getServletContext().setAttribute("stages", allStages);
		
		// Te aant e passen na de core
//		Competentie nr1 = new Competentie(
//				"1. Samenwerken en overleggen");
//		Competentie nr2 = new Competentie(
//				"2. Aandacht en begrip tonen");
//
//		Stelling stelling1 = new Stelling(
//				"de leerling gedraagt zich zo dat samenwerking makkelijk gaat",
//				null);
//		Stelling stelling2 = new Stelling(
//				"De leerling past zich aan de groep aan", null);
//		Stelling stelling3 = new Stelling(
//				"De leerling houdt zich aan de regels van het bedrijf",
//				null);
//		Stelling stelling4 = new Stelling(
//				"de leerling luister naar een ander", null);
//		Stelling stelling5 = new Stelling(
//				"de leerling laat de ander uitpraten", null);
//		ArrayList<Stelling> alleStellingen = new ArrayList<Stelling>();
//		alleStellingen.add(stelling1);
//		alleStellingen.add(stelling2);
//		alleStellingen.add(stelling3);
//		alleStellingen.add(stelling4);
//		alleStellingen.add(stelling5);
//		sce.getServletContext().setAttribute("stellingen", alleStellingen);
//		
//
//		nr1.getDeStellingen().add(stelling1);
//		nr1.getDeStellingen().add(stelling2);
//		nr1.getDeStellingen().add(stelling3);
//		nr2.getDeStellingen().add(stelling4);
//		nr2.getDeStellingen().add(stelling5);
//
//		ArrayList<Competentie> competenties = new ArrayList<Competentie>();
//		competenties.add(nr1);
//		competenties.add(nr2);
//		sce.getServletContext().setAttribute("competenties", competenties);


		
	}

}
