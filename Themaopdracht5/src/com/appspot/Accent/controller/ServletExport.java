package com.appspot.Accent.controller;



import java.io.IOException;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appspot.Accent.model.Leerling;
import com.appspot.Accent.model.Stage;
import com.appspot.Accent.model.service.LeerlingOfyDAOImpl;
import com.appspot.Accent.model.service.StageOfyDAOImpl;

public class ServletExport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(ServletExport.class.getName());
	LeerlingOfyDAOImpl lod = new LeerlingOfyDAOImpl();
	StageOfyDAOImpl sod = new StageOfyDAOImpl();

	@SuppressWarnings({ "unchecked", "unused" })
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("application/zip");
			resp.setStatus(HttpServletResponse.SC_OK);
			ZipOutputStream zos = new ZipOutputStream(resp.getOutputStream());
			zos.putNextEntry(new ZipEntry("Userlijst.csv"));
			zos.write(getOutputData("export"));
			zos.closeEntry();
			zos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private byte[] getOutputData(String l){
		byte[] result = null;
		boolean stagebekend = false;
		String tmp = "Klas;Username leerling;Password leerling;Email leerling;Roepnaam leerling;Achternaam Leerling;Geboortedatum leerling;Begin datum;Eind datum;Naam begeleider;Id van de stage;Naam van het bedrijf;De naam van opleider\n";
		for (Leerling le : lod.getAllLeerlingen()){
			tmp = tmp +le.getKlas()+ ";" + le.getUsername()+ ";" + le.getPassword()+ ";" + le.getEmail()+ ";" + le.getRoepnaam()+ ";" +le.getAchternaam()+ ";" +le.getGeboortedatum() + ";";
			for(Stage st : sod.getAllStages()){
				if(st.getDeLeerling().equals(le.getUsername())){
					tmp = tmp + st.getBegindatum() + ";" + st.getEinddatum()+ ";" + st.getDeBegeleider()+ ";" +st.getId()+ ";" +st.getHetBedrijf()+ ";" +st.getDeOpleider()+"\n";
					stagebekend = true;
				}
				else{
					log.info("geen stage bekend");
				}
			}
			if(stagebekend == false){
				tmp = tmp + ";;;;;;\n";
			}
		
		}
		
		result = tmp.getBytes();
		return result;
	}
}