package com.appspot.Accent.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appspot.Accent.model.Beoordeling;
import com.appspot.Accent.model.Competentie;
import com.appspot.Accent.model.Leerling;
import com.appspot.Accent.model.Stage;
import com.appspot.Accent.model.Stelling;
import com.googlecode.objectify.Objectify;

public class BeoordeelServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(BeoordeelServlet.class.getName());
	private Objectify ofy;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//		boolean succes = false;
		RequestDispatcher rd = null;
		Object o = req.getSession().getAttribute("userobject");
		Beoordeling rate =null;
		Stage deStage = null;
		Competentie nr1 = null;
		Competentie nr2 = null;
		Stelling stelling1 = null;		
		
		Stelling stelling2 = null;		
		
		Stelling stelling3 = null;		
		
		Stelling stelling4 = null;		
		
		Stelling stelling5 = null;		
		ArrayList<Beoordeling> allBeoordelingen = new ArrayList<Beoordeling>();
		//		ArrayList<Integer> allWaardes = new ArrayList<Integer>();
		//		int teller = 0;
		//		int stellingTeller = Integer.parseInt(req.getParameter("stellingTeller"));
		//		while(teller != stellingTeller){
		//			teller++;
		//			allWaardes.add(Integer.parseInt(req.getParameter("waarde"+teller)));
			
		
			ArrayList<Stage> allStages = (ArrayList<Stage>) getServletContext().getAttribute("stages");
			log.info("begin!");
			
			if (req.getParameter("Opslaan") != null){
				log.info("knop opslaan");
				for (Stage s : allStages) {
					if (o instanceof Leerling) {
						log.info("ingelogd als leerling");
		
						if (s.getDeLeerling()
								.equals(((Leerling) o).getUsername())) {
							log.info("de juiste leerling");
		
							allBeoordelingen =  s.getBeoordelingen();
								log.info("beoordelingen " + allBeoordelingen);
		
								for(Beoordeling be : allBeoordelingen){
									log.info("doorloop arraylist");
								
										if(be.getDatum() == null){
											log.info("geen datum");
								
										ArrayList<Competentie> competenties = be.getCompetenties();
										
										log.info("competenite " + competenties);
								
										int teller = 0;
										for(Competentie c : competenties){
											ArrayList<Stelling> stellingen = new ArrayList<Stelling>();
											stellingen = c.getDeStellingen();
											
											for(Stelling stel : stellingen){
												teller++;
								
												stel.setDeWaarde(req.getParameter("waarde"+ teller));
												log.info("waardes is" + req.getParameter("waarde"+ stel.getDeWaarde()) );
												
//												ofy.put(stel);
											}
											}
										}
										be.setOpmerking(req.getParameter("opmerking"));
											log.info(be.getOpmerking());
											Date d = new Date();
											String datum = d.toString();
										//	be.createBeoordeling(datum, be.getOpmerking());
								}
							}	
						}
					}
					
					
					
					String msgs = "<h4 class='alert_success'>U heeft de beoordeling successvol ingevuld.</h4>";
		
				req.setAttribute("msgs", msgs);
				
		
				getServletContext().setAttribute("stages", allStages);
				rd = req.getRequestDispatcher("index.jsp");
			}
			
			
			
			
			else{
			
		
			for (Stage s : allStages) {
				log.info("stage");
				if (o instanceof Leerling) {
					if (s.getDeLeerling()
							.equals(((Leerling) o).getUsername())) {
						 allBeoordelingen = s.getBeoordelingen();
						 
						 for(Beoordeling be : allBeoordelingen){
								log.info("beoordeling");
								if(be.getDatum() == null){

		
						 					// Te aant e passen na de core
						 					nr1 = new Competentie(
						 							"1. Samenwerken en overleggen");
						 					nr2 = new Competentie(
											"2. Aandacht en begrip tonen");
						 
						 				 stelling1 = new Stelling(
						 						"de leerling gedraagt zich zo dat samenwerking makkelijk gaat",
						 						null);
						 				 stelling2 = new Stelling(
												"De leerling past zich aan de groep aan", null);
						 				 stelling3 = new Stelling(
						 							"De leerling houdt zich aan de regels van het bedrijf",
						 							null);
						 					 stelling4 = new Stelling(
						 							"de leerling luister naar een ander", null);
						 					 stelling5 = new Stelling(
						 						"de leerling laat de ander uitpraten", null);
						String datum = "pp";
						 				be.setDatum(datum);
						 				
						 					
						 					
						 					nr1.getDeStellingen().add(stelling1);
						 					nr1.getDeStellingen().add(stelling2);
						 					nr1.getDeStellingen().add(stelling3);
						 					nr2.getDeStellingen().add(stelling4);
						 					nr2.getDeStellingen().add(stelling5);
						 					log.info("YOLO");
						 			
						 						
						 			be.getCompetenties().add(nr1);
						 			be.getCompetenties().add(nr2);		
		
						 }
								rate= be;
			 					deStage = s;
}
					}
				}
			}
			
//			nr1.getDeStellingen().add(stelling1);
//				nr1.getDeStellingen().add(stelling2);
//				nr1.getDeStellingen().add(stelling3);
//				nr2.getDeStellingen().add(stelling4);
//				nr2.getDeStellingen().add(stelling5);
//				log.info("YOLO");
//		
//					
//		rate.getCompetenties().add(nr1);
//		rate.getCompetenties().add(nr2);					 				
				deStage.setBeoordelingen(allBeoordelingen);
				req.setAttribute("competenties", null);
				req.setAttribute("competenties", deStage);
		
			rd = req.getRequestDispatcher("BeoordelenLeerling.jsp");
			}
			
			rd.forward(req, resp);	
		
			//}
		
		//	}
		
	
	
	}
}