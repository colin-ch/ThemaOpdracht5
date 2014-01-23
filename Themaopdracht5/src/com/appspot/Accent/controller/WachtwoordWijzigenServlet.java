package com.appspot.Accent.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.Objectify;

public class WachtwoordWijzigenServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(BeoordeelServlet.class.getName());
	private Objectify ofy;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		String geselecteerde = null;
		if(req.getParameter("hidden") != null){
			
			if(!req.getParameter("leerling").equals("")){
				geselecteerde = req.getParameter("leerling");
				
			}
			else if(!req.getParameter("docent").equals("")){
				geselecteerde = req.getParameter("docent");
				
			}
			else if(!req.getParameter("sb").equals("")){
				geselecteerde = req.getParameter("sb");
				
			}
			else if(!req.getParameter("opleider").equals("")){
				geselecteerde = req.getParameter("opleider");
				
			}
			req.setAttribute("selected", geselecteerde);
			log.info(geselecteerde);
			//rd = req.getRequestDispatcher("WachtwoordWijzigen.jsp");
		}
		
		rd = req.getRequestDispatcher("WachtwoordWijzigen.jsp");
		rd.forward(req, resp);
	}

}
