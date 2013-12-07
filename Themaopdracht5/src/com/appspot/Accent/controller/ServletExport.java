package com.appspot.Accent.controller;



import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appspot.Accent.model.Leerling;

public class ServletExport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(ServletExport.class.getName());

	@SuppressWarnings({ "unchecked", "unused" })
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			resp.setContentType("application/zip");
			resp.setStatus(HttpServletResponse.SC_OK);
			ZipOutputStream zos = new ZipOutputStream(resp.getOutputStream());
			zos.putNextEntry(new ZipEntry("Userlijst.csv"));
			zos.write(getOutputData());
			zos.closeEntry();
			zos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private byte[] getOutputData(ArrayList<Leerling> users){
		byte[] result = null;
		String tmp = "";
		for (Leerling l : users){
			tmp = tmp + l.getUsername() + "\n";
		}
		result = tmp.getBytes();
		return result;
	}
}