package com.appspot.Accent.controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
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
public class ImportServlet extends HttpServlet {
	private static final Logger log = Logger.getLogger(ImportServlet.class.getName());
	
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException{
		ServletFileUpload upload = new ServletFileUpload();
		RequestDispatcher rd = null;
		try {
			FileItemIterator fii = upload.getItemIterator(req);
			while (fii.hasNext()){
				FileItemStream item = fii.next();
				InputStream stream = item.openStream();
				if (item.isFormField()){
					log.info("item is een formfield: " + item.getFieldName());
				} else {
					log.info("Bestand: " + item.getName());
					StringWriter writer = new StringWriter();
					IOUtils.copy(stream, writer, "UTF-8");
					String output = writer.toString();
					log.info("Input file =" + output);
					BufferedReader br = new BufferedReader(new StringReader(output));
					String s = "";
					LeerlingOfyDAOImpl lod = new LeerlingOfyDAOImpl();
					ArrayList<Leerling>leerlingen = (ArrayList<Leerling>) lod.getAllLeerlingen();
					while ((s = br.readLine()) != null){
						Scanner sc = new Scanner(s);
						/*sc.useDelimiter(", ");
						String un = sc.next();
						String ww = sc.next();
						String em = sc.next();
						String ac = sc.next();
						String da = sc.next();
						long dalo = Long.parseLong(da);
						String ga = sc.next();
						boolean g = Boolean.parseBoolean(ga);
						String ro = sc.next();
						int rol   = Integer.parseInt(ro);*/
						log.info(s);
						sc.close();
						//LocalUser lu = new LocalUser(un, ww, em, ac, dalo, g, rol);
						
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
