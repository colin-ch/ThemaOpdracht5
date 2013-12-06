package com.appspot.Accent.controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
public class ServletImportStages extends HttpServlet {
	private static final Logger log = Logger.getLogger(ServletImportStages.class.getName());
	
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException{
		ServletFileUpload upload = new ServletFileUpload();
		RequestDispatcher rd = null;
		
		LeerlingOfyDAOImpl lod = new LeerlingOfyDAOImpl();
		
		int teller = 0;
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
					
					ArrayList<Leerling>leerlingen = (ArrayList<Leerling>) lod.getAllLeerlingen();
					while ((s = br.readLine()) != null){
						teller++;
						if(teller != 1){
							Scanner sc = new Scanner(s);
							sc.useDelimiter(";");
							String volgnrKlas = sc.next();
							String klasAanmelding = sc.next();
							String cAanmeldingKlasMentor1 = sc.next();
							String cAanmeldingKlasMentor2 = sc.next();
							String stamnr = sc.next();
							String roepnaam = sc.next();
							String tussenvoegsel = sc.next();
							String achternaam = sc.next();
							String leerling = sc.next();
							String begin = sc.next();
							String geplandeinde = sc.next();
							String werkelijk = sc.next();
							String leeftijdLeerling = sc.next();
							String gebDat = sc.next();
							Date gebDate = null;
							
							int length = gebDat.length();
							try {
								if(length >= 10){
									gebDate = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).parse(gebDat);
								}
								else{
									gebDate = new SimpleDateFormat("dd-M-yyyy", Locale.ENGLISH).parse(gebDat);
								}
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							String codeStageBedrijf = sc.next();
							String nmStageBedrijf = sc.next();
							String plaatsStageBedrijf = sc.next();
							String praktijkOpleider = sc.next();
							String codePraktijkbegleider = sc.next();
							String praktijkBegeleider = sc.next();
							String maVrij = sc.next();
							String diVrij = sc.next();
							String woVrij = sc.next();
							String doVrij = sc.next();
							String vrVrij = sc.next();
							String zaVrij = sc.next();
							String stageDagenVrijevelden = sc.next();
							String verwerktIn = sc.next();
							String succesvol = sc.next();
							String status = sc.next();
							String StageType = sc.next();
							String typebedrijfStageBedrijf = sc.next();
							String printdatumIdsbll = sc.next();
							String inleverdatumsIdbll = sc.next();
							String ondertekendIdsbll = sc.next();
							String StatusIdsbll = sc.next();
							String PBerVrijevelden = sc.next();
							String dagenperweek = sc.next();
							String BedragStagebedrijfVrijeveldenBedrijf = sc.next();
							String StageVergoedingStagebedrijfvrijeveldenBedrijf = sc.next();
							String opleiding = sc.next();
							String BedragStageBedrijf = sc.next();
							String BankrekeningLeerling = sc.next();
							String GiroLeerling = sc.next();
							String emailLeerling = sc.next();
							String SBO2INVrijeveldenBPV = sc.next();
							String SBODigitaalVrijevelden = sc.next();
							
							lod.createLeerling("username", "password", emailLeerling, roepnaam, tussenvoegsel +" "+achternaam, gebDate, klasAanmelding, praktijkBegeleider);
							log.info("leerlingen geimporteerd.");
							sc.close();
						}
						else{
							log.info("Eerste rij informatie");
						}
					}
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
