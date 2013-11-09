package com.appspot.Accent.controller;

import java.util.Date;
import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.appspot.Accent.model.Beoordeling;
import com.appspot.Accent.model.Competentie;
import com.appspot.Accent.model.Docent;
import com.appspot.Accent.model.Leerling;
import com.appspot.Accent.model.Stage;
import com.appspot.Accent.model.StageBedrijf;
import com.appspot.Accent.model.StageBegeleider;
import com.appspot.Accent.model.StageOpleider;
import com.appspot.Accent.model.Stelling;
import com.appspot.Accent.model.service.LeerlingOfyDAO;
import com.appspot.Accent.model.service.LeerlingOfyDAOImpl;
import com.appspot.Accent.model.service.StageBedrijfOfyDAO;
import com.appspot.Accent.model.service.StageBedrijfOfyDAOImpl;
import com.appspot.Accent.model.service.StageBegeleiderOfyDAO;
import com.appspot.Accent.model.service.StageBegeleiderOfyDAOImpl;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class UserContextListener implements ServletContextListener {
	private static final Logger log = Logger.getLogger(UserContextListener.class.getName());
   // private PreparedStatement preparedStatement = null;
  
    //private ResultSet resultSet = null;
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}
	
	

	@Override
	public void contextInitialized(ServletContextEvent sce) {
//		User u1 = new User("12345", "12345", "12345@gmail.com");
		Date date = new Date();
		StageBegeleider stagebeg = new StageBegeleider("stage", "begeleider", "yahoo@gmail.com");
		Leerling u = new Leerling("123", "123", "123@gmail.com", "leerling1", " ", "Student", "leerling1", 16, date, "V1IE", stagebeg.getEmail() );	
		StageBedrijf bedrijf1 = new StageBedrijf("bedrijf1", "123","bedrijf@gmail.com", "utrecht", "123456");
		StageOpleider opleider = new StageOpleider("jopie");
		Stage stage = new Stage(1, u.getUsername(), opleider.getNaam(), bedrijf1.getUsername(), date, date);
		Docent d = new Docent("docent", "pass", "email@gmail.com");
		Stelling stelling1 = new Stelling(1, "de leerling gedraagt zich zo dat samenwerking makkelijk gaat", null);
		Stelling stelling2 = new Stelling(1, "De leerling past zich aan de groep aan", null);
		Stelling stelling3 = new Stelling(1, "De leerling houdt zich aan de regels van het bedrijf",null);
		Stelling stelling4 = new Stelling(2, "de leerling luister naar een ander", null);
		Stelling stelling5 = new Stelling(2, "de leerling laat de ander uitpraten", null);
		Competentie nr1 = new Competentie(1, "1. Samenwerken en overleggen");
		Competentie nr2 = new Competentie(2, "2. Aandacht en begrip tonen");
		Beoordeling b = new Beoordeling("01/01/2013", "opmerking");
	
		
		
		
		
/*		ArrayList<Leerling> allUsers = new ArrayList<Leerling>();
//		allUsers.add(u1);
		allUsers.add(u);
		sce.getServletContext().setAttribute("users", allUsers);
		
		Beoordeling b = new Beoordeling(null, "Eerste competentie");
		ArrayList<Beoordeling> allBeoordelingen = new ArrayList<Beoordeling>();
		allBeoordelingen.add(b);
		 stage.getBeoordelingen().add(b);
		ArrayList<Stage> allStages = new ArrayList<Stage>();
		allStages.add(stage);
		sce.getServletContext().setAttribute("stages", allStages);*/
		
		Objectify ofy = ObjectifyService.begin();
		ObjectifyService.register(Leerling.class);
		ObjectifyService.register(Docent.class);
		ObjectifyService.register(Beoordeling.class);
		ObjectifyService.register(Competentie.class);
		ObjectifyService.register(StageOpleider.class);
		ObjectifyService.register(StageBegeleider.class);
		ObjectifyService.register(StageBedrijf.class);
		ObjectifyService.register(Stage.class);
		ObjectifyService.register(Stelling.class);
		
/*		ofy.put(u);
		ofy.put(d);
		ofy.put(stagebeg);
		ofy.put(bedrijf1);
		ofy.put(opleider);
		ofy.put(stage);
		ofy.put(stelling1);
		ofy.put(stelling2);
		ofy.put(stelling3);	//Een malig runnen, dit staat in GAE. Laatste update was 9-11-13 11:00
		ofy.put(stelling4);	//dit is het toevoegen van testwaardes
		ofy.put(stelling5); // moet nog geupdate worden op GAE
		ofy.put(nr1);
		ofy.put(nr2);
		ofy.put(b);*/
		
/*		LeerlingOfyDAO lu3 = new LeerlingOfyDAOImpl();
		System.out.println("alle leerlingen " + lu3.getAllLeerlingen());	
		
		StageBegeleiderOfyDAO beg = new StageBegeleiderOfyDAOImpl();	
		System.out.println("alle begeleiders " + beg.getAllBegeleiders());	
		
		StageBedrijfOfyDAO bedr = new StageBedrijfOfyDAOImpl();	
		System.out.println("alle bedrijven " + bedr.getAllStageBedrijven());	*/
	

		  
		
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
