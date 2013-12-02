package com.appspot.Accent.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class GebruikerAanmakenServlet extends HttpServlet {
	private Objectify ofy;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		ofy = ObjectifyService.begin();
		
		if(req.getParameter("leerling") != null){
			String inlog = req.getParameter("username");
			String wachtwoord = req.getParameter("wachtwoord");
			String email = req.getParameter("email");
			String klas = req.getParameter("klas");
			String begeleiders = req.getParameter("begeleiders");
			String inlog = req.getParameter("username");
			String inlog = req.getParameter("username");
			
			rd = req.getRequestDispatcher("index.jsp");
		}
		
		
		rd.forward(req, resp);
	}

}
