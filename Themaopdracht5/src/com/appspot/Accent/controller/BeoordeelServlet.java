package com.appspot.Accent.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appspot.Accent.model.Competentie;
import com.appspot.Accent.model.Leerling;
import com.appspot.Accent.model.Stage;
import com.appspot.Accent.model.Stelling;

public class BeoordeelServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(BeoordeelServlet.class
			.getName());

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		boolean succes = false;
		
		ArrayList<Integer> allWaardes = new ArrayList<Integer>();
		int teller = 0;
		int stellingTeller = Integer.parseInt(req.getParameter("stellingTeller"));
		while(teller != stellingTeller){
			teller++;
			allWaardes.add(Integer.parseInt(req.getParameter("waarde"+teller)));
		
		
	
		
		
		/*Object o = req.getSession().getAttribute("userobject");

		ArrayList<Stage> allStages = (ArrayList<Stage>) getServletContext()
				.getAttribute("stages");

		for (Stage s : allStages) {
			if (o instanceof Leerling) {
				if (s.getDeLeerling().getUsername()
						.equals(((Leerling) o).getUsername())) {
					// ArrayList<Beoordeling> allBeoordelingen =
					// s.getBeoordelingen();

					
				}
			}
			*/
		System.out.println(allWaardes);
		req.setAttribute("msgs", "allWaardes");
		RequestDispatcher rd = null;
		if(allWaardes !=null){
			succes=true;
		}
		if(succes){
			req.setAttribute("msgs", "Succes");
			rd = req.getRequestDispatcher("overzicht.do");
		}
		else{
			rd = req.getRequestDispatcher("BeoordelenLeerling.jsp");
		}
		rd.forward(req, resp);	

		//}
	
	}
	}
}
