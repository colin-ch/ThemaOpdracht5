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

public class CompetentieAanpassenServlet extends HttpServlet {

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
		StellingOfyDAOImpl sod = new StellingOfyDAOImpl();
		ArrayList < Stelling > stellingen = (ArrayList <Stelling> ) sod.getAllStellingen();
		String samenwerkenEnOverleggen = "1";
		String aandachtEnBegripTonen = "2";
		
		for(Stelling s: stellingen){
			System.out.println(req.getParameter(""+s.getUniekID()));
			if(req.getParameter(""+s.getUniekID())!= null){
			s.setDeStelling(req.getParameter("" + s.getUniekID()));
			ofy.put(s);
			String msgs = "Opslaan Gelukt!";
			req.setAttribute("msgs", msgs);
			}else{String msgs = "Opslaan mislukt";
			req.setAttribute("msgs", msgs);}
		}
		
		rd = req.getRequestDispatcher("CompetentieSelecteren.jsp");
		rd.forward(req, resp);
	}
	//De leerling past zich aan de groep aan

	
}
