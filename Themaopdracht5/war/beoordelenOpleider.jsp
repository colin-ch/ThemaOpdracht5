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

				<form action="/BeoordeelStageBedrijfServlet.do" method="GET">
					<%
					
					Object beoordelingopleider = request.getAttribute( "beoordelingopleider");
					
					if (beoordelingopleider == null ) { 
						StageOfyDAOImpl sod = new StageOfyDAOImpl();
						ArrayList<Stage> deStages = (ArrayList<Stage>)sod.getAllStages();
LeerlingOfyDAOImpl lod = new LeerlingOfyDAOImpl();
ArrayList<Leerling> students =  (ArrayList<Leerling>)lod.getAllLeerlingen();
						ArrayList<Leerling> deLeerlingen = new ArrayList<Leerling>();
						Leerling fluf = null;
						out.println("<h2> selecteer een leerling:</h2>");
						out.println("<input list='leerlingen' name='leerlingen' required>");//lijst van leerlingen wordt aangemaakt
						out.println("<datalist id='leerlingen'>");
						if (deStages != null) {
							for (Stage s : deStages) {
								StageBedrijf sessionUser = (StageBedrijf)session.getAttribute("userobject");
if(s.getHetBedrijf().equals(sessionUser.getUsername())){
	for(Leerling x : students){
		if(s.getDeLeerling().equals(x.getUsername())){
	fluf = x;

		}
	}
	if(fluf != null){
								out.println(" <option value='"+  fluf.getRoepnaam() + " " + fluf.getAchternaam()+  "'>"+ fluf.getRoepnaam() + " " + fluf.getAchternaam()+  "</option>") ;
	}}
							
						
							}
							out.println(" </datalist>");
						out.println("<input type='submit' value='Verder' name='Show'/>");
			
						}
						
						
					}

			if (beoordelingopleider !=null) { 
				Object obj = request.getAttribute("deLeerling");
				System.out.println("de doorgevoerde student: "+ obj);
				out.println("<input type='hidden' name='deLeerling' value="+obj+" />");
					out.println(beoordelingopleider);
				out.println("<br/>eventuele Opmerkingen:<input type='text' name='opmerking' value=''> ");
				out.println("<input type='submit' value='Opslaan' name='Opslaan' />");
					}
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