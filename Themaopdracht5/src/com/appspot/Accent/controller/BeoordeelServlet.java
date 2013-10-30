package com.appspot.Accent.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appspot.Accent.model.Leerling;
import com.appspot.Accent.model.Stage;

public class BeoordeelServlet extends HttpServlet{
	protected void doPost( HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		RequestDispatcher rd = null;
		Leerling userobject = (Leerling) req.getSession().getAttribute("userobject");
		
		ArrayList<Stage> allStages = (ArrayList<Stage>) getServletContext().getAttribute("stages");
		
		for(Stage s : allStages){
			if(s.getDeLeerling().getUsername().equals(userobject.getUsername())){
				rd = req.getRequestDispatcher("www.google.com");

			}
			
		}
		rd.forward(req, resp);
		
	}

}
