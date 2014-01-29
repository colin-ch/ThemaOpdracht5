<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8" />
<title>Beoordelen</title>
<%@ include file="imports.jsp"%>

</head>


<body>

	<%@ include file="header.jsp"%>

	<section id="main" class="column"
		style="min-width: 1110px; min-height: 600px !important;">
		<% 
		Object msgs=request.getAttribute( "msgs"); 
		if (msgs !=null) { 
			out.println("<h4 class='alert_info'>"+msgs+"</h4>"); 
		} 
		%>


		<article class="module width_full">
			<header>
				<h3>Beoordelen</h3>
			</header>
			<div class="module_content">
				<%@ page import="com.appspot.Accent.model.Stage"%>
				<%@ page import="com.appspot.Accent.model.Beoordeling"%>

				<%@ page import="com.appspot.Accent.model.Competentie"%>
				<%@ page import="com.appspot.Accent.model.Stelling"%>
				<%@ page import="com.appspot.Accent.model.Leerling"%>
				<%@ page import="java.util.ArrayList"%>
				<%@ page import="com.googlecode.objectify.Objectify"%>
				<%@ page import="com.googlecode.objectify.ObjectifyService"%>
				<%@ page import="com.appspot.Accent.model.service.*"%>

				<form action="/BeoordeelServlet.do" method="GET">
					<%
				Objectify ofy = ObjectifyService.begin(); //alle objectify klassen die nodig zijn 
				StageOfyDAOImpl stod = new StageOfyDAOImpl();
				Object o = request.getSession().getAttribute("userobject");
				BeoordelingOfyDAOImpl bod = new BeoordelingOfyDAOImpl();
				CompetentieOfyDAOImpl cod = new CompetentieOfyDAOImpl();
				StellingOfyDAOImpl sod = new StellingOfyDAOImpl();
				StellingBeoordeeldOfyDAOImpl sbod = new StellingBeoordeeldOfyDAOImpl();
ArrayList<StellingBeoordeeld> beoordeelStellingen = (ArrayList <StellingBeoordeeld>) sbod.getAllStellingenBeoordeeld();
				ArrayList < Stage > allStages = (ArrayList < Stage > ) stod.getAllStages();//alle stages worden opgehaald
				ArrayList < Beoordeling > beoordelingen = (ArrayList < Beoordeling > ) bod.getAllBeoordelingen(); //alle beoordelingen worden opgehaald
out.println("<table class='beoordelentabbel'>");
				for (Stage s: allStages) { //alle stages worden door lopen
				    if (o instanceof Leerling) {//kijkt of ingelogde gebruiker een leerling is

				        if (s.getDeLeerling().equals(((Leerling) o).getUsername())) {//zoekt stage dmw van ingelogde gebruikersnaam te vergelijken met naam van leerling in stage
				            for (Beoordeling be: beoordelingen) {//alle beoordelingen doorlopen
				            	
				              if(be.getStage() == s.getId()){
				            	
				            	
				            	if (be.getDatumLeerling() == null) {
				            		ArrayList<Integer> beoordelencomp = be.getCompetenties();

				                    ArrayList < Competentie > competenties = (ArrayList < Competentie > ) cod.getAllCompetenties();
				                    int teller = 0;
				                    for (Competentie c: competenties) {
				                    	
				                    for(Integer inter : beoordelencomp){//alle competenties doorlopen
				                        //System.out.println(" "  + c.getTitel());
									if(inter == c.getEigenId()){
				                        out.println("<tr><td><h2>" + c.getTitel() + "</h2></td></tr>");

				                        ArrayList < Stelling > stellingen = (ArrayList < Stelling > ) sod.getAllStellingen();
				                        ArrayList <StellingBeoordeeld> currentbeoordelen = new ArrayList<StellingBeoordeeld>();
				                        ArrayList<Integer> controleArray = new ArrayList<Integer>();
				                        for(StellingBeoordeeld sbfill : beoordeelStellingen){
				                        	if(s.getId() == sbfill.getDeStage()){
				                        		if(sbfill.getDeWaardeLeerling() == null){
				                        			currentbeoordelen.add(sbfill);
				                        		}
				                        	}
				                        }
				                       
			                        	for(StellingBeoordeeld sb : currentbeoordelen){//alle stellingen door lopen
				                        for (Stelling st: stellingen) {
					                       if (st.getEigenId() == c.getEigenId()) {
				                            	if(st.getUniekID() == sb.getUniekID()){
				                            		boolean check =true;
				                            	for(int ctrl : controleArray){
				                            		if(ctrl == st.getUniekID()){
				                            			
				                            			check = false;
				                            		}

				                            	}
			                            		if(sb.getIDBeoordeling().equals(be.getIDBeoordeling())){

				                   

				                            	if(check == true){
				                            		controleArray.add(sb.getUniekID());
				                                teller++;
				                                String waarde = st.getDeWaarde();

				                                out.println("<tr><td><h4>" + st.getDeStelling() + "</h4></td>");
												//voor iedere stelling radio buttons maken
				                                if (waarde == null || waarde.equals("")) {
				                                    out.println("<td>1<input type='radio' name='" + st.getUniekID() + "' value='1'>2<input type='radio' name='" + st.getUniekID() + "' value='2'>3<input type='radio' name='" + st.getUniekID() + "' value='3'>4<input type='radio' name='" + st.getUniekID() + "' value='4'></td>");
				                                }

				                                if (waarde.equals("1")) {
				                                    out.println("<td>1<input type='radio' name='" + st.getUniekID() + "' checked='checked' value='1'>2<input type='radio' name='" + st.getUniekID() + "' value='2'>3<input type='radio' name='" + st.getUniekID() + "' value='3'>4<input type='radio' name='" + st.getUniekID() + "' value='4'></td>");
				                                }

				                                if (waarde.equals("2")) {
				                                    out.println("<td>1<input type='radio' name='" + st.getUniekID() + "' value='1'>2<input checked='checked' type='radio' name='" + st.getUniekID() + "' value='2'>3<input type='radio' name='" + st.getUniekID() + "' value='3'>4<input type='radio' name='" + st.getUniekID() + "' value='4'></td>");
				                                }
				                                if (waarde.equals("3")) {
				                                    out.println("<td>1<input type='radio' name='" + st.getUniekID() + "' value='1'>2<input  type='radio' name='" + st.getUniekID() + "' value='2'>3<input checked='checked' type='radio' name='" + st.getUniekID() + "' value='3'>4<input type='radio' name='" + st.getUniekID() + "' value='4'></td>");
				                                }
				                                if (waarde.equals("4")) {
				                                    out.println("<td>1<input type='radio' name='" + st.getUniekID() + "' value='1'>2<input type='radio' name='" + st.getUniekID() + "' value='2'>3<input checked='checked' type='radio' name='" + st.getUniekID() + "' value='3'>4<input type='radio' name='" + st.getUniekID() + "' value='4'></td></tr>");
				                                }
				                               
				                            	}

				                            }
				                            }}
				                        }}
				                    }}}
				                }
				             }
				            }
				        }
				    }
				}
				out.println("<tr><td>&nbsp; </td><td> &nbsp;</td></tr><tr><td><h4>eventuele Opmerkingen:</h4></td><td><textarea name='opmerking' value=''>geen opmerking</textarea></tr></table><br/> ");
				out.println("<input type='submit' value='Opslaan' name='Opslaan' />");
				%>

				</form>
				
				
			</div>


		</article>
		<!-- end of styles article -->
		<div class="spacer"></div>
	</section>

	</div>

</body>

</html>