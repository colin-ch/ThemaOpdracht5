package com.appspot.Accent.controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import com.appspot.Accent.model.Leerling;
import com.appspot.Accent.model.service.LeerlingOfyDAOImpl;

@SuppressWarnings("serial")
public class ServletImportLeerlingen extends HttpServlet {
	private static final Logger log = Logger.getLogger(ServletImportStages.class.getName());
	
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException{
		ServletFileUpload upload = new ServletFileUpload();
		RequestDispatcher rd = null;
		
		LeerlingOfyDAOImpl lod = new LeerlingOfyDAOImpl();
		
		int teller = 0;
		boolean bestaat = false;
		try {
			FileItemIterator fii = upload.getItemIterator(req);
			while (fii.hasNext()){
				FileItemStream item = fii.next();
				InputStream stream = item.openStream();
				if (item.isFormField()){
					//log.info("item is een formfield: " + item.getFieldName());
				} else {
					//log.info("Bestand: " + item.getName());
					StringWriter writer = new StringWriter();
					IOUtils.copy(stream, writer, "UTF-8");
					String output = writer.toString();
					log.info("Input file =" + output);
					BufferedReader br = new BufferedReader(new StringReader(output));
					String s = "";
					
					while ((s = br.readLine()) != null){
						teller++;
						if(teller != 1){
							Scanner sc = new Scanner(s);
							sc.useDelimiter(";");
							String volgnrKlas = sc.next();
							String klasAanmelding = sc.next();
							String stamnr = sc.next();
							String roepnaam = sc.next();
							String tussenvoegsel = sc.next();
							String achternaam = sc.next();
							String leerling = sc.next();
							String emailLeerling = sc.next();
							String beginS = sc.next();
							String geplandeinde = sc.next();

							Date begin = null;
							Date einde = null;

							try {
									begin = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).parse(beginS);
									einde = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).parse(geplandeinde);
							} 
							catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
								
							String codePraktijkBegeleider = sc.next();
							String naamPraktijkBegeleider = sc.next();
							String emailPraktijkBegeleider = sc.next();
							int codeStageBedrijf = Integer.parseInt(sc.next());
							String nmStageBedrijf = sc.next();
							String plaatsStageBedrijf = sc.next();
							String praktijkOpleider = sc.next();
							String status = sc.next();
							String stageType = sc.next();
							String typeBedrijf = sc.next();
							String huisnrBedrijf = sc.next();
							String straatBedrijf = sc.next();
							String huisnrToeBedrijf = sc.next();
							String postcodeBedrijf = sc.next();
							
							for(Leerling l : lod.getAllLeerlingen()){
								if(l.getEmail().equals(emailLeerling)){
									bestaat = true;
									log.info(l.getEmail() +" deze leerling bestaat al");
								}
							}
							if(bestaat == false){
								lod.createLeerling("Username", "Password", emailLeerling, roepnaam, tussenvoegsel + " "+achternaam, null, klasAanmelding, emailPraktijkBegeleider);
							}
							sc.close();
						}
						else{	log.info("eerste rij info");					}
					}
					req.setAttribute("msgs", "Leerlingen geïmporteerd");

					rd = req.getRequestDispatcher("index.jsp");
				}
				rd.forward(req, resp);
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
