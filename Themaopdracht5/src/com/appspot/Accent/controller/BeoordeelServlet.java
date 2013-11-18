package com.appspot.Accent.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import com.appspot.Accent.model.service.BeoordelingOfyDAOImpl;
import com.appspot.Accent.model.service.CompetentieOfyDAOImpl;
import com.appspot.Accent.model.service.StageOfyDAOImpl;
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
		ArrayList<Beoordeling> allBeoordelingen = new ArrayList<Beoordeling>();
		//		ArrayList<Integer> allWaardes = new ArrayList<Integer>();
		//		int teller = 0;
		//		int stellingTeller = Integer.parseInt(req.getParameter("stellingTeller"));
		//		while(teller != stellingTeller){
		//			teller++;
		//			allWaardes.add(Integer.parseInt(req.getParameter("waarde"+teller)));
			
		StageOfyDAOImpl stod = new StageOfyDAOImpl();

		BeoordelingOfyDAOImpl bod = new BeoordelingOfyDAOImpl();
		CompetentieOfyDAOImpl cod = new CompetentieOfyDAOImpl();
		StellingOfyDAOImpl sod = new StellingOfyDAOImpl();
		ArrayList<Integer> waardesl = new ArrayList<Integer>();
		ArrayList<Integer> ints = new ArrayList<Integer>();
		
			ArrayList<Stage> allStages = (ArrayList<Stage>) stod.getAllStages() ;
			
			if (req.getParameter("Opslaan") != null){
				log.info("knop opslaan");
				for (Stage s : allStages) {
					if (o instanceof Leerling) {
						log.info("ingelogd als leerling");
		
						if (s.getDeLeerling()
								.equals(((Leerling) o).getUsername())) {
							log.info("de juiste leerling");
		
							allBeoordelingen =  (ArrayList<Beoordeling>) bod.getAllBeoordelingen();
								log.info("beoordelingen " + allBeoordelingen);
		
								for(Beoordeling be : allBeoordelingen){
									log.info("doorloop arraylist");
								
										if(be.getDatum() == null){
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
											
											for(Stelling stel : stellingen){
												if(c.getEigenId() == stel.getEigenId()){
												teller++;
												
												log.info("waardes is" + req.getParameter("waarde"+ stel.getDeWaarde()) );
												String s2 = req.getParameter("" +stel.getUniekID());
												int i2 = Integer.parseInt(s2);
												waardesl.add(i2);
												
												
//												ofy.put(stel);
												}
											}
											}
										}
										be.setOpmerking(req.getParameter("opmerking"));
											log.info(be.getOpmerking());
											Date d = new Date();
											String datum = d.toString();
											be.setDatum(datum);
											
											be.setDeWaardesLeerling(waardesl);
											ofy.put(be);
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
			rd = req.getRequestDispatcher("BeoordelenLeerling.jsp");
			}
			
			rd.forward(req, resp);	
		
			//}
		
		//	}
		
	
	
	}
}