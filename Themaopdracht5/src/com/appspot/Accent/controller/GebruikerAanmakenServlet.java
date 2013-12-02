package com.appspot.Accent.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appspot.Accent.model.service.LeerlingOfyDAOImpl;
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
			String gebdat = req.getParameter("gebdat");
			Date gebDate = new Date();
			try {
				gebDate = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).parse(gebdat);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			String roep = req.getParameter("roepnaam");
			String achter = req.getParameter("achternaam");
			LeerlingOfyDAOImpl lop = new LeerlingOfyDAOImpl();
			lop.createLeerling(inlog, wachtwoord, email, roep, achter, gebDate, klas, begeleiders);
			req.setAttribute("msgs", "Er is een leerling aangemaakt");
			rd = req.getRequestDispatcher("index.jsp");
		}
		
		
		else{
			rd = req.getRequestDispatcher("login.jsp");
		}
		
		
		rd.forward(req, resp);
	}

}
