package com.appspot.Accent.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tools.ant.types.CommandlineJava.SysProperties;

import com.appspot.Accent.model.Beoordeling;
import com.appspot.Accent.model.Competentie;
import com.appspot.Accent.model.Leerling;
import com.appspot.Accent.model.Stage;
import com.appspot.Accent.model.Stelling;
import com.appspot.Accent.model.StellingBeoordeeld;
import com.appspot.Accent.model.service.BeoordelingOfyDAOImpl;
import com.appspot.Accent.model.service.CompetentieOfyDAOImpl;
import com.appspot.Accent.model.service.LeerlingOfyDAOImpl;
import com.appspot.Accent.model.service.StageOfyDAOImpl;
import com.appspot.Accent.model.service.StellingBeoordeeldOfyDAOImpl;
import com.appspot.Accent.model.service.StellingOfyDAOImpl;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class BeoordeelStageBedrijfServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(BeoordeelStageBedrijfServlet.class.getName());
	private Objectify ofy;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//		boolean succes = false;
		RequestDispatcher rd = null;
		String content ="<table class='beoordelentabbel'>";
		Object o = req.getSession().getAttribute("userobject");
		ofy = ObjectifyService.begin();
		Beoordeling rate =null;
		Stage deStage = null;
		Competentie nr1 = null;
		Competentie nr2 = null;
		Stelling stelling1 = null;		
		
		Stelling stelling2 = null;		
		
		Stelling stelling3 = null;		
		
		Stelling stelling4 = null;		
		
		Stelling stelling5 = null;
		StellingBeoordeeld beoordeeldeStelling = null;
		ArrayList<Beoordeling> allBeoordelingen = new ArrayList<Beoordeling>();
		//		ArrayList<Integer> allWaardes = new ArrayList<Integer>();
		//		int teller = 0;
		//		int stellingTeller = Integer.parseInt(req.getParameter("stellingTeller"));
		//		while(teller != stellingTeller){
		//			teller++;
		//			allWaardes.add(Integer.parseInt(req.getParameter("waarde"+teller)));
			
		StageOfyDAOImpl stod = new StageOfyDAOImpl();
boolean nextS = false;
		BeoordelingOfyDAOImpl bod = new BeoordelingOfyDAOImpl();
		LeerlingOfyDAOImpl lod = new LeerlingOfyDAOImpl();

		CompetentieOfyDAOImpl cod = new CompetentieOfyDAOImpl();
		StellingOfyDAOImpl sod = new StellingOfyDAOImpl();
		ArrayList<Integer> waardesl = new ArrayList<Integer>();
		ArrayList<Integer> waardesIDs = new ArrayList<Integer>();
		ArrayList<Integer> ints = new ArrayList<Integer>();
		// alles wordt aangemaakt
		allBeoordelingen =  (ArrayList<Beoordeling>) bod.getAllBeoordelingen();
		ArrayList<Stage> allStages = (ArrayList<Stage>) stod.getAllStages() ;
		StellingBeoordeeldOfyDAOImpl sbod = new StellingBeoordeeldOfyDAOImpl();
		ArrayList<Leerling> students = (ArrayList<Leerling>) lod.getAllLeerlingen();
		ArrayList<StellingBeoordeeld> beoordeelStellingen = (ArrayList <StellingBeoordeeld>) sbod.getAllStellingenBeoordeeld();

		 String deStudent = null;
		
			if(req.getParameter("Show")!= null){
				System.out.println("show");
			for(Stage s : allStages){
				boolean gevondenLeerling = false;
				for(Leerling stud : students){
					String temp = "" + stud.getRoepnaam() + " " + stud.getAchternaam();
					if(temp.equals(req.getParameter("leerlingen"))){
						gevondenLeerling = true;
						deStudent = stud.getUsername();
					}
				}
				if (gevondenLeerling) {
					//zoekt stage dmw van ingelogde gebruikersnaam te vergelijken met naam van leerling in stage
		            for (Beoordeling be: allBeoordelingen) {//alle beoordelingen doorlopen
		            	
		            	
		              if(be.getStage() == s.getId()){
		            	
		            	 

		            	
		            	if (be.getDatumBedrijf() == null) {
		            		ArrayList<Integer> beoordelencomp = be.getCompetenties();

		                    ArrayList < Competentie > competenties = (ArrayList < Competentie > ) cod.getAllCompetenties();
		                    int teller = 0;
		                    for (Competentie c: competenties) {
		                    	
		                    for(Integer inter : beoordelencomp){//alle competenties doorlopen
		                        //System.out.println(" "  + c.getTitel());
							if(inter == c.getEigenId()){
		                       content = content + "<tr><td><h2>" + c.getTitel() + "</h2></td></tr>";

		                        ArrayList < Stelling > stellingen = (ArrayList < Stelling > ) sod.getAllStellingen();
		                        ArrayList <StellingBeoordeeld> currentbeoordelen = new ArrayList<StellingBeoordeeld>();
		                        for(StellingBeoordeeld sbfill : beoordeelStellingen){
		                        	if(s.getId() == sbfill.getDeStage()){
		                        		if(sbfill.getDeWaardeStagebedrijf() == null){
		                        			currentbeoordelen.add(sbfill);
		                        			
		                        		}
		                        	}
		                        }
	                        	for(StellingBeoordeeld sb : currentbeoordelen){//alle stellingen door lopen
		                        for (Stelling st: stellingen) {

		                            if (st.getEigenId() == c.getEigenId()) {
		   		                            	if(st.getUniekID() == sb.getUniekID()){
		                            		if(sb.getIDBeoordeling().equals(be.getIDBeoordeling())){
		                            	
		                            	
		                               
		                                String waarde = st.getDeWaarde();

		                                content = content + "<tr><td><h4>" + st.getDeStelling() + "</h4></td>";
										//voor iedere stelling radio buttons maken
		                                if (waarde == null || waarde.equals("")) {
		                                	content = content + "<td>1<input type='radio' name='" + st.getUniekID() + "' value='1'>2<input type='radio' name='" + st.getUniekID() + "' value='2'>3<input type='radio' name='" + st.getUniekID() + "' value='3'>4<input type='radio' name='" + st.getUniekID() + "' value='4'></td></tr>";
		                                }

		                                if (waarde.equals("1")) {
		                                	content = content + "<td>1<input type='radio' name='" + st.getUniekID() + "' checked='checked' value='1'>2<input type='radio' name='" + st.getUniekID() + "' value='2'>3<input type='radio' name='" + st.getUniekID() + "' value='3'>4<input type='radio' name='" + st.getUniekID() + "' value='4'></td></tr>";
		                                }

		                                if (waarde.equals("2")) {
		                                	content = content + "<td>1<input type='radio' name='" + st.getUniekID() + "' value='1'>2<input checked='checked' type='radio' name='" + st.getUniekID() + "' value='2'>3<input type='radio' name='" + st.getUniekID() + "' value='3'>4<input type='radio' name='" + st.getUniekID() + "' value='4'></td></tr>";
		                                }
		                                if (waarde.equals("3")) {
		                                	content = content + "<td>1<input type='radio' name='" + st.getUniekID() + "' value='1'>2<input  type='radio' name='" + st.getUniekID() + "' value='2'>3<input checked='checked' type='radio' name='" + st.getUniekID() + "' value='3'>4<input type='radio' name='" + st.getUniekID() + "' value='4'></td></tr>";
		                                }
		                                if (waarde.equals("4")) {
		                                	content = content + "<td>1<input type='radio' name='" + st.getUniekID() + "' value='1'>2<input type='radio' name='" + st.getUniekID() + "' value='2'>3<input checked='checked' type='radio' name='" + st.getUniekID() + "' value='3'>4<input type='radio' name='" + st.getUniekID() + "' value='4'></td></tr>";
		                                }
		                               

		                            }}
		                            }
		                        }}
		                    }}}
		                }
		             }
		            }
		        
				}
			}
			rd = req.getRequestDispatcher("beoordelenOpleider.jsp");
			req.setAttribute("beoordelingopleider", content);
			System.out.println("meegegeven student:"+ deStudent);
			req.setAttribute("deLeerling", deStudent);
				
			}
			
			
			
			// inde volgende stuk wordt gekeken naar wie de leerling is en welke beoordeling hij meot doen (daar is nog geen datum van)
			if (req.getParameter("Opslaan") != null){
				System.out.println("opslaan");
				deStudent = req.getParameter("deLeerling");
				System.out.println("de gekregen leerling: "+ deStudent);
				for (Stage s : allStages) {
					

						if (s.getDeLeerling()
								.equals(deStudent)) {
							
							

		
								for(Beoordeling be : allBeoordelingen){
									if(be.getStage() == s.getId()){
										if(be.getDatumBedrijf() == null){
											rate = be;
										ints = be.getCompetenties();
										ArrayList<Competentie> competenties = new ArrayList<Competentie>();
										for(Integer inter : ints){
											ArrayList<Competentie> allCompetenties = (ArrayList<Competentie>) cod.getAllCompetenties();
											for(Competentie allc : allCompetenties){
												if(allc.getEigenId() == inter){
													competenties.add(allc);
												}
											}
										}
								
										int teller = 0;
										for(Competentie c : competenties){
											ArrayList<Stelling> stellingen = new ArrayList<Stelling>();
											stellingen = (ArrayList<Stelling>) sod.getAllStellingen();
											
											  ArrayList <StellingBeoordeeld> currentbeoordelen = new ArrayList<StellingBeoordeeld>();
						                        for(StellingBeoordeeld sbfill : beoordeelStellingen){
						                        	if(s.getId() == sbfill.getDeStage()){
						                        		
						                        		if(sbfill.getDeWaardeStagebedrijf() == null){
						                        			currentbeoordelen.add(sbfill);
						                        		}
						                        	}
						                        }
											
											for(Stelling stel : stellingen){
												for(StellingBeoordeeld sb : currentbeoordelen){
												if(c.getEigenId() == stel.getEigenId()){
												teller++;
												
												
												String s2 = req.getParameter("" +stel.getUniekID());
												int id = stel.getUniekID();
			                            	if(sb.getIDBeoordeling().equals(be.getIDBeoordeling())){

												
												beoordeeldeStelling = sb;
												
												if(req.getParameter("" +sb.getUniekID()).equals("1")){
beoordeeldeStelling.setDeWaardeStagebedrijf("1");
													
													ofy.put(beoordeeldeStelling);
												}
												if(req.getParameter("" +sb.getUniekID()).equals("2")){
beoordeeldeStelling.setDeWaardeStagebedrijf("2");
													
													ofy.put(beoordeeldeStelling);
												}
												if(req.getParameter("" +sb.getUniekID()).equals("3")){
beoordeeldeStelling.setDeWaardeStagebedrijf("3");
													
													ofy.put(beoordeeldeStelling);
												}
												if(req.getParameter("" +sb.getUniekID()).equals("4")){
beoordeeldeStelling.setDeWaardeStagebedrijf("4");
													
													ofy.put(beoordeeldeStelling);
												}
												
												
												

												}
												}
											}
												
												
											}
											}
										rate = be;
										}
										
								}}
								rate.setOpmerkingBedrijf(req.getParameter("opmerking"));
								rate.setStageOpleider(req.getParameter("opleider"));
								if(req.getParameter("opmerking").equals("")){
									rate.setOpmerkingBedrijf("geen opmerking");
								}
								// alles wordt buiten de arraylist gewijzigd
								log.info(rate.getOpmerkingBedrijf());
								Date d = new Date();
								String datum = d.toString();
								rate.setDatumBedrijf(datum);
								ofy.put(rate);
							}	
						
					}
					
					// er wordt een message meegegeven
					
					String msgs = "<h4 class='alert_success'>U heeft de beoordeling successvol ingevuld.</h4>";
		
				req.setAttribute("msgs", msgs);
				
		
				getServletContext().setAttribute("stages", allStages);
				rd = req.getRequestDispatcher("index.jsp");
			}
//			else{
//			rd = req.getRequestDispatcher("index.jsp");
//			}
			
			rd.forward(req, resp);	
		
			//}
		
		//	}
		
	
	
	}
}