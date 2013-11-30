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
import com.appspot.Accent.model.service.StageOfyDAOImpl;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class BeoordelingAanmakenServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(BeoordelingAanmakenServlet.class.getName());
	private Objectify ofy;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		Stage stage = null;
		StageBedrijf bedr = null;
		Leerling student = null;
		ArrayList<Stage> studentStages = new ArrayList<Stage>();

		StageBegeleider begeleider = (StageBegeleider) req.getSession().getAttribute("userobject");
				// alles wordt globaal aangemaakt
		// hieronder staat de stuk om een leerling te selecteren
		if(req.getParameter("initLeerling") != null){
			req.setAttribute("initLeerling", "yolo");

			ArrayList<Leerling> leerlingen = new ArrayList<Leerling>();
			Objectify ofy = ObjectifyService.begin();
			LeerlingOfyDAOImpl lod = new LeerlingOfyDAOImpl();
			leerlingen = (ArrayList < Leerling > ) lod.getAllLeerlingen();
			req.setAttribute("studenten", leerlingen);
			
		}
			// als er stage is geselcteerd moet onderstaande worcden uitgevoerd
		if(req.getParameter("initStage") != null){
			req.setAttribute("initStage", "yolo");
			ArrayList<Stage> stages = new ArrayList<Stage>();
			Objectify ofy = ObjectifyService.begin();
			StageOfyDAOImpl sod = new StageOfyDAOImpl();
			stages = (ArrayList < Stage > ) sod.getAllStages();
			
			String naam = req.getParameter("leerlingen");
			
			ArrayList<Leerling> leerlingen = new ArrayList<Leerling>();
			LeerlingOfyDAOImpl lod = new LeerlingOfyDAOImpl();
			leerlingen = (ArrayList < Leerling > ) lod.getAllLeerlingen();
			for(Leerling f : leerlingen){
				if(naam.equals(f.getRoepnaam() + " " + f.getAchternaam())){
					student = f;
					System.out.println("student gekoppeld");

				}
			}
			
			for(Stage s : stages){
				if(s.getDeLeerling().equals(student.getUsername())){
					studentStages.add(s);
					System.out.println("voeg stage toe");

				}
			}
			
			
			
			req.setAttribute("stages", studentStages);
			
		}
		
		
		
		// als de beoordeling is aangemaakt is komt dit onderstaande stuk
		if(req.getParameter("create") != null){
			req.setAttribute("save", "yolo");
			ArrayList<Stage> stages = new ArrayList<Stage>();
			for (Stage s : stages){
				if(req.getParameter("stages").equals(""+ s.getId())){
					stage =s;
				}
			}
			ArrayList<Leerling> leerlingen = new ArrayList<Leerling>();
			Objectify ofy = ObjectifyService.begin();
			LeerlingOfyDAOImpl lod = new LeerlingOfyDAOImpl();
			leerlingen = (ArrayList < Leerling > ) lod.getAllLeerlingen();
			req.setAttribute("studenten", leerlingen);
			
			req.setAttribute("destage", stage);
			
			
			// TODO: creeer een beoordeling vanuit de gegevens van beoordelingaanmaken.jsp
		}
		
		
		
		
		rd = req.getRequestDispatcher("BeoordelingAanmaken.jsp");
		rd.forward(req, resp);
	}
}



