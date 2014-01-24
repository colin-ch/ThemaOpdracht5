package com.appspot.Accent.controller;

import java.util.ArrayList;
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
import com.appspot.Accent.model.StellingBeoordeeld;
import com.appspot.Accent.model.User;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class UserContextListener implements ServletContextListener {
	private static final Logger log = Logger.getLogger(UserContextListener.class.getName());
	private Objectify ofy;
	
	
	

   // private PreparedStatement preparedStatement = null;
  
    //private ResultSet resultSet = null;
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}
	
	

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ofy = ObjectifyService.begin();
		//ObjectifyService.register(Stelling.class);
		//ObjectifyService.register(Competentie.class);
		
//		User u1 = new User("12345", "12345", "12345@gmail.com");
		//er wordt een dummy objecten aangemaakt
		Date date = new Date();
		StageBegeleider stagebeg = new StageBegeleider("stage", "begeleider", "yahoo@gmail.com");
		Leerling u = new Leerling("123", "123", "123@gmail.com", "leerling1", "Student", date, "V1IE", stagebeg.getEmail() );	
		StageBedrijf bedrijf1 = new StageBedrijf("bedrijf1", "123","bedrijf@gmail.com", "utrecht", "123456");
		StageOpleider opleider = new StageOpleider("jopie");
		Stage stage = new Stage(1, u.getUsername(), stagebeg.getEmail(), opleider.getNaam(), bedrijf1.getUsername(), date, date);
		Docent d = new Docent("docent", "pass", "email@gmail.com");
		
		User u1 = new User("beheerder", "wachtwoord", "123@gmail.com");
		
		
		
		
		
		/*
			Competentie nr1 = new Competentie(1, "1. Samenwerken en overleggen"); 	ofy.put(nr1);
			Stelling stelling1 = new Stelling(1, "de leerling gedraagt zich zo dat samenwerking makkelijk gaat", "1", 1);ofy.put(stelling1);
			Stelling stelling2 = new Stelling(1, "De leerling past zich aan de groep aan", "1", 2);ofy.put(stelling2);
			Stelling stelling3 = new Stelling(1, "De leerling houdt zich aan de regels van het bedrijf","1", 3);ofy.put(stelling3);
		
			Competentie nr2 = new Competentie(2, "2. Aandacht en begrip tonen");    ofy.put(nr2);
			Stelling stelling4 = new Stelling(2, "de leerling luister naar een ander", "1", 4);ofy.put(stelling4);
			Stelling stelling5 = new Stelling(2, "de leerling laat de ander uitpraten", "1", 5);ofy.put(stelling5);
			Stelling s6 = new Stelling(2, "De leerling zegt of doet dingen zo dat anderen er geen last van hebben", "1", 6);ofy.put(s6);
			Stelling s7 = new Stelling(2, "De leerling doet geen dingen waarvan de leerling weet dat iemand er niet tegen kan", "1", 7);ofy.put(s7);
			Stelling s8 = new Stelling(2, "De leerling gaat goed om met iets wat hem in vertrouwen is verteld", "1", 7);ofy.put(s8);
		
		Competentie nr3 = new Competentie(3, "3. Klantvriendelijk en dienstverlenend");ofy.put(nr3); 
			Stelling s9 = new Stelling(3, "De leerling is zich bewust van klanten", "1", 9);ofy.put(s9);
			Stelling s10 = new Stelling(3, "De leerling groet de klant", "1", 10);ofy.put(s10);
			Stelling s11 = new Stelling(3, "De leerling toont passend gedrag: houding en taalgebruik", "1", 11);ofy.put(s11);
		
		Competentie nr4 = new Competentie(4, "4. Instructies en procedures opvolgen");ofy.put(nr4);
			Stelling s12 = new Stelling(4, "De leerling doet de dingen in een logische volgorde", "1", 12);ofy.put(s12);
			Stelling s13 = new Stelling(4, "De leerling geeft aan of de leerling een opdracht wel of niet begrijpt en kan uitvoeren.", "1", 13);ofy.put(s13);
			Stelling s14 = new Stelling(4, "De leerling gebruikt materialen en gereedschappen volgens de veiligheidsinstructies.", "1", 14);ofy.put(s14);
			Stelling s15 = new Stelling(4, "De leerling houdt zich aan de regels van het bedrijf.", "1", 15);ofy.put(s15);
			Stelling s16 = new Stelling(4, "De leerling luistert naar instructies", "1", 16);ofy.put(s16);
			Stelling s17 = new Stelling(4, "De leerling neemt pauze als het werk het toelaat", "1", 17);ofy.put(s17);
			Stelling s18 = new Stelling(4, "De leerling ruimt op na instructie", "1", 18);ofy.put(s18);
		
		Competentie nr5 = new Competentie(5, "5. Plannen en organiseren");ofy.put(nr5);
			Stelling s19 = new Stelling(5, "De leerling kan op tijd komen", "1", 19);ofy.put(s19);
		
		Competentie nr6 = new Competentie(6, "6. Kwaliteit en vakdeskundigheid");	ofy.put(nr6);
			Stelling s20 = new Stelling(6, "De leerling volgt de instructie op", "1", 20);ofy.put(s20);
			Stelling s21 = new Stelling(6, "De leerling ruimt op wanneer het hem gevraagd wordt", "1", 21);ofy.put(s21);
			Stelling s22 = new Stelling(6, "De leerling maakt het werk af volgens afspraak", "1", 22);ofy.put(s22);
			Stelling s23 = new Stelling(6, "De leerling voert het werk in de voorgeschreven volgorde uit", "1", 23);ofy.put(s23);
			Stelling s24 = new Stelling(6, "De leerling doet de dingen op de afgesproken tijden", "1", 24);ofy.put(s24);
			Stelling s25 = new Stelling(6, "De leerling kent een aantal vaktermen", "1", 25);ofy.put(s25);
			Stelling s26 = new Stelling(6, "De leerling voert zijn taken onder begeleiding uit.", "1", 26);ofy.put(s26);
			Stelling s27 = new Stelling(6, "De leerling maakt materialen en gereedschappen op de juiste manier schoon.", "1", 27);ofy.put(s27);
			Stelling s28 = new Stelling(6, "De leerling ruimt materialen en gereedschappen na gebruik op", "1", 28);ofy.put(s28);
		
		Competentie nr7 = new Competentie(7, "7. Veilig werken");ofy.put(nr7);
			Stelling s29 = new Stelling(7, "De leerling krijgt hulp bij het gebruik van materialen", "1", 29);ofy.put(s29);
			Stelling s30 = new Stelling(7, "De leerling kent de namen van de meest gebruikte materialen", "1", 30);ofy.put(s30);
			Stelling s31 = new Stelling(7, "De leerling let op eigen veiligheid", "1", 31);ofy.put(s31);
			Stelling s32 = new Stelling(7, "De leerling ruimt zelf zijn materiaal op", "1", 32);ofy.put(s32);
			Stelling s33 = new Stelling(7, "De leerling gaat goed om met mensen met een andere achtergrond", "1", 33);ofy.put(s33);
			Stelling s34 = new Stelling(7, "De leerling vindt het geen probleem om steeds andere taken uit te voeren", "1", 34);ofy.put(s34);
			
		Competentie nr8 = new Competentie(8, "8. Met druk en tegenslag omgaan");ofy.put(nr8);
			Stelling s35 = new Stelling(8, "De leerling meldt het als zich een probleem voordoet", "1", 35);ofy.put(s35);
			Stelling s36 = new Stelling(8, "De leerling vraagt hulp bij problemen", "1", 36);ofy.put(s36);
		
		Competentie nr9 = new Competentie(9, "9. Omgaan met verandering en aanpassen");ofy.put(nr9);
			Stelling s37 = new Stelling(9, "De leerling accepteert dat iedereen andere taken heeft", "1", 37);ofy.put(s37);
			Stelling s38 = new Stelling(9, "De leerling gaat goed om met mensen met een andere achtergrond", "1", 38);ofy.put(s38);
			Stelling s39 = new Stelling(9, "De leerling vindt het geen probleem om steeds andere taken uit te voeren", "1", 39);ofy.put(s39);

		Competentie nr10 = new Competentie(10, "10.Leren");ofy.put(nr10);
			Stelling s40 = new Stelling(10, "De leerling toont interesse in nieuwe dingen", "1", 40);ofy.put(s40);
			Stelling s41 = new Stelling(10, "De leerling staat open voor aanwijzingen", "1", 41);ofy.put(s41);
			Stelling s42 = new Stelling(10, "De leerling stelt vragen", "1", 42);ofy.put(s42);
			Stelling s43 = new Stelling(10, "De leerling toont inzet", "1", 43);ofy.put(s43);
			Stelling s44 = new Stelling(10, "De leerling toont interesse in het werk", "1", 44);ofy.put(s44);
			
		*/
		
		
	
		
	
		
		
	
		
		
	
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		//array.add(nr1.getEigenId());
		//array.add(nr2.getEigenId());
		//Beoordeling b = new Beoordeling(null, "opmerking", stage.getId(), array, null, null);
	
		
		
		
		
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
		// alle classes worden geregistreerd
		Objectify ofy = ObjectifyService.begin();
		
		ObjectifyService.register(Docent.class);
		ObjectifyService.register(Beoordeling.class);
		ObjectifyService.register(Competentie.class);
		ObjectifyService.register(StageOpleider.class);
		ObjectifyService.register(StageBegeleider.class);
		ObjectifyService.register(StageBedrijf.class);
		ObjectifyService.register(Stage.class);
		ObjectifyService.register(Stelling.class);
		ObjectifyService.register(StellingBeoordeeld.class);
		ObjectifyService.register(Leerling.class);
		ObjectifyService.register(User.class);
		//ofy.put(u1);
		
		
		// alle objecten worden in de datastore gezet
		
/*	ofy.put(u);
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
		ofy.put(b);
		*/	
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
