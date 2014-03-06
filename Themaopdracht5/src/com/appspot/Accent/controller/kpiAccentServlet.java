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

public class kpiAccentServlet extends HttpServlet{
	//private static final Logger log = Logger.getLogger(OverzichtServlet.class.getName());
	private Objectify ofy;
	
	protected void doGet( HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{

		String bericht = req.getParameter("select");
		
		System.out.println(bericht);

		
		req.setAttribute("competentie", bericht);
		RequestDispatcher rd = req.getRequestDispatcher("kpiAccent.jsp");
	
		rd.forward(req, resp);
	}

}
