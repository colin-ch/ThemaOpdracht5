package com.appspot.Accent.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appspot.Accent.model.Docent;
import com.appspot.Accent.model.Leerling;
import com.appspot.Accent.model.StageBedrijf;
import com.appspot.Accent.model.StageBegeleider;
import com.appspot.Accent.model.service.DocentOfyDAOImpl;
import com.appspot.Accent.model.service.LeerlingOfyDAOImpl;
import com.appspot.Accent.model.service.StageBedrijfOfyDAOImpl;
import com.appspot.Accent.model.service.StageBegeleiderOfyDAOImpl;
import com.googlecode.objectify.Objectify;

public class WachtwoordWijzigenServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(BeoordeelServlet.class.getName());
	private Objectify ofy;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		String geselecteerde = null;
		
		LeerlingOfyDAOImpl l = new LeerlingOfyDAOImpl();
		DocentOfyDAOImpl d = new DocentOfyDAOImpl();
		StageBedrijfOfyDAOImpl sb = new StageBedrijfOfyDAOImpl();
		StageBegeleiderOfyDAOImpl sbg = new StageBegeleiderOfyDAOImpl();
		
		
		String s = req.getParameter("hidden");
		if(s.equals("1")){
			
			if(!req.getParameter("leerling").equals("")){
				geselecteerde = req.getParameter("leerling");
				
			}
			else if(!req.getParameter("docent").equals("")){
				geselecteerde = req.getParameter("docent");
				
			}
			else if(!req.getParameter("sb").equals("")){
				geselecteerde = req.getParameter("sb");
				
			}
			else if(!req.getParameter("bedrijf").equals("")){
				geselecteerde = req.getParameter("bedrijf");
				
			}
			req.setAttribute("selected", geselecteerde);
			log.info(geselecteerde);
			rd = req.getRequestDispatcher("WachtwoordWijzigen.jsp");
		}
		if(s.equals("2")){
			String gebruiker = req.getParameter("radio");
			boolean gevonden = false;
			Object o = null;
			
			ArrayList<Leerling>leerlingen = (ArrayList<Leerling>) l.getAllLeerlingen();
			ArrayList<Docent>docenten = (ArrayList<Docent>) d.getAllDocenten();
			ArrayList<StageBedrijf>bedrijven = (ArrayList<StageBedrijf>) sb.getAllStageBedrijven();
			ArrayList<StageBegeleider> begeleiders = (ArrayList<StageBegeleider>) sbg.getAllBegeleiders();
			
			loop:
			for(Leerling le : leerlingen){
				if(le.getUsername().equals(gebruiker)){
					gevonden = true;
					o = le;
					break loop;
					
				}
			}
			if(gevonden == false){
				for(Docent de : docenten){
					if(de.getUsername().equals("gebruiker")){
						gevonden = true;
					}
				}
			}
			if(gevonden == false){
				for(StageBedrijf de : bedrijven){
					if(de.getUsername().equals("gebruiker")){
						gevonden = true;
					}
				}
			}
			if(gevonden == false){
				for(StageBegeleider de : begeleiders){
					if(de.getUsername().equals("gebruiker")){
						gevonden = true;
					}
				}
			}
			
			
			getServletContext().setAttribute("selected", gebruiker);
			rd = req.getRequestDispatcher("WachtwoordWijzigen.jsp");
		}
		if(s.equals("3")){
			String oud = req.getParameter("oud");
			String nieuw = req.getParameter("nieuw");
			String nieuw2 = req.getParameter("nieuw2");
		}

		rd.forward(req, resp);
	}

}
