<!doctype html>
<html lang="en">

<head>
	<meta charset="utf-8"/>
	<title>Beoordeling aanmaken</title>
	<%@ include file="imports.jsp"%>
</head>


<body>

	<%@ include file="header.jsp"%>
	
	<section id="main" class="column"   style="min-width: 1110px; min-height: 600px!important;">
		
		<% 
		Object msgs=request.getAttribute( "msgs"); 
		if (msgs !=null) { 
			out.println("<h4 class='alert_info'>"+msgs+"</h4>"); 
		} 
		%>	
		<article class="module width_full">
			<header><h3>Beoordeling aanmaken</h3></header>
				<div class="module_content">
					<%@ page import="com.appspot.Accent.model.Stage" %>
								<%@ page import="com.appspot.Accent.model.Beoordeling" %>
				
				<%@ page import="com.appspot.Accent.model.Competentie" %>
	<%@ page import="com.appspot.Accent.model.Stelling" %>
	<%@ page import="com.appspot.Accent.model.Leerling" %>
		<%@ page import="com.appspot.Accent.model.service.LeerlingOfyDAOImpl" %>
		<%@ page import="com.googlecode.objectify.*" %>

	<%@ page import="java.util.ArrayList" %>
				
				<form action="/BeoordelingAanmakenServlet.do" method="GET">
				<%
				Object initStage = request.getAttribute( "initStage");
				Object save = request.getAttribute("save");

				if(save == null && initStage == null){
					ArrayList<Leerling> array = new ArrayList<Leerling>();
					Objectify ofy = ObjectifyService.begin();
					LeerlingOfyDAOImpl lod = new LeerlingOfyDAOImpl();
					array = (ArrayList < Leerling > ) lod.getAllLeerlingen();
					out.println("<h2> selecteer een leerling:</h2>");
					out.println("<input list='leerlingen' name='leerlingen' required>");//lijst van leerlingen wordt aangemaakt
					out.println("<datalist id='leerlingen'>");
					if (array != null) {
						for (int i = 0; i < array.size(); i++) {

							Leerling fluf = array.get(i);
							out.println(" <option value='"+  fluf.getRoepnaam() + " " + fluf.getAchternaam()+  "'>"+ fluf.getRoepnaam() + " " + fluf.getAchternaam()+  "</option>") ;
						}
						out.println(" </datalist>");
					
						}
					out.println("<input type='submit' value='Verder' name='initStage'/>");
					}
				
				
				
				if(initStage != null){
					out.println("<h2> selecteer een stage: </h2>");

					ArrayList<Stage> array = (ArrayList<Stage>) request.getAttribute("stages"); //alle stages worden opgehaald
					out.println("<input list='stages' name='stages' required>");//lijst van stages wordt aangemaakt
					out.println("<datalist id='stages'>");
					if (array != null) {
						for (int i = 0; i < array.size(); i++) {

							Stage fluf = array.get(i);
							out.println(" <option value='"+  fluf.getId() + "'>"+ fluf.getId() +"</option>") ;
						}
						out.println(" </datalist>");
							
						}
					out.println("<input type='submit' value='Verder' name='create'/>");
					}
				
				
				if(save != null){
					out.println("<h2> kies de competenties en bijbehorende stellingen: </h2>");
					Leerling student = null;
					Stage stage =(Stage) request.getSession().getAttribute("destage");
					ArrayList<Leerling> array = (ArrayList<Leerling>) request.getAttribute("studenten"); //alle leerlingen worden opgehaald
					if(stage == null){
						out.println("stage is null");
					}
					out.println(stage.getDeLeerling());
					for(Leerling l: array){
						if(stage.getDeLeerling().equals(l.getUsername())){
							student = l;
						}
					}
					 	 if(student != null){
					out.print("<label class='nameclass'>De Leerling:</label><label class='inputclass'>" + student.getRoepnaam() + " " + student.getAchternaam()+ "</label><br/>"); 
					out.print("<label class='nameclass'>Stage ID:</label><label class='inputclass'>" + stage.getId() +"</label><br/>"); 
					out.print("<label class='nameclass'>Stage bedrijf:</label><label class='inputclass'>" + stage.getHetBedrijf() +"</label><br/>"); 
					out.print("<label class='nameclass'>Stage opleider:</label><label class='inputclass'>" + stage.getDeOpleider() +"</label><br/><br/>"); 
					
					ArrayList<Competentie> competenties = (ArrayList<Competentie>) request.getAttribute("competenties");
					out.println("<table class='tableopmaak'><tr><td><label id='titel'>De competentie</label></td><td><label id='titel'>Het niveau</label></td></tr>");

					for(Competentie c : competenties){
						out.print("<h4><tr><td><h4><input type='checkbox' name='"+ c.getEigenId() +"' value='"+ c.getEigenId() +"'/><label class='competentieclass'>"+ c.getTitel() +"</label><label class='radiobuttons'></h4></td><td><h4>1<input type='radio' name='radio"+c.getEigenId()+"' value='1'/>2<input type='radio' name='radio"+c.getEigenId()+"' value='2'/>3<input type='radio' name='radio"+c.getEigenId()+"' value='3'/></h4></td></label></tr></h4> ");
					}
					out.println("</table><input type='submit' value='Beoordeling Opslaan' name='save'/>");
					 	 }
					 	 
					
				}
				
				%>
				
				</form>
			
					</div>
					
					
		</article><!-- end of styles article -->
		<div class="spacer"></div>
	</section>

</div>

</body>

</html>