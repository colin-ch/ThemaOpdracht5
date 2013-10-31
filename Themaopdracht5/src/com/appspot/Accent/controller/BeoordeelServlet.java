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
	private static final Logger log = Logger.getLogger(BeoordeelServlet.class
			.getName());

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		int waarde1 = Integer.parseInt(req.getParameter("waarde1"));
		int waarde2 = Integer.parseInt(req.getParameter("waarde2"));
		int waarde3 = Integer.parseInt(req.getParameter("waarde3"));
		int waarde4 = Integer.parseInt(req.getParameter("waarde4"));
		int waarde5 = Integer.parseInt(req.getParameter("waarde5"));
		
		RequestDispatcher rd = null;
		Object o = req.getSession().getAttribute("userobject");

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
			rd = req.getRequestDispatcher("BeoordelenLeerling.jsp");

		}
		rd.forward(req, resp);

	}

}
