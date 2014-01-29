<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8" />
<title>Beoordeling selecteren</title>
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
				
				<form action='/Overzicht.do' method='GET' id="form">
				
				<%
				out.println("<select name='select' id='select'>");
				String geselecteerd = getServletContext().getAttribute("geselecteerd").toString();
				BeoordelingOfyDAOImpl b = new BeoordelingOfyDAOImpl();
				ArrayList < Beoordeling > beoordelingen = (ArrayList < Beoordeling > ) b.getAllBeoordelingen();
				StageOfyDAOImpl s = new StageOfyDAOImpl();
				for(Stage st : s.getAllStages()){
					if(st.getDeLeerling().equals(geselecteerd)){
						
						for(Beoordeling be : b.getBeoordelingen(st.getId())){
						if(be.getDatumLeerling() != null && be.getDatumBedrijf() != null){
							out.println("<option class='wel' value='"+ be.getDatumLeerling() +"'>" + be.getDatumLeerling() + "</option>");
						}
						else{
			            	out.println("<option class='niet' disabled>Beoordeling nog niet gedaan door zowel bedrijf als leerling</option>");
			            }
						}
					}
				}
				%><%	
				out.println("</select>");
				out.println("<input type='hidden' name='geselecteerde' value='" + geselecteerd +"'/>");
				out.println("<input type='submit' value='overzicht'>");
				out.println("</form>");
				
				
				%>
			
				<br/>
				
				
				
				<script type="text/javascript">	
				$(document).ready(function () {

				    $('#select .niet').each(function () {
				        if ($(this).is(':selected')) {
				            $('#form input[type="submit"]').attr('disabled', 'disabled');
				        }
				        
				    });
				    
				    $('#select .wel').each(function () {
				        if ($(this).is(':selected')) {
				            $('#form input[type="submit"]').removeAttr('disabled');
				        }
				        
				    });
				    
				    });
				</script>
				
			</div>
		</article>
		<!-- end of styles article -->
		<div class="spacer"></div>
	</section>
	</div>
</body>

</html>