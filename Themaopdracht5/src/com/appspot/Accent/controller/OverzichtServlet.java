package com.appspot.Accent.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appspot.Accent.model.Beoordeling;
import com.appspot.Accent.model.Leerling;
import com.appspot.Accent.model.School;
import com.appspot.Accent.model.Stage;
import com.appspot.Accent.model.Stelling;
import com.appspot.Accent.model.StellingBeoordeeld;
import com.appspot.Accent.model.service.BeoordelingOfyDAOImpl;
import com.appspot.Accent.model.service.StageOfyDAOImpl;
import com.appspot.Accent.model.service.StellingBeoordeeldOfyDAOImpl;
import com.appspot.Accent.model.service.StellingOfyDAOImpl;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class OverzichtServlet extends HttpServlet{
	//private static final Logger log = Logger.getLogger(OverzichtServlet.class.getName());
	private Objectify ofy;
	
	protected void doGet( HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		
		ofy = ObjectifyService.begin();
		Object o = req.getSession().getAttribute("userobject");//haalt ingelogde gebruiker op
		
		StellingOfyDAOImpl sod = new StellingOfyDAOImpl();
		StellingBeoordeeldOfyDAOImpl sbd = new StellingBeoordeeldOfyDAOImpl();
		StageOfyDAOImpl std = new StageOfyDAOImpl();
		BeoordelingOfyDAOImpl bo = new BeoordelingOfyDAOImpl();
		
	
		//log.info((String) getServletContext().getAttribute("geselecteerd"));
		ArrayList<Stage>stages = new ArrayList<Stage>();
		stages = (ArrayList<Stage>) std.getAllStages();
		ArrayList<Stelling> stellingen = new ArrayList<Stelling>();
		stellingen = (ArrayList<Stelling>) sod.getAllStellingen();
		ArrayList<StellingBeoordeeld> stellingenbeoordeeld = new ArrayList<StellingBeoordeeld>();
		stellingenbeoordeeld = (ArrayList<StellingBeoordeeld>) sbd.getAllStellingenBeoordeeld();//alle stages, stellingbeoordeeld en stellingen worden opgehaald en in arraylists gezet
		ArrayList<Beoordeling> allebeoordelingen = new ArrayList<Beoordeling>();
		allebeoordelingen = (ArrayList<Beoordeling>) bo.getAllBeoordelingen();
		
		boolean succes = false;
		String bericht = "";//dropdown worden gemaakt
		
		if(req.getParameter("geselecteerde") != null){
			
			
	
			
			
		for(Stage st : stages){//doorloopt alle stages
			
			if(o instanceof Leerling ){//is ingelogde gebruiker een leerling?
			
				if (st.getDeLeerling().equals(req.getParameter("geselecteerde"))){//zoekt stage dmv naam ingelogde te vergelijken met stage.getLeerling()
			
					
					
					   
						
						for(Beoordeling b : bo.getBeoordelingen(st.getId())){//alle beoordelingen worden doorlopen
						
							bericht = bericht + "<option value="+b.getDatumLeerling()+">"+b.getDatumLeerling()+"</option>";
						//	log.info(bericht);//de options worden aan de select van de dropdown toegevoegd
				
							
						}
						
						succes = true;
						
						req.setAttribute("msgs2", bericht);
					}
					else{
						req.setAttribute("msgs2", "Er zijn nog geen beoordelingen gedaan");
					}
				}
			
			else{
				req.setAttribute("msgs2", "U bent niet ingelogd als leerling");
			}
			
			}
		
		
	
			
			String datum = req.getParameter("select");
			getServletContext().setAttribute("datum", datum);
			
			succes = true;
		}
		else {
			getServletContext().setAttribute("datum", "null");
			
		}
		RequestDispatcher rd = req.getRequestDispatcher("grafieken.jsp");
		
		
	
	
		 
			
		
		
		
	
		rd.forward(req, resp);
	}

}
