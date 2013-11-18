package com.appspot.Accent.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
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
import com.appspot.Accent.model.Stelling;

public class BeoordelingOphalenServlet extends HttpServlet{
 
private static final Logger log = Logger.getLogger(OverzichtServlet.class.getName());
	
	protected void doGet( HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		String datum = req.getParameter("dropdown");
		Date d = new Date();
		try {
			d = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(datum);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object o = req.getSession().getAttribute("userobject");
		
		ArrayList<Stage>stages = new ArrayList<Stage>();
		stages = (ArrayList<Stage>) getServletContext().getAttribute("stages");
		
//		if(o instanceof Leerling ){//kijkt of het een leerling is
//			for(Stage st : stages){// haalt alle stages op
//				if (st.getDeLeerling().equals( ((Leerling) o).getUsername())){ // hier kijkt hij welke stage bij de leerlinge hoort
//					ArrayList<Beoordeling>beoordelingen = new ArrayList<Beoordeling>();
//					beoordelingen = st.getBeoordelingen();
//					for(Beoordeling b:beoordelingen){ //alle beoordelingen ophalen
//						System.out.println(b.getDatum());//datums niet gelijk
//						System.out.println(d);//d = tue jan 01 00:00:00 CET 2013 en b.getDatum = 01/01/2013
//						if(b.getDatum().equals(d));{//datums vergelijken
//							ArrayList<Competentie>competenties = new ArrayList<Competentie>();
//							competenties = b.getCompetenties();
//							for(Competentie c: competenties){//competenties doorlopen
//								ArrayList<Stelling> deStellingen = new ArrayList<Stelling>();
//								deStellingen = c.getDeStellingen();
//								for(Stelling s : deStellingen){ //stellingen door lopen
//									System.out.println(s.getDeWaarde());
//								}
//							}
//						}
//					}
//				}
//			}
//		}
		
		
		RequestDispatcher rd = null;
		rd = req.getRequestDispatcher("beoordelingoverzicht.jsp");
		rd.forward(req, resp);
		
	}
	
}
