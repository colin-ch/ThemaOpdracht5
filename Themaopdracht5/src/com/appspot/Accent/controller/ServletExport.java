package com.appspot.Accent.controller;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.google.appengine.api.users.UserServiceFactory;

public class ServletExport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(ServletExport.class.getName());

	@SuppressWarnings({ "unchecked", "unused" })
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*	ArrayList<LocalUser> users = (ArrayList<LocalUser>) getServletContext().getAttribute("Users");
		ArrayList<LocalUser> ssousers = (ArrayList<LocalUser>) getServletContext().getAttribute("SSOUsers");
		users.addAll(ssousers);
		try {
			resp.setContentType("application/zip");
			resp.setStatus(HttpServletResponse.SC_OK);
			ZipOutputStream zos = new ZipOutputStream(resp.getOutputStream());
			zos.putNextEntry(new ZipEntry("Userlijst.csv"));
			zos.write(getOutputData(users));
			zos.closeEntry();
			zos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private byte[] getOutputData(ArrayList<LocalUser> users){
		byte[] result = null;
		String tmp = "";
		for (LocalUser lu : users){
			tmp = tmp + lu.getUsername() + ", " + lu.getPassword() + ", " + lu.getEmail() + ", " + 
					lu.getActivatiecode() + ", " + lu.getDatumAangemaakt() + ", " + lu.getGeactiveerd() + ", " + lu.getRol() + "\n";
		}
		result = tmp.getBytes();
		return result;*/
	}
}