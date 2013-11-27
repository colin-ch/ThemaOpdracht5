package com.appspot.Accent.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appspot.Accent.model.Leerling;
import com.appspot.Accent.model.Stage;
import com.appspot.Accent.model.StageBedrijf;
import com.appspot.Accent.model.StageBegeleider;
import com.appspot.Accent.model.service.LeerlingOfyDAOImpl;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class BeoodelingAanmakenServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(BeoodelingAanmakenServlet.class.getName());
	private Objectify ofy;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		Stage stage = null;
		StageBedrijf bedr = null;
		Leerling student = null;
		StageBegeleider begeleider = (StageBegeleider) req.getSession().getAttribute("userobject")
				// alles wordt globaal aangremaakt
		// hieronder staat de stuk om een leerling te selecteren
//		if(req.getParameter("initLeerling") != null){
			ArrayList<Leerling> leerlingen = new ArrayList<Leerling>();
			Objectify ofy = ObjectifyService.begin();
			LeerlingOfyDAOImpl lod = new LeerlingOfyDAOImpl();
			leerlingen = (ArrayList < Leerling > ) lod.getAllLeerlingen();
			req.setAttribute("studenten", leerlingen);
			
//		}
			// als er stage is geselcteerd moet onderstaande worcden uitgevoerd
		if(req.getParameter("initStage") != null){
			
			
		}
		// als de beoordeling is aangemaakt is komt dit onderstaande stuk
		if(req.getParameter("create") != null){
			
			
			// TODO: creeer een beoordeling vanuit de gegevens van beoordelingaanmaken.jsp
		}
		
		
		
		
		rd = req.getRequestDispatcher("BeoordelingAanmaken.jsp");
		rd.forward(req, resp);
	}
}



