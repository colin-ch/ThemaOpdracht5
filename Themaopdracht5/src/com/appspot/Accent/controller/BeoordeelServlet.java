package com.appspot.Accent.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appspot.Accent.model.Competentie;
import com.appspot.Accent.model.Leerling;
import com.appspot.Accent.model.Stage;
import com.appspot.Accent.model.Stelling;

public class BeoordeelServlet extends HttpServlet{
	private static final Logger log = Logger.getLogger(BeoordeelServlet.class.getName());

	protected void doGet( HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		RequestDispatcher rd = null;
		Object o = req.getSession().getAttribute("userobject");
		
		ArrayList<Stage> allStages = (ArrayList<Stage>) getServletContext().getAttribute("stages");
		
		

		
		for(Stage s : allStages){
			
			if(o instanceof Leerling ){
				if (s.getDeLeerling().getUsername().equals( ((Leerling) o).getUsername())){
//					ArrayList<Beoordeling> allBeoordelingen = s.getBeoordelingen();
					
					// Te aant e passen na de core
					Competentie nr1 = new Competentie("1. Samenwerken en overleggen");
					Competentie nr2 = new Competentie("2. Aandacht en begrip tonen");
					
				Stelling stelling1 = new Stelling( "de leerling gedraagt zich zo dat samenwerking makkelijk gaat", null);
				Stelling stelling2 = new Stelling("De leerling past zich aan de groep aan", null);
				Stelling stelling3 = new Stelling("De leerling houdt zich aan de regels van het bedrijf", null);
				Stelling stelling4 = new Stelling("de leerling luister naar een ander", null);
				Stelling stelling5 = new Stelling("de leerling laat de ander uitpraten", null);

				
				nr1.getDeStellingen().add(stelling1);
				nr1.getDeStellingen().add(stelling2);
				nr1.getDeStellingen().add(stelling3);
				nr2.getDeStellingen().add(stelling4);
				nr2.getDeStellingen().add(stelling5);
					
				ArrayList<Competentie> competenties = new ArrayList<Competentie>();
				competenties.add(nr1);
				competenties.add(nr2);
				req.setAttribute("competenties", competenties);
					
					
				}
			}
			rd = req.getRequestDispatcher("BeoordelenLeerling.jsp");


			
		}
		rd.forward(req, resp);
		
	}

}
