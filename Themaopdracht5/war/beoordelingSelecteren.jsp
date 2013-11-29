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
		<h4 class="alert_info">Welkom, dit is het competentie
			beoordelings systeem van Accent Nijkerk. Je hebt nog geen afspraken.</h4>

		<% Object msgs=request.getAttribute( "msgs"); if (msgs !=null) { out.println(msgs); } %>
		<article class="module width_full">
			<header>
				<h3>Selecteer beoordeling</h3>
			</header>
			<div class="module_content">
			<%@ page import="java.util.*"%>
				<%@ page import="com.appspot.Accent.model.*"%>
				<%@ page import="com.appspot.Accent.model.service.*"%>
				
				<form action='BeoordelingOphalenServlet.do' method='GET' >
				
				<%
				out.println("<select>");
				String geselecteerd = getServletContext().getAttribute("geselecteerd").toString();
				BeoordelingOfyDAOImpl b = new BeoordelingOfyDAOImpl();
				StageOfyDAOImpl s = new StageOfyDAOImpl();
				for(Stage st : s.getAllStages()){
					if(st.getDeLeerling().equals(geselecteerd)){
						for(Beoordeling be : st.getBeoordelingen()){
							out.println("<option value='"+ be.getDatum() +"'>" + be.getDatum() + "</option");
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