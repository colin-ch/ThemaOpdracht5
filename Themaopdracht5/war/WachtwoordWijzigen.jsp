<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8" />
<title>Wachtwoord wijzigen</title>
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
				<h3>Selecteren gebruiker</h3>
			</header>
			<div class="module_content">
			

				<form action="BeoordelingOphalenServlet.do" method="GET">

					<%@ page import="java.util.*"%>
					<%@ page import="com.appspot.Accent.model.*"%>
					<%@ page import="com.appspot.Accent.model.service.*"%>
					<%
                            	Object users = session.getAttribute("userobject");//haalt huidige ingelogde gebruiker op
                            	StageOfyDAOImpl st = new StageOfyDAOImpl();
                            	LeerlingOfyDAOImpl l = new LeerlingOfyDAOImpl();
                        		DocentOfyDAOImpl d = new DocentOfyDAOImpl();
                        		StageBedrijfOfyDAOImpl sb = new StageBedrijfOfyDAOImpl();
                        		StageBegeleiderOfyDAOImpl sbg = new StageBegeleiderOfyDAOImpl();//Objectify klassen
                        		
                       			for(Leerling le : l.getAllLeerlingen()){//print alle leerlingen uit
                       				out.println("<input type='radio' name='radio' value='"+ le.getUsername() +"'>"+ le.getUsername() +" "+ le.getEmail() +" "+ le.getKlas() +" "+ le.getBegeleider()+"<br/>");
                       			}
                        		
                        	
                        		
                        		
                            	%>
				
					<input type="submit" value="verder">
				</form>
			</div>
		</article>
		<!-- end of styles article -->
		<div class="spacer"></div>
	</section>
	</div>
</body>

</html>