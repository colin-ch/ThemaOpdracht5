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
import com.appspot.Accent.model.service.StageOfyDAOImpl;
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
		Object o = req.getSession().getAttribute("userobject");
		
		StellingOfyDAOImpl sod = new StellingOfyDAOImpl();
		StageOfyDAOImpl std = new StageOfyDAOImpl();
		
		ArrayList<Stage>stages = new ArrayList<Stage>();
		stages = (ArrayList<Stage>) std.getAllStages();
		ArrayList<Stelling> stellingen = new ArrayList<Stelling>();
		stellingen = (ArrayList<Stelling>) sod.getAllStellingen();
		boolean succes = false;
		
		for(Stage st : stages){
			log.info("1");
			if(o instanceof Leerling ){
				log.info("1");
				if (st.getDeLeerling().equals( ((Leerling) o).getUsername())){
			
					log.info("1");
					ArrayList<Beoordeling>beoordelingen = new ArrayList<Beoordeling>();
					beoordelingen = st.getBeoordelingen();
					if(beoordelingen != null){
						log.info("2");
						String bericht = "<select name='dropdown'>";
					
						int teller=0;
						for(Beoordeling b : beoordelingen){
							teller++;
						
							
							int teller1 = 0;
							
							ArrayList<Integer> waardes = b.getDeWaardesLeerling();
							ArrayList<Integer> waardeIDs = b.getDeIDsPerWaarde();
							for (Stelling stel : stellingen){
								
								for (int i : waardes){
									
									for(int i2 : waardeIDs){
										
										if(i2 == stel.getUniekID()){
											
											stel.setDeWaarde("" + i);
											
										}
										
										
									}
									
								}
								
							}
							bericht = bericht + "<option value="+b.getDatum()+">"+b.getDatum()+"</option>";
							log.info(bericht);
					//		System.out.println();
							
						}
						bericht = bericht+"</select>";
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
