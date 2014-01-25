package com.appspot.Accent.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appspot.Accent.model.Competentie;
import com.appspot.Accent.model.Stelling;
import com.appspot.Accent.model.service.CompetentieOfyDAOImpl;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class CompetentieAanpassenServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Objectify ofy;
	private static final Logger log = Logger.getLogger(BeoordelingAanmakenServlet.class.getName());
	RequestDispatcher rd = null;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		ofy = ObjectifyService.begin();
		ObjectifyService.register(Stelling.class);
		ObjectifyService.register(Competentie.class);
		CompetentieOfyDAOImpl cod = new CompetentieOfyDAOImpl();
		for (Competentie c : cod.getAllCompetenties()) {
			if (req.getParameter("" + c.getEigenId()) != null) {
				c.setTitel(req.getParameter("" + c.getEigenId()));
				ofy.put(c);
				String msgs = "Opslaan Gelukt!";
				req.setAttribute("msgs", msgs);
			}
		}
		rd = req.getRequestDispatcher("index.jsp");
		rd.forward(req, resp);
	}
}