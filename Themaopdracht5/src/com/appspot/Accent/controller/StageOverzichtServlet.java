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
import com.appspot.Accent.model.service.StageOfyDAOImpl;
import com.appspot.Accent.model.service.StellingBeoordeeldOfyDAOImpl;
import com.appspot.Accent.model.service.StellingOfyDAOImpl;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class StageOverzichtServlet extends HttpServlet{
	private static final Logger log = Logger.getLogger(OverzichtServlet.class.getName());
	private Objectify ofy;
	private String bericht;
	protected void doGet( HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		// niet af
		ofy = ObjectifyService.begin();
		
	
	
	StellingOfyDAOImpl sod = new StellingOfyDAOImpl();
	StellingBeoordeeldOfyDAOImpl sbd = new StellingBeoordeeldOfyDAOImpl();
	StageOfyDAOImpl std = new StageOfyDAOImpl();
	
	ArrayList<Stage>stages = new ArrayList<Stage>();
	
	boolean succes = false;
	
	
		Object o = req.getSession().getAttribute("userobject");//haalt ingelogde gebruiker op
		stages = (ArrayList<Stage>) std.getAllStages();
		
		
		/*if(pagina wordt geladen){
			for(Stage st : stages){//doorloopt alle stages
			log.info("1");
			//Haalt alle gegevens op per stage en schrijft deze terug naar de pagina.
			bericht = bericht+ "['"+st.getDeLeerling()+"',  "+st.getHetBedrijf()+", "+st.getDeBegeleider()+", "+st.getBegindatum()+", "+st.getEinddatum()+"],";
			log.info(bericht);
			}
		succes = true;
		req.setAttribute("msgs", bericht);
		}
		else{
			req.setAttribute("msgs", "Er is nog geen stage bekend");
		}
		*/
	
	RequestDispatcher rd = null;
	
	getServletContext().setAttribute("Stages", stages);
	System.out.println(stages);
	
	if(succes){
		req.setAttribute("msgs", bericht);
		rd = req.getRequestDispatcher("StageOverzicht.jsp");
		log.info("3");
	}
	else{
		req.setAttribute("msgs", "Er zijn geen stages beschikbaar.");
		rd = req.getRequestDispatcher("StageOverzicht.jsp");
		log.info("4");
	}
	
	
	rd.forward(req, resp);
		
	}
}


