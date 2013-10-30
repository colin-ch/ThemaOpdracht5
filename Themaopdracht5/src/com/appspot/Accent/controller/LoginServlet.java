package com.appspot.Accent.controller;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.concurrent.Executor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appspot.Accent.model.User;


@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	
	@SuppressWarnings("unchecked")
	protected void doPost( HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		
		boolean loginsucces = false;
		String username = req.getParameter("username");
		String pass = req.getParameter("password");
		User user = null;
		String naam = null;
		String ww = null;
		String em = null;
		
		ArrayList<User> allUsers = new ArrayList<User>();
		allUsers = (ArrayList<User>) getServletContext().getAttribute("users");
		
		for(User u : allUsers){
			if(username.equals(u.getUsername()) && pass.equals(u.getPassword())){
				naam = u.getUsername();
				ww = u.getPassword();
				em = u.getEmail();
				loginsucces = true;
				user = u;
			}
		}
		
		RequestDispatcher rd = null;
		if (loginsucces) {
			req.getSession().setAttribute("userobject", user);
			rd = req.getRequestDispatcher("MainPage.jsp");
			req.setAttribute("msgs", "Succesvol Ingelogd <br/><label>Uw gegevens:</label><br/> Username: " + naam + "<br/>Wachtwoord: " + ww + "<br/>email: "+ em);
		
		}
		else {
			rd = req.getRequestDispatcher("login.jsp");
			req.setAttribute("msgs", "Foute login");
		}
		rd.forward(req, resp);
	}

	}