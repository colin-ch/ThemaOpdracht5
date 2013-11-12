package com.appspot.Accent.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {
	
	@SuppressWarnings("unchecked")
	protected void doGet( HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		req.getSession().setAttribute("userobject", null);
		req.setAttribute("msgs", null);
		RequestDispatcher rd = null;
		rd = req.getRequestDispatcher("login.jsp");
		rd.forward(req, resp);

	}

}