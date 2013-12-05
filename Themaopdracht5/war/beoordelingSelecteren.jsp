<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8" />
<title>Dashboard I Admin Panel</title>
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
				<h3>Selecteer beoordeling</h3>
			</header>
			<div class="module_content">
			<%@ page import="java.util.*"%>
				<%@ page import="com.appspot.Accent.model.*"%>
				<%@ page import="com.appspot.Accent.model.service.*"%>
				
				<form action='/Overzicht.do' method='GET' >
				
				<%
				out.println("<select>");
				String geselecteerd = getServletContext().getAttribute("geselecteerd").toString();
				BeoordelingOfyDAOImpl b = new BeoordelingOfyDAOImpl();
				ArrayList < Beoordeling > beoordelingen = (ArrayList < Beoordeling > ) b.getAllBeoordelingen();
				StageOfyDAOImpl s = new StageOfyDAOImpl();
				for(Stage st : s.getAllStages()){
					if(st.getDeLeerling().equals(geselecteerd)){
						
						for(Beoordeling be : b.getBeoordelingen(st.getId())){
						
							out.println("<option value='"+ be.getDatum() +"'>" + be.getDatum() + "</option");
							out.println("<input type='hidden' name='geselecteerde' value='" + geselecteerd +"'/>");
						}
					}
				}
							
				out.println("</select>");
				out.println("</form>");
				
				
				%>
				<br/>
				<input type='submit' value='overzicht'>
				</form>
			</div>
		</article>
		<!-- end of styles article -->
		<div class="spacer"></div>
	</section>
	</div>
</body>

</html>