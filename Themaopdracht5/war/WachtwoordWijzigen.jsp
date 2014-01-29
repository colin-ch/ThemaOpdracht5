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
			

				<form action="WachtwoordWijzigen.do" method="POST">

					<%@ page import="java.util.*"%>
					<%@ page import="com.appspot.Accent.model.*"%>
					<%@ page import="com.appspot.Accent.model.service.*"%>
					<%
					Object s= request.getAttribute("selected");
					if(s == null){
						out.println("<input type='hidden' value='1' name='hidden'>");
						out.println("<input type='submit' name='leerling' value='Leerling'>");
						out.println("<input type='submit' name='docent' value='Docent'>");
						out.println("<input type='submit' name='sb' value='Stagebegeleider'>");
						out.println("<input type='submit' name='bedrijf' value='Stagebedrijf'><br/><br/>");
					}

                	StageOfyDAOImpl st = new StageOfyDAOImpl();
                	LeerlingOfyDAOImpl l = new LeerlingOfyDAOImpl();
            		DocentOfyDAOImpl d = new DocentOfyDAOImpl();
            		StageBedrijfOfyDAOImpl sb = new StageBedrijfOfyDAOImpl();
            		StageBegeleiderOfyDAOImpl sbg = new StageBegeleiderOfyDAOImpl(); //Objectify klassen
            		if(s != null){
	            		if(s.equals("Leerling")){
	            			for(Leerling le : l.getAllLeerlingen()){//print alle leerlingen uit
	               				out.println("<input type='radio' name='radio' value='"+ le.getUsername() +"'>"+ le.getUsername() +" "+ le.getEmail() +" "+ le.getKlas() +" "+ le.getBegeleider()+"<br/>");
	               			}
	            			out.println("<input type='hidden' name='hidden' value='2'>");
		            		out.println("<input type='submit' value='selecteer'>");
	            		}
	            		if(s.equals("Docent")){
	            			for(Docent de : d.getAllDocenten()){//print alle docenten uit
	               				out.println("<input type='radio' name='radio' value='"+ de.getUsername() +"'>"+ de.getUsername() +" "+ de.getEmail()+"<br/>");
	               			}
	            			out.println("<input type='hidden' name='hidden' value='2'>");
		            		out.println("<input type='submit' value='selecteer'>");
	            		}
	            		if(s.equals("Stagebegeleider")){
	            			for(StageBegeleider sbge : sbg.getAllBegeleiders()){//print alle leerlingen uit
	               				out.println("<input type='radio' name='radio' value='"+ sbge.getUsername() +"'>"+ sbge.getUsername() +" "+ sbge.getEmail()+"<br/>");
	               			}
	            			out.println("<input type='hidden' name='hidden' value='2'>");
		            		out.println("<input type='submit' value='selecteer'>");
	            		}
	            		if(s.equals("Stageopleider")){
	            			for(StageBedrijf sbe : sb.getAllStageBedrijven()){//print alle leerlingen uit
	               				out.println("<input type='radio' name='radio' value='"+ sbe.getUsername() +"'>"+ sbe.getUsername() +" "+ sbe.getEmail()+"<br/>");
	               			}
	            			out.println("<input type='hidden' name='hidden' value='2'>");
		            		out.println("<input type='submit' value='selecteer'>");
	            		}
	            		
            		}
            		Object o = getServletContext().getAttribute("select");
            		if(o != null){
            			out.println("<label>Oude wachtwoord</label>");
            			out.println("<input type='text' name='oud'><br/>");
            			out.println("<label>Nieuwe wachtwoord</label>");
            			out.println("<input type='text' name='nieuw'><br/>");
            			out.println("<label>Bevestiging wachtwoord</label>");
            			out.println("<input type='text' name='nieuw2'><br/>");
            			
            			out.println("<input type='hidden' name='hiddene' value='3'>");
	            		out.println("<input type='submit' value='Verander'>");
            			
            		}
           			

                    		
                     %>
				<input type="submit" name="cancel" value="Cancel">
				</form>
			</div>
		</article>
		<!-- end of styles article -->
		<div class="spacer"></div>
	</section>
	</div>
</body>

</html>