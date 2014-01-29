package com.appspot.Accent.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
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

public class StageInzienServlet extends HttpServlet{
	private static final Logger log = Logger.getLogger(OverzichtServlet.class.getName());
	private Objectify ofy;
	private String bericht;
	protected void doGet( HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		// niet af
		ofy = ObjectifyService.begin();
		
		StageOfyDAOImpl std = new StageOfyDAOImpl();
		ArrayList<Stage>stages = new ArrayList<Stage>();
		
		boolean succes = false;
		
	
		Object o = req.getSession().getAttribute("userobject");//haalt ingelogde gebruiker op
		String leerling = req.getParameter("selection");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		  resp.setContentType("text/html");

		  String out = req.getParameter("string");
		  
		 
			Stage inzage = null ;
			
      	if(out != null){
	
      		for(Stage s :stages){
      			if(s.getDeLeerling()==out){
      				inzage = s;
      				succes=true;
      				break;
      			}
      		}
      		
      	}
      		String msg = "out.println('Leerling naam: '+inzage.getDeLeerling()+',<br/>\n Stagebedrijf: '+inzage.getHetBedrijf()+' <br/>\n Begin datum: '+simpleDateFormat.format(inzage.getBegindatum())+'<br/>\n Eind datum: '+simpleDateFormat.format(inzage.getEinddatum())+'<br/>\n')";
	

	
		
		 
	    

	
	RequestDispatcher rd = null;
	
//	getServletContext().setAttribute("Stage", stage);
	
	
	if(succes){
		req.setAttribute("msg", msg);
		rd = req.getRequestDispatcher("StageInzien.jsp");
		log.info("1");
	}
	else{
		req.setAttribute("msgs", "De stages is niet beschikbaar.");
		rd = req.getRequestDispatcher("StageOverzicht.jsp");
		log.info("2");
	}
	
	
	rd.forward(req, resp);
		
	}
}


