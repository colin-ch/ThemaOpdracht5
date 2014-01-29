package com.appspot.Accent.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appspot.Accent.model.Beoordeling;
import com.appspot.Accent.model.Competentie;
import com.appspot.Accent.model.Leerling;
import com.appspot.Accent.model.Stage;
import com.appspot.Accent.model.StageBedrijf;
import com.appspot.Accent.model.StageBegeleider;
import com.appspot.Accent.model.Stelling;
import com.appspot.Accent.model.StellingBeoordeeld;
import com.appspot.Accent.model.service.BeoordelingOfyDAOImpl;
import com.appspot.Accent.model.service.CompetentieOfyDAOImpl;
import com.appspot.Accent.model.service.LeerlingOfyDAOImpl;
import com.appspot.Accent.model.service.StageOfyDAOImpl;
import com.appspot.Accent.model.service.StellingOfyDAOImpl;
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
		ArrayList<Integer> beoordeelCompetenties = new ArrayList<Integer>();
ArrayList<Integer>deStellingen = new ArrayList<Integer>();
		ArrayList<Integer> stellingBeoordeeld = new ArrayList<Integer>();
String msgs = null;
		ofy = ObjectifyService.begin();
		boolean checkstudent = false;
		boolean checkstage = false;
		boolean checkcompetentie = false;
		boolean checkvalue = true;
		boolean checkbeoordeling = true;

		StageBegeleider begeleider = (StageBegeleider) req.getSession().getAttribute("userobject");
				// alles wordt globaal aangemaakt
		
		
		
		
			// als er stage is geselcteerd moet onderstaande worcden uitgevoerd
		if(req.getParameter("initStage") != null){
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
					checkstudent = true;
					student = f;
					System.out.println("student gekoppeld");

				}
			}
			if(checkstudent){
				req.setAttribute("initStage", "yolo");

			for(Stage s : stages){
				if(s.getDeLeerling().equals(student.getUsername())){
					studentStages.add(s);
					System.out.println("voeg stage toe");

				}
			}
			
			rd = req.getRequestDispatcher("BeoordelingAanmaken.jsp");
			
			req.setAttribute("stages", studentStages);
			}
			else{
				msgs = "<h4 class='alert_error'>U heeft een niet bestaande leerling ingevuld.</h4>";
				req.setAttribute("initLeerling", "yolo");

				req.setAttribute("msgs", msgs);
				req.setAttribute("studenten", leerlingen);
				rd = req.getRequestDispatcher("BeoordelingAanmaken.jsp");

			}
		}
		
		
		
		
		
		// als de beoordeling is aangemaakt is komt dit onderstaande stuk
		if(req.getParameter("create") != null){
			Objectify ofy = ObjectifyService.begin();

			ArrayList<Leerling> leerlingen = new ArrayList<Leerling>();
			LeerlingOfyDAOImpl lod = new LeerlingOfyDAOImpl();
			leerlingen = (ArrayList < Leerling > ) lod.getAllLeerlingen();
			
			
			ArrayList<Stage> stages = new ArrayList<Stage>();
			StageOfyDAOImpl sod = new StageOfyDAOImpl();
			stages = (ArrayList < Stage > ) sod.getAllStages();
			for (Stage s : stages){
	
				if(req.getParameter("stages").equals(""+ s.getId())){
					checkstage = true;
					stage = s;
				}
			}
			
			if(checkstage){
				req.setAttribute("save", "yolo");

			CompetentieOfyDAOImpl cod = new CompetentieOfyDAOImpl();
			ArrayList<Competentie> competenties = (ArrayList < Competentie > ) cod.getAllCompetenties();
			req.setAttribute("studenten", leerlingen);
			req.setAttribute("competenties", competenties);
			req.getSession().setAttribute("destage", stage);
			
			rd = req.getRequestDispatcher("BeoordelingAanmaken.jsp");
					}
			else{
msgs = "<h4 class='alert_error'>U heeft een niet bestaande stage ingevuld.</h4>";

req.setAttribute("initStage", "yolo");

for(Leerling f : leerlingen){
	
		student = f;
		for(Stage s : stages){
			if(s.getDeLeerling().equals(student.getUsername())){
				studentStages.add(s);
					}
				}
	
}

req.setAttribute("msgs", msgs);
req.setAttribute("stages", studentStages);
rd = req.getRequestDispatcher("BeoordelingAanmaken.jsp");
			}
		}
		
		
		
		
		
		if(req.getParameter("save") != null){
			msgs = "<h4 class='alert_success'>U heeft succesvol een beoordeling gemaakt.</h4>";
			SessionIdentifierGenerator sig = new SessionIdentifierGenerator();
			
			String ID = sig.nextSessionId();
			
		Stage currentstage = (Stage) req.getSession().getAttribute("destage");
		
			ArrayList<StellingBeoordeeld> stelbeoordelen = new ArrayList<StellingBeoordeeld>();
int destage = currentstage.getId();

BeoordelingOfyDAOImpl bod = new BeoordelingOfyDAOImpl();
ArrayList<Beoordeling> beoordelingen = (ArrayList < Beoordeling > ) bod.getAllBeoordelingen();
for(Beoordeling be : beoordelingen){
	if(be.getStage() == destage){
		if(be.getDatumBedrijf() == null || be.getDatumLeerling() == null){
		checkbeoordeling = false;
		}
	}
}
if(checkbeoordeling){
			CompetentieOfyDAOImpl cod = new CompetentieOfyDAOImpl();
			ArrayList<Competentie> competenties = (ArrayList < Competentie > ) cod.getAllCompetenties();
			StellingOfyDAOImpl stod = new StellingOfyDAOImpl();
			ArrayList<Stelling> stellingen = (ArrayList < Stelling > ) stod.getAllStellingen() ;
			for(Competentie c : competenties){
				if(req.getParameter("" + c.getEigenId()) != null){
					checkcompetentie = true;
					beoordeelCompetenties.add(c.getEigenId());
					String s2 = req.getParameter("radio"+ c.getEigenId());
					if(s2 != null){
						checkvalue = checkvalue && true;
					for(Stelling s : stellingen){
						if(s.getEigenId() == c.getEigenId()){
						if(s.getDeWaarde().equals(s2)){
							stellingBeoordeeld.add(s.getUniekID());
							StellingBeoordeeld x = new StellingBeoordeeld(null, null, s.getUniekID(),ID,  destage);
							ofy.put(x);
						}
					}
					}
				}
					else{
						checkvalue = false;
					}
				}
			}
}
			if(checkcompetentie && checkvalue && checkbeoordeling){
			rd = req.getRequestDispatcher("index.jsp");
			Beoordeling be = new Beoordeling(ID, null, null,"nog niet bekend", "nog niet gedaan","nog niet gedaan",destage, beoordeelCompetenties, stellingBeoordeeld);
ofy.put(be);
			}else{
				rd = req.getRequestDispatcher("/BeoordelingAanmaken.jsp");

				if(!checkcompetentie){
				msgs = "<h4 class='alert_error'>u heeft geen competenties aangevinkt</h4>";
				}
				if(!checkvalue){
					msgs = "<h4 class='alert_error'>u heeft geen niveau bij een geselcteerde competentie aangevinkt</h4>";
				}
				if(!checkbeoordeling){
					msgs = "<h4 class='alert_error'>de vorgie beoordeling van deze stage is nog niet voltooid</h4>";
				}
			}
			req.setAttribute("msgs", msgs);
		}
		
		
		rd.forward(req, resp);
	}
}



