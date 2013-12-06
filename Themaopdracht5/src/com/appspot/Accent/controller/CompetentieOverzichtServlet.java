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
import com.appspot.Accent.model.service.CompetentieOfyDAOImpl;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class CompetentieOverzichtServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Objectify ofy;
	private static final Logger log = Logger.getLogger(BeoordelingAanmakenServlet.class.getName());
	RequestDispatcher rd = null;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		ArrayList<Competentie> competenties = new ArrayList<Competentie>();
		ofy = ObjectifyService.begin();
		CompetentieOfyDAOImpl cod = new CompetentieOfyDAOImpl();
		competenties = (ArrayList<Competentie>) cod.getAllCompetenties();
		String samenwerkenEnOverleggen = "1";
		String aandachtEnBegripTonen = "2";
		
		System.out.println(req.getParameter("competentie"));
		if (req.getParameter("competentie").equals(samenwerkenEnOverleggen)) {
			String msgs = "Samenwerken en overleggen";
			req.setAttribute("msgs", msgs);
			rd = req.getRequestDispatcher("CompetentieOverzicht.jsp");
		}
		if (req.getParameter("competentie").equals(aandachtEnBegripTonen)) {
			String msgs = "Aandacht en begrip tonen";
			req.setAttribute("msgs", msgs);
			rd = req.getRequestDispatcher("CompetentieOverzicht.jsp");
		}
	
		rd.forward(req, resp);
	}


	
}
