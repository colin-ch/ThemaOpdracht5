package com.appspot.Accent.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.appspot.Accent.model.Docent;
import com.appspot.Accent.model.Leerling;
import com.appspot.Accent.model.StageBedrijf;
import com.appspot.Accent.model.StageBegeleider;


public class LoginFilterServlet implements Filter {
	public void init(FilterConfig arg0) throws ServletException {
	}
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest r2 = (HttpServletRequest) req;
		Object o = r2.getSession().getAttribute("userobject");
		
		String beheer = "http://project-omega.appspot.com/Beheerder.jsp";
		String beoordelenleerling = "http://project-omega.appspot.com/BeoordelenLeerling.jsp";
		String beoordelenopleider = "http://project-omega.appspot.com/beoordelenOpleider.jsp";
		String aanmakenbeoordeling = "http://project-omega.appspot.com/BeoordelingAanmaken.jsp";
		String selecterenbeoordeling = "http://project-omega.appspot.com/beoordelingSelecteren.jsp";
		String competentieoverzicht = "http://project-omega.appspot.com/CompetentieOverzicht.jsp";
		String selecterencompetentie = "http://project-omega.appspot.com/CompetentieSelecteren.jsp";
		String docentaanmaken = "http://project-omega.appspot.com/DocentAanmaken.jsp";
		String grafieken = "http://project-omega.appspot.com/grafieken.jsp";
		String header = "http://project-omega.appspot.com/header.jsp";
		String imports = "http://project-omega.appspot.com/imports.jsp";
		String index = "http://project-omega.appspot.com/index.jsp";
		String leerlingaanmaken = "http://project-omega.appspot.com/LeerlingAanmaken.jsp";
		String overzichtgebruikers = "http://project-omega.appspot.com/overzichtgebruikers.jsp";
		String profiel = "http://project-omega.appspot.com/Profiel.jsp";
		String stageaanmaken = "http://project-omega.appspot.com/StageAanmaken.jsp";
		String stagebedrijfaanmaken = "http://project-omega.appspot.com/StageBedrijfAanmaken.jsp";
		String stagebegeleideraanmaken = "http://project-omega.appspot.com/StageBegeleiderAanmaken.jsp";
		String stageoverzicht = "http://project-omega.appspot.com/StageOverzicht.jsp";
		String wachtwoordwijzigen = "http://project-omega.appspot.com/WachtwoordWijzigen.jsp";
		
		

// er word gekeken of je ingelogt bent of niet.
		if (o == null) {
			req.setAttribute("msgs", "U moet ingelogd zijn om deze site te gebruiken");
			r2.getRequestDispatcher("/login.jsp").forward(req, resp);
		} else {
			String reqUrl =	r2.getRequestURL().toString();
			// er wordt gekeken  welke gerbuiker het is en of deze wel op de betreffende pagina mag.
			if(o instanceof Leerling){
				if(reqUrl.equals("#")||reqUrl.equals("#")){
					req.setAttribute("msgs", "U bent niet bevoegd dit gedeelte van de site te betreden");
					r2.getRequestDispatcher("/index.jsp").forward(req, resp);
					
				}
				
				
			}
			
			if(o instanceof Docent){
				if(reqUrl.equals("#")||reqUrl.equals("#")){
					req.setAttribute("msgs", "U bent niet bevoegd dit gedeelte van de site te betreden");
					r2.getRequestDispatcher("/index.jsp").forward(req, resp);
					
				}
				
				
			}
			if(o instanceof StageBedrijf){
				if(reqUrl.equals("#")||reqUrl.equals("#")){
					req.setAttribute("msgs", "U bent niet bevoegd dit gedeelte van de site te betreden");
					r2.getRequestDispatcher("/index.jsp").forward(req, resp);
					
				}
				
				
			}
			if(o instanceof StageBegeleider){
				if(reqUrl.equals("#")|| reqUrl.equals("#")){
					req.setAttribute("msgs", "U bent niet bevoegd dit gedeelte van de site te betreden");
					r2.getRequestDispatcher("/index.jsp").forward(req, resp);
				}
				
			}
			chain.doFilter(req, resp);
		}
	}
		
	
		
		
		
		
	
	public void destroy() {
	}
}
