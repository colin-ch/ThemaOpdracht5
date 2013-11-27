package com.appspot.Accent.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appspot.Accent.model.Beoordeling;
import com.appspot.Accent.model.Stage;
import com.appspot.Accent.model.service.BeoordelingOfyDAOImpl;
import com.appspot.Accent.model.service.StageOfyDAOImpl;

public class BeoordelingOphalenServlet extends HttpServlet{
 
private static final Logger log = Logger.getLogger(OverzichtServlet.class.getName());
	
	protected void doGet( HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		// IS NOG ONDER CONSTRUCTIE
		
		String geselecteerd = req.getParameter("radio");
			
		resp.setContentType("text/html");
	    PrintWriter out = resp.getWriter();
	    out.println("<form action='BeoordelingOphalenServlet.do' method='GET' >");
	    out.println("<select>");
	    
		BeoordelingOfyDAOImpl b = new BeoordelingOfyDAOImpl();
		StageOfyDAOImpl s = new StageOfyDAOImpl();
		for(Stage st : s.getAllStages()){
			if(st.getDeLeerling().equals(geselecteerd)){
				for(Beoordeling be : st.getBeoordelingen()){
					out.println("<option value='"+ be.getDatum() +"'>" + be.getDatum() + "</option");
				}
			}
		}
					
		out.println("</select>");
		out.println("<br/><input type='submit' value='overzicht'>");
		out.println("</form>");
		//}
		
		
		RequestDispatcher rd = null;
		rd = req.getRequestDispatcher("beoordelingSelecteren.jsp");
		rd.forward(req, resp);
	
		
	}
	
}
