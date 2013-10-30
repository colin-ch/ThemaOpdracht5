package com.appspot.Accent.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hamcrest.core.IsInstanceOf;

import com.appspot.Accent.model.Leerling;
import com.appspot.Accent.model.Stage;
import com.appspot.Accent.model.User;

public class BeoordeelServlet extends HttpServlet{
	protected void doGet( HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		RequestDispatcher rd = null;
		User userobject = (User) req.getSession().getAttribute("userobject");
		Leerling leerlingObject = null;
		
		ArrayList<Stage> allStages = (ArrayList<Stage>) getServletContext().getAttribute("stages");
		
		
		if(userobject instanceof Leerling){
			leerlingObject = (Leerling) userobject;
		}
		
		for(Stage s : allStages){
			
			if(s.getDeLeerling().getUsername().equals(leerlingObject.getUsername())){
				rd = req.getRequestDispatcher("www.google.com");

			}
			
		}
		rd.forward(req, resp);
		
	}

}
