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
import com.googlecode.objectify.ObjectifyService;

public class WachtwoordWijzigenServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(WachtwoordWijzigenServlet.class.getName());
	private Objectify ofy;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		String geselecteerde = null;
		ofy = ObjectifyService.begin();
		
		LeerlingOfyDAOImpl l = new LeerlingOfyDAOImpl();
		DocentOfyDAOImpl d = new DocentOfyDAOImpl();
		StageBedrijfOfyDAOImpl sb = new StageBedrijfOfyDAOImpl();
		StageBegeleiderOfyDAOImpl sbg = new StageBegeleiderOfyDAOImpl();
		
		
		String s = req.getParameter("hidden");
		String t = req.getParameter("hiddene");
		if(s != null && s.equals("1")){
			
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
		if(s != null && s.equals("2")){
			String gebruiker = req.getParameter("radio");			
			getServletContext().setAttribute("select", gebruiker);
			req.setAttribute("selected", "5");
			rd = req.getRequestDispatcher("WachtwoordWijzigen.jsp");
		}
		if(t != null && t.equals("3")){
			req.setAttribute("selected", "5");
			String oud = req.getParameter("oud");
			String nieuw = req.getParameter("nieuw");
			String nieuw2 = req.getParameter("nieuw2");
			String o = (String) getServletContext().getAttribute("select");
			
			boolean succes = false;	
			
			ArrayList<Leerling>leerlingen = (ArrayList<Leerling>) l.getAllLeerlingen();
			ArrayList<Docent>docenten = (ArrayList<Docent>) d.getAllDocenten();
			ArrayList<StageBedrijf>bedrijven = (ArrayList<StageBedrijf>) sb.getAllStageBedrijven();
			ArrayList<StageBegeleider> begeleiders = (ArrayList<StageBegeleider>) sbg.getAllBegeleiders();
			if(nieuw.equals(nieuw2)){
				loop:
				for(Leerling le : leerlingen){
					if(le.getUsername().equals(o)){
						if(le.getPassword().equals(oud)){
							succes = true;
							Leerling l1 = le;
							l1.setPassword(nieuw);
							ofy.put(l1);
						}
						break loop;	
					}
				}
				if(succes == false){
					loop:
					for(Docent de : docenten){
						if(de.getUsername().equals(o)){
							if(de.getPassword().equals(oud)){
								succes = true;
								Docent doc = de;
								doc.setPassword(nieuw);
								ofy.put(doc);
							}				
							break loop;
						}
					}
				}
				if(succes == false){
					loop:
					for(StageBedrijf de : bedrijven){
						if(de.getUsername().equals(o)){
							if(de.getPassword().equals(oud)){
								succes = true;
								StageBedrijf sbe = de;
								sbe.setPassword(nieuw);
								ofy.put(sbe);
							}
							break loop;
						}
					}
				}
				if(succes == false){
					loop:
					for(StageBegeleider de : begeleiders){
						if(de.getUsername().equals(o)){
							if(de.getPassword().equals(oud)){
								succes = true;
								StageBegeleider stb = de;
								stb.setPassword(nieuw);
								ofy.put(stb);
							}
							break loop;
						}
					}
				}
			}
			if(succes){
				rd = req.getRequestDispatcher("index.jsp");
				req.setAttribute("msgs", "Wachtwoord is gewijzigd");
			}
			else{
				rd = req.getRequestDispatcher("WachtwoordWijzigen.jsp");
				req.setAttribute("msgs", "Oude wachtwoord klopt niet of de nieuwe wachtwoorden komen niet overeen");
			}
		}

		rd.forward(req, resp);
	}

}
