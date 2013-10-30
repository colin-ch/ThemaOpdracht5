package com.appspot.Accent.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appspot.Accent.model.Beoordeling;
import com.appspot.Accent.model.Leerling;
import com.appspot.Accent.model.School;
import com.appspot.Accent.model.Stage;

public class OverzichtServlet extends HttpServlet{
	protected void doGet( HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		
		Leerling l = (Leerling) req.getSession().getAttribute("userobject");
		ArrayList<Stage>stages = new ArrayList<Stage>();
		School s = new School("Accent", "Nijkerk", "Nijkerk", "0000AS");
		stages = s.getStages();
		boolean succes = false;
		
		for(Stage st : stages){
			if(st.getDeLeerling().equals(l)){
				ArrayList<Beoordeling>beoordelingen = new ArrayList<Beoordeling>();
				beoordelingen = st.getBeoordelingen();
				if(beoordelingen != null){
					String bericht = null;
					for(Beoordeling b : beoordelingen){
						bericht = bericht + b;
						req.setAttribute("msgs", bericht);
					}
					succes = true;
				}
				else{
					req.setAttribute("msgs", "Er zijn nog geen beoordelingen gedaan");
				}
			}
			else{
				req.setAttribute("msgs", "Er is nog geen stage bekend");
			}
		}
		RequestDispatcher rd = null;
		if(succes){
			rd = req.getRequestDispatcher("overzicht.jsp");
		}
		else{
			req.setAttribute("msgs", "Er zijn nog geen beoordelingen gedaan");
		}
		rd.forward(req, resp);
	}

}
