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
import com.appspot.Accent.model.Stelling;
import com.appspot.Accent.model.service.CompetentieOfyDAOImpl;
import com.appspot.Accent.model.service.StellingOfyDAOImpl;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class StellingAanpassenServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Objectify ofy;
	private static final Logger log = Logger.getLogger(BeoordelingAanmakenServlet.class.getName());
	RequestDispatcher rd = null;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		ofy = ObjectifyService.begin();
		StellingOfyDAOImpl sod = new StellingOfyDAOImpl();
		ArrayList < Stelling > stellingen = (ArrayList <Stelling> ) sod.getAllStellingen();
		
		
		for(Stelling s: stellingen){
			if(req.getParameter(""+s.getUniekID())!= null){
			s.setDeStelling(req.getParameter("" + s.getUniekID()));
			ofy.put(s);
			String msgs = "Opslaan Gelukt!";
			req.setAttribute("msgs", msgs);
			}
		}
		
		rd = req.getRequestDispatcher("index.jsp");
		rd.forward(req, resp);
	}


	
}
