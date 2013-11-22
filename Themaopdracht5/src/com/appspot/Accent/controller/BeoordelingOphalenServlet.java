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
import com.appspot.Accent.model.service.BeoordelingOfyDAOImpl;

public class BeoordelingOphalenServlet extends HttpServlet{
 
private static final Logger log = Logger.getLogger(OverzichtServlet.class.getName());
	
	protected void doGet( HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		String geselecteerd = req.getParameter("radio");
		//if (req.getParameter("overzicht") == null){
			
		resp.setContentType("text/html");
	    PrintWriter out = resp.getWriter();
	    out.println("<form action='BeoordelingOphalenServlet.do' method='GET' >");
	    out.println("<select>");
	    
		BeoordelingOfyDAOImpl b = new BeoordelingOfyDAOImpl();
		
		for(Beoordeling be : b.getAllBeoordelingen()){
			//if(geselecteerd.equals("")){ //null moet leerling naam in beoordeling worden
				out.println("<option value='"+ be.getDatum() +"'>" + be.getDatum() + "</option");			
			//}
		}
		out.println("</select>");
		out.println("<br/><input type='submit' value='overzicht'>");
		out.println("</form>");
		//}
		
		if (req.getParameter("overzicht") != null){
		//meegeven welke beoordeling grafieken.jsp moet laten zien
		
		RequestDispatcher rd = null;
		rd = req.getRequestDispatcher("grafieken.jsp");
		rd.forward(req, resp);
		}
		
	}
	
}
