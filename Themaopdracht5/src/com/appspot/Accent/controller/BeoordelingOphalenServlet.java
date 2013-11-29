package com.appspot.Accent.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BeoordelingOphalenServlet extends HttpServlet{
 
private static final Logger log = Logger.getLogger(OverzichtServlet.class.getName());
	
	protected void doGet( HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		// IS NOG ONDER CONSTRUCTIE
		
		String geselecteerd = req.getParameter("radio");
		getServletContext().setAttribute("geselecteerd", geselecteerd);
		
		RequestDispatcher rd = null;
		rd = req.getRequestDispatcher("beoordelingSelecteren.jsp");
		rd.forward(req, resp);
	
		
	}
	
}
