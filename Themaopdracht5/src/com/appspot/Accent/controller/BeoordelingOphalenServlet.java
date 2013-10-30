package com.appspot.Accent.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BeoordelingOphalenServlet extends HttpServlet{
 
private static final Logger log = Logger.getLogger(OverzichtServlet.class.getName());
	
	protected void doGet( HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		String datum = req.getParameter("dropdown");
		Date d = new Date();
		try {
			d = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(datum);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
