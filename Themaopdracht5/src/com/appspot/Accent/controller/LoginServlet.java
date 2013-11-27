package com.appspot.Accent.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appspot.Accent.model.Docent;
import com.appspot.Accent.model.Leerling;
import com.appspot.Accent.model.StageBedrijf;
import com.appspot.Accent.model.StageBegeleider;
import com.appspot.Accent.model.User;
import com.appspot.Accent.model.service.DocentOfyDAOImpl;
import com.appspot.Accent.model.service.LeerlingOfyDAOImpl;
import com.appspot.Accent.model.service.StageBedrijfOfyDAOImpl;
import com.appspot.Accent.model.service.StageBegeleiderOfyDAOImpl;


@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	
	@SuppressWarnings("unchecked")
	protected void doPost( HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		
		boolean loginsucces = false;
		String username = req.getParameter("username");
		String pass = req.getParameter("password");
		Object user = null;
		
		//ArrayList<User> allUsers = new ArrayList<User>();
		//allUsers = (ArrayList<User>) getServletContext().getAttribute("users");
		LeerlingOfyDAOImpl l = new LeerlingOfyDAOImpl();
		DocentOfyDAOImpl d = new DocentOfyDAOImpl();
		StageBedrijfOfyDAOImpl sb = new StageBedrijfOfyDAOImpl();
		StageBegeleiderOfyDAOImpl sbg = new StageBegeleiderOfyDAOImpl();
		// er wrodt gekeken pof de gegevens overeenkomt met een van de users er is verschil in type users, namelijk leerlingen en docenten etc.
		
		// er wordt gecontroleerd of het een leerling is 
		for(Leerling le : l.getAllLeerlingen()){
			if(username.equals(le.getUsername()) && pass.equals(le.getPassword())){
				loginsucces = true;
				System.out.println("Is een leerling");
				user = le;
			}
			else{
				System.out.println("Is geen leerling");
			}
		}
		// er wordt gecontroleerd of het een docent is 

		for(Docent de : d.getAllDocenten()){
			if(username.equals(de.getUsername()) && pass.equals(de.getPassword()) && loginsucces == false){
				loginsucces = true;
				System.out.println("Is een docent");
				user = de;
			}
			else{
				System.out.println("Is geen docent");
			}
		}
		// er wordt gecontroleerd of het een stagebedrijf/opleider is 

		for(StageBedrijf sbe : sb.getAllStageBedrijven()){
			if(username.equals(sbe.getUsername()) && pass.equals(sbe.getPassword()) && loginsucces == false){
				loginsucces = true;
				System.out.println("Is een stagebedrijf");
				user = sbe;
			}
			else{
				System.out.println("Is geen stagebedrijf");
			}
		}
		// er wordt gecontroleerd of het een begeleider is 

		for(StageBegeleider sbge : sbg.getAllBegeleiders()){
			if(username.equals(sbge.getUsername()) && pass.equals(sbge.getPassword()) && loginsucces == false){
				loginsucces = true;
				System.out.println("Is een stagebegeleider");
				user = sbge;
			}
			else{
				System.out.println("Is geen stagebegeleider");
			}
		}
		// als er een gebruiker is stuurt ie de pagina door
		RequestDispatcher rd = null;
		if (loginsucces) {
			req.getSession().setAttribute("userobject", user);
			rd = req.getRequestDispatcher("index.jsp");
			System.out.println(user);
		}
		else {
			rd = req.getRequestDispatcher("login.jsp");
			PrintWriter out = resp.getWriter();  
			resp.setContentType("text/html");  
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('deadbeef');");  
			out.println("</script>");
		}
		rd.forward(req, resp);
	}

	}