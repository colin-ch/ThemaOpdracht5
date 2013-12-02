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

import com.appspot.Accent.model.service.DocentOfyDAOImpl;
import com.appspot.Accent.model.service.LeerlingOfyDAOImpl;
import com.appspot.Accent.model.service.StageBedrijfOfyDAOImpl;
import com.appspot.Accent.model.service.StageBegeleiderOfyDAOImpl;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class GebruikerAanmakenServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		
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
		if(req.getParameter("docent") != null){
			String inlog = req.getParameter("username");
			String wachtwoord = req.getParameter("wachtwoord");
			String email = req.getParameter("email");
			DocentOfyDAOImpl dop = new DocentOfyDAOImpl();
			dop.createDocent(inlog, wachtwoord, email);
			req.setAttribute("msgs", "Er is een docent aangemaakt");
			rd = req.getRequestDispatcher("index.jsp");
		}
		if(req.getParameter("stagebegeleider") != null){
			String inlog = req.getParameter("username");
			String wachtwoord = req.getParameter("wachtwoord");
			String email = req.getParameter("email");
			StageBegeleiderOfyDAOImpl sbop = new StageBegeleiderOfyDAOImpl();
			sbop.createBegeleider(inlog, wachtwoord, email);
			req.setAttribute("msgs", "Er is een stagebegeleider aangemaakt");
			rd = req.getRequestDispatcher("index.jsp");
		}
		if(req.getParameter("stagebedrijf") != null){
			String inlog = req.getParameter("username");
			String wachtwoord = req.getParameter("wachtwoord");
			String email = req.getParameter("email");
			String plaats = req.getParameter("plaats");
			String code = req.getParameter("code");
			StageBedrijfOfyDAOImpl stbop = new StageBedrijfOfyDAOImpl();
			stbop.createStageBedrijf(inlog, wachtwoord, email, plaats, code);
			req.setAttribute("msgs", "Er is een stagebegeleider aangemaakt");
			rd = req.getRequestDispatcher("index.jsp");
		}
		
		
		else{
			req.setAttribute("msgs", "<h4 class='alert_succes'>Error</h4>");
			rd = req.getRequestDispatcher("index.jsp");
		}
		
		
		rd.forward(req, resp);
	}

}
