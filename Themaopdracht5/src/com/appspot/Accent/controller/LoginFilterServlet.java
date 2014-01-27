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
		
		String scherm1 = "http://project-omega.appspot.com/Beheerder.jsp";
		String scherm2 = "http://project-omega.appspot.com/BeoordelenLeerling.jsp";
		String scherm3 = "http://project-omega.appspot.com/beoordelenOpleider.jsp";
		String scherm4 = "http://project-omega.appspot.com/BeoordelingAanmaken.jsp";
		String scherm5 = "http://project-omega.appspot.com/beoordelingSelecteren.jsp";
		String scherm6 = "http://project-omega.appspot.com/CompetentieOverzicht.jsp";
		String scherm7 = "http://project-omega.appspot.com/CompetentieSelecteren.jsp";
		String scherm8 = "http://project-omega.appspot.com/DocentAanmaken.jsp";
		String scherm9 = "http://project-omega.appspot.com/grafieken.jsp";
		String scherm10 = "http://project-omega.appspot.com/header.jsp";
		String scherm11 = "http://project-omega.appspot.com/imports.jsp";
		String scherm12 = "http://project-omega.appspot.com/index.jsp";
		String scherm13 = "http://project-omega.appspot.com/LeerlingAanmaken.jsp";
		String scherm14 = "http://project-omega.appspot.com/overzichtgebruikers.jsp";
		String scherm15 = "http://project-omega.appspot.com/Profiel.jsp";
		String scherm16 = "http://project-omega.appspot.com/StageAanmaken.jsp";
		String scherm17 = "http://project-omega.appspot.com/StageBedrijfAanmaken.jsp";
		String scherm18 = "http://project-omega.appspot.com/StageBegeleiderAanmaken.jsp";
		String scherm19 = "http://project-omega.appspot.com/StageOverzicht.jsp";
		String scherm20 = "http://project-omega.appspot.com/WachtwoordWijzigen.jsp";
		
		

// er word gekeken of je ingelogt bent of niet.
		if (o == null) {
			req.setAttribute("msgs", "U moet ingelogd zijn om deze site te gebruiken");
			r2.getRequestDispatcher("/login.jsp").forward(req, resp);
		} else {
			String reqUrl =	r2.getRequestURL().toString();
			// er wordt gekeken  welke gerbuiker het is en of deze wel op de betreffende pagina mag.
			if(o instanceof Leerling){
				if(reqUrl.equals(scherm1)||reqUrl.equals(scherm2)){
					req.setAttribute("msgs", "U bent niet bevoegd dit gedeelte van de site te betreden");
					r2.getRequestDispatcher("/index.jsp").forward(req, resp);
					
				}
				
				
			}
			
			if(o instanceof Docent){
				if(reqUrl.equals(scherm1)||reqUrl.equals(scherm2)){
					req.setAttribute("msgs", "U bent niet bevoegd dit gedeelte van de site te betreden");
					r2.getRequestDispatcher("/index.jsp").forward(req, resp);
					
				}
				
				
			}
			if(o instanceof StageBedrijf){
				if(reqUrl.equals(scherm1)||reqUrl.equals(scherm2)){
					req.setAttribute("msgs", "U bent niet bevoegd dit gedeelte van de site te betreden");
					r2.getRequestDispatcher("/index.jsp").forward(req, resp);
					
				}
				
				
			}
			if(o instanceof StageBegeleider){
				if(reqUrl.equals(scherm1)|| reqUrl.equals(scherm2)){
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
