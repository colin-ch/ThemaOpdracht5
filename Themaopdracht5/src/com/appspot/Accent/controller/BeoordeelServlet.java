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
import com.appspot.Accent.model.StellingBeoordeeld;
import com.appspot.Accent.model.service.BeoordelingOfyDAOImpl;
import com.appspot.Accent.model.service.CompetentieOfyDAOImpl;
import com.appspot.Accent.model.service.StageOfyDAOImpl;
import com.appspot.Accent.model.service.StellingBeoordeeldOfyDAOImpl;
import com.appspot.Accent.model.service.StellingOfyDAOImpl;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

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
		ofy = ObjectifyService.begin();
		Beoordeling rate =null;
		Stage deStage = null;
		Competentie nr1 = null;
		Competentie nr2 = null;
		Stelling stelling1 = null;		
		
		Stelling stelling2 = null;		
		
		Stelling stelling3 = null;		
		
		Stelling stelling4 = null;		
		
		Stelling stelling5 = null;
		StellingBeoordeeld beoordeeldeStelling = null;
		ArrayList<Beoordeling> allBeoordelingen = new ArrayList<Beoordeling>();
		//		ArrayList<Integer> allWaardes = new ArrayList<Integer>();
		//		int teller = 0;
		//		int stellingTeller = Integer.parseInt(req.getParameter("stellingTeller"));
		//		while(teller != stellingTeller){
		//			teller++;
		//			allWaardes.add(Integer.parseInt(req.getParameter("waarde"+teller)));
			
		StageOfyDAOImpl stod = new StageOfyDAOImpl();
boolean nextS = false;
		BeoordelingOfyDAOImpl bod = new BeoordelingOfyDAOImpl();
		CompetentieOfyDAOImpl cod = new CompetentieOfyDAOImpl();
		StellingOfyDAOImpl sod = new StellingOfyDAOImpl();
		ArrayList<Integer> waardesl = new ArrayList<Integer>();
		ArrayList<Integer> waardesIDs = new ArrayList<Integer>();
		ArrayList<Integer> ints = new ArrayList<Integer>();
		// alles wordt aangemaakt
			ArrayList<Stage> allStages = (ArrayList<Stage>) stod.getAllStages() ;
			
			// inde volgende stuk wordt gekeken naar wie de leerling is en welke beoordeling hij meot doen (daar is nog geen datum van)
			if (req.getParameter("Opslaan") != null){
				log.info("knop opslaan");
				for (Stage s : allStages) {
					if (o instanceof Leerling) {
						//log.info("ingelogd als leerling");
						if (s.getDeLeerling()
								.equals(((Leerling) o).getUsername())) {

							//log.info("de juiste leerling");
							
							allBeoordelingen =  (ArrayList<Beoordeling>) bod.getAllBeoordelingen();
								//log.info("beoordelingen " + allBeoordelingen);
		
								for(Beoordeling be : allBeoordelingen){
									//log.info("doorloop arraylist");
									if(be.getStage() == s.getId()){
										if(be.getDatumLeerling() == null){
											log.info("geen datum");
											rate = be;
										ints = be.getCompetenties();
										ArrayList<Competentie> competenties = new ArrayList<Competentie>();
										for(Integer inter : ints){
											ArrayList<Competentie> allCompetenties = (ArrayList<Competentie>) cod.getAllCompetenties();
											for(Competentie allc : allCompetenties){
												if(allc.getEigenId() == inter){
													competenties.add(allc);
												}
											}
										}
										log.info("competenite " + competenties);
								
										int teller = 0;
										for(Competentie c : competenties){
											ArrayList<Stelling> stellingen = new ArrayList<Stelling>();
											stellingen = (ArrayList<Stelling>) sod.getAllStellingen();
											StellingBeoordeeldOfyDAOImpl sbod = new StellingBeoordeeldOfyDAOImpl();

											ArrayList<StellingBeoordeeld> beoordeelStellingen = (ArrayList <StellingBeoordeeld>) sbod.getAllStellingenBeoordeeld();

											  ArrayList <StellingBeoordeeld> currentbeoordelen = new ArrayList<StellingBeoordeeld>();
						                        for(StellingBeoordeeld sbfill : beoordeelStellingen){
						                        	if(s.getId() == sbfill.getDeStage()){
						                        		if(sbfill.getDeWaardeLeerling() == null){
						                        			currentbeoordelen.add(sbfill);
						                        		}
						                        	}
						                        }
											
											for(Stelling stel : stellingen){
												for(StellingBeoordeeld sb : currentbeoordelen){

												if(c.getEigenId() == stel.getEigenId()){
												teller++;
												if(be.getIDBeoordeling().equals(sb.getIDBeoordeling())){
												
												String s2 = req.getParameter("" +stel.getUniekID());
												int id = stel.getUniekID();
											
												
												
												beoordeeldeStelling = sb;
												
												if(req.getParameter("" +sb.getUniekID()).equals("1")){
beoordeeldeStelling.setDeWaardeLeerling("1");
													
													ofy.put(beoordeeldeStelling);
												}
												if(req.getParameter("" +sb.getUniekID()).equals("2")){
beoordeeldeStelling.setDeWaardeLeerling("2");
													
													ofy.put(beoordeeldeStelling);
												}
												if(req.getParameter("" +sb.getUniekID()).equals("3")){
beoordeeldeStelling.setDeWaardeLeerling("3");
													
													ofy.put(beoordeeldeStelling);
												}
												if(req.getParameter("" +sb.getUniekID()).equals("4")){
beoordeeldeStelling.setDeWaardeLeerling("4");
													
													ofy.put(beoordeeldeStelling);
												}
												
												
												

												}}
												
											}
												
												
											}
											}
										rate = be;
										
										
								
								rate.setOpmerkingLeerling(req.getParameter("opmerking"));
								if(req.getParameter("opmerking").equals("")){
									rate.setOpmerkingLeerling("geen opmerking");
								}
								// alles wordt buiten de arraylist gewijzigd
								log.info(rate.getOpmerkingLeerling());
								Date d = new Date();
								String datum = d.toString();
								rate.setDatumLeerling(datum);
								ofy.put(rate);
							}	}
						}
					}}}
					
					// er wordt een message meegegeven
					
					String msgs = "U heeft de beoordeling successvol ingevuld.";
		
				req.setAttribute("msgs", msgs);
				
		
				getServletContext().setAttribute("stages", allStages);
				rd = req.getRequestDispatcher("index.jsp");
			}
			
			
		
			
			else{
			rd = req.getRequestDispatcher("BeoordelenLeerling.jsp");
			}
			
			rd.forward(req, resp);	
		
			//}
		
		//	}
		
	
	
	}
}