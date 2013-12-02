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
import com.appspot.Accent.model.Leerling;
import com.appspot.Accent.model.School;
import com.appspot.Accent.model.Stage;
import com.appspot.Accent.model.Stelling;
import com.appspot.Accent.model.StellingBeoordeeld;
import com.appspot.Accent.model.service.StageOfyDAOImpl;
import com.appspot.Accent.model.service.StellingBeoordeeldOfyDAOImpl;
import com.appspot.Accent.model.service.StellingOfyDAOImpl;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class OverzichtServlet extends HttpServlet{
	private static final Logger log = Logger.getLogger(OverzichtServlet.class.getName());
	private Objectify ofy;
	
	protected void doGet( HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		
		ofy = ObjectifyService.begin();
		School s = new School("Accent", "Nijkerk", "Nijkerk", "0000AS");
		Object o = req.getSession().getAttribute("userobject");//haalt ingelogde gebruiker op
		
		StellingOfyDAOImpl sod = new StellingOfyDAOImpl();
		StellingBeoordeeldOfyDAOImpl sbd = new StellingBeoordeeldOfyDAOImpl();
		StageOfyDAOImpl std = new StageOfyDAOImpl();
		
		ArrayList<Stage>stages = new ArrayList<Stage>();
		stages = (ArrayList<Stage>) std.getAllStages();
		ArrayList<Stelling> stellingen = new ArrayList<Stelling>();
		stellingen = (ArrayList<Stelling>) sod.getAllStellingen();
		ArrayList<StellingBeoordeeld> stellingenbeoordeeld = new ArrayList<StellingBeoordeeld>();
		stellingenbeoordeeld = (ArrayList<StellingBeoordeeld>) sbd.getAllStellingenBeoordeeld();//alle stages, stellingbeoordeeld en stellingen worden opgehaald en in arraylists gezet
		boolean succes = false;
		
		for(Stage st : stages){//doorloopt alle stages
			log.info("1");
			if(o instanceof Leerling ){//is ingelogde gebruiker een leerling?
				log.info("1");
				if (st.getDeLeerling().equals( ((Leerling) o).getUsername())){//zoekt stage dmv naam ingelogde te vergelijken met stage.getLeerling()
			
					log.info("1");
					ArrayList<Beoordeling>beoordelingen = new ArrayList<Beoordeling>();
					beoordelingen = st.getBeoordelingen();//alle beoordelingen voor die stage worden opgehaald
					if(beoordelingen != null){
						log.info("2");
						String bericht = "<select name='dropdown'>";//dropdown worden gemaakt
					
						int teller=0;
						log.info("iets random");
						for(Beoordeling b : beoordelingen){//alle beoordelingen worden doorlopen
							teller++;
						
							
							int teller1 = 0;
							
						
							for (Stelling stel : stellingen){//alle stellingen worden doorlopen
								for(StellingBeoordeeld sb : stellingenbeoordeeld){//alle stellingbeoordeeld worden doorlopen
									if(sb.getDeStage() == st.getId()){//voor iedere stellingbeoordeeld wordt id van stage vergeleken. zo ja zet de waarde van stellingbeoordeeld
										if(stel.getUniekID() == sb.getUniekID()){
											stel.setDeWaarde(sb.getDeWaarde());
										}
									}
								
								}
							}
							bericht = bericht + "<option value="+b.getDatum()+">"+b.getDatum()+"</option>";
							log.info(bericht);//de options worden aan de select van de dropdown toegevoegd
					//		System.out.println();
							
						}
						bericht = bericht+"</select>";//select wordt gesloten
						succes = true;
						req.setAttribute("msgs", bericht);
					}
					else{
						req.setAttribute("msgs", "Er zijn nog geen beoordelingen gedaan");
					}
				}
			}
			else{
				req.setAttribute("msgs", "Er is nog geen stage bekend");
			}
		}
		RequestDispatcher rd = null;
		
		
	
		getServletContext().setAttribute("stellingen", stellingen);
		//System.out.println(alleStellingen);
		
		if(succes){
			rd = req.getRequestDispatcher("grafieken.jsp");
			log.info("3");
		}
		else{
			rd = req.getRequestDispatcher("grafieken.jsp");
			log.info("4");
		}
		
		
	
		rd.forward(req, resp);
	}

}
