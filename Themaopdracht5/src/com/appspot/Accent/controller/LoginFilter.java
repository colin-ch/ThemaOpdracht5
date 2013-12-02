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


public class LoginFilter implements Filter {
	public void init(FilterConfig arg0) throws ServletException {
	}
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest r2 = (HttpServletRequest) req;
		Object o = r2.getSession().getAttribute("userobject");
		
		String schermX = "http://project-omega.appspot.com/#";
		String schermY = "http://project-omega.appspot.com/#";


		if (o == null) {
			req.setAttribute("msgs", "U moet ingelogd zijn om deze site te gebruiken");
			r2.getRequestDispatcher("/login.jsp").forward(req, resp);
		} else {
			String reqUrl =	r2.getRequestURL().toString();
			
			if(o instanceof Leerling){
				if(reqUrl.equals(schermX)||reqUrl.equals(schermY)){
					req.setAttribute("msgs", "U bent niet bevoegd dit gedeelte van de site te betreden");
					r2.getRequestDispatcher("/index.jsp").forward(req, resp);
					
				}
				
				
			}
			
			if(o instanceof Docent){
				if(reqUrl.equals(schermX)||reqUrl.equals(schermY)){
					req.setAttribute("msgs", "U bent niet bevoegd dit gedeelte van de site te betreden");
					r2.getRequestDispatcher("/index.jsp").forward(req, resp);
					
				}
				
				
			}
			if(o instanceof StageBedrijf){
				if(reqUrl.equals(schermX)||reqUrl.equals(schermY)){
					req.setAttribute("msgs", "U bent niet bevoegd dit gedeelte van de site te betreden");
					r2.getRequestDispatcher("/index.jsp").forward(req, resp);
					
				}
				
				
			}
			if(o instanceof StageBegeleider){
				if(reqUrl.equals(schermX)|| reqUrl.equals(schermY)){
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
