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
					
				String stelling1 = "de leerling gedraagt zich zo dat samenwerking makkelijk gaat";
				String stelling2 = "De leerling past zich aan de groep aan";
				String stelling3 = "De leerling houdt zich aan de regels van het bedrijf";
				String stelling4 = "de leerling luister naar een ander";
				String stelling5 = "de leerling laat de ander uitpraten";

				
				nr1.getDeStellingen().add(stelling1);
				nr1.getDeStellingen().add(stelling2);
				nr1.getDeStellingen().add(stelling3);
				nr2.getDeStellingen().add(stelling4);
				nr2.getDeStellingen().add(stelling5);
					
				
					
					
					
				}
			}
			rd = req.getRequestDispatcher("MainPage.jsp");


			
		}
		rd.forward(req, resp);
		
	}

}
