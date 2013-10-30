package com.appspot.Accent.controller;

import java.io.IOException;
import java.util.ArrayList;

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
		
		for(Stage st : stages){
			if(st.getDeLeerling().equals(l)){
				ArrayList<Beoordeling>beoordelingen = new ArrayList<Beoordeling>();
				beoordelingen = st.getBeoordelingen();
				if(beoordelingen != null){
					for(Beoordeling b : beoordelingen){
						System.out.println(b);
					}
				}
				else{
					System.out.println("Er zijn nog geen beoordelingen gedaan");
				}
			}
			else{
				System.out.println("Er is nog geen stage bekend");
			}
		}
		
	}

}
