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

import com.appspot.Accent.model.service.StageOfyDAOImpl;

public class StageAanmakenServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = null;
		
		int id = Integer.parseInt(req.getParameter("id"));
		String leerling = req.getParameter("leerlingen");
		String begeleider = req.getParameter("begeleiders");
		String opleider = req.getParameter("opleider");
		String bedrijf = req.getParameter("bedrijf");
		Date begin = null;
		try {
			begin = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).parse(req.getParameter("begin"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date einde = null;
		try {
			einde = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).parse(req.getParameter("einde"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		StageOfyDAOImpl sop = new StageOfyDAOImpl();
		sop.createStage(id, leerling, begeleider, opleider, bedrijf, begin, einde);
		req.setAttribute("msgs", "Er is een stage aangemaakt");
		rd = req.getRequestDispatcher("index.jsp");
		rd.forward(req, resp);
	}

}
