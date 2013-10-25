package com.appspot.Accent.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appspot.Accent.model.User;

public class RegisterServlet extends HttpServlet {
	
	protected void doPost( HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		
		boolean succes = false;
		
		String username = req.getParameter("username");
		String pass = req.getParameter("password1");
		String email = req.getParameter("email1");
		
		ArrayList<User> allUsers = new ArrayList<User>();
		allUsers = (ArrayList<User>) getServletContext().getAttribute("users");
		
		if(username != null && pass != null && email != null){
			succes = true;
			req.setAttribute("msgs", "Succes!");
			User u = new User(username, pass, email);
			allUsers.add(u);
			getServletContext().setAttribute("users", allUsers);
		}
		
		
		RequestDispatcher rd = null;
		if(succes){
			req.setAttribute("msgs", "Succes");
			rd = req.getRequestDispatcher("login.jsp");
		}
		else{
			rd = req.getRequestDispatcher("register.jsp");
		}
		rd.forward(req, resp);
	}
}
