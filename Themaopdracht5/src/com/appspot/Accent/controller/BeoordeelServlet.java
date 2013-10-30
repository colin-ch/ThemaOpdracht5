package com.appspot.Accent.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hamcrest.core.IsInstanceOf;

import com.appspot.Accent.model.Leerling;
import com.appspot.Accent.model.Stage;
import com.appspot.Accent.model.User;

public class BeoordeelServlet extends HttpServlet{
	protected void doGet( HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		RequestDispatcher rd = null;
		User o = (User) req.getSession().getAttribute("userobject");
		
		
		ArrayList<Stage> allStages = (ArrayList<Stage>) getServletContext().getAttribute("stages");
		
		

		
		for(Stage s : allStages){
			req.setAttribute("msgs",  o.getUsername());
			rd = req.getRequestDispatcher("MainPage.jsp");
//			if(s.getDeLeerling().getUsername() != null && leerlingObject.getUsername() != null){
//			if(s.getDeLeerling().getUsername().equals(leerlingObject.getUsername())){
//				rd = req.getRequestDispatcher("MainPage.jsp");
//			}
//			}
			

			
		}
		rd.forward(req, resp);
		
	}

}
