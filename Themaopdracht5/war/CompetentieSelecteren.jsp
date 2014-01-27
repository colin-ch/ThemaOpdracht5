<!doctype html>
<html>
<head>


<title>Competenties</title>

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
				<h3>Competentie Selecteren</h3>
			</header>
			<div class="module_content">
				<%@ page import="com.appspot.Accent.model.Stage"%>
			<%@ page import="com.appspot.Accent.model.Beoordeling"%>
			<%@ page import="com.appspot.Accent.model.StageBegeleider"%>
			<%@ page import="com.appspot.Accent.model.Competentie"%>
			<%@ page import="com.appspot.Accent.model.Stelling"%>
			<%@ page import="java.util.ArrayList"%>
			<%@ page import="com.googlecode.objectify.Objectify"%>
			<%@ page import="com.googlecode.objectify.ObjectifyService"%>
			<%@ page import="com.appspot.Accent.model.service.*"%>

<%			
			CompetentieOfyDAOImpl cod = new CompetentieOfyDAOImpl();
			ArrayList<Competentie> comps = (ArrayList<Competentie>) cod.getAllCompetenties();
			%>
			
				<h2>Kies een Competentie</h2>
				<form action="CompetentieOverzichtServlet.do" method="GET">
					<select name='competentie'>
					<%
					int iterator = 0;
					for(Competentie c : comps){
						iterator++;
						out.println("<option  value='"+ c.getEigenId() +"'>" + c.getTitel() +"</option>");
					}
					
					%>
					</select>
			
					<br /> <input type='submit' value='overzicht'>
				</form>
				
			</div>
		
			</div>


		</article>
		<!-- end of styles article -->
		<div class="spacer"></div>
	</section>

	</div>

</body>

</html>

</body>
</html>
