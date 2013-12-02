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
		
		<% 
		Object msgs=request.getAttribute( "msgs");
		if (msgs !=null) { 
			out.println("<h4 class='alert_success'>"+msgs+"</h4>"); 
			}			
			%>
		<article class="module width_full">
			<header>
				<h3>Profiel</h3>
			</header>
			<div class="module_content">
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
           		
           		if(user instanceof Leerling){ //kijkt of ingelogde gebruiker een leerling is
           			for(Leerling le : l.getAllLeerlingen()){
           				String name = ((Leerling) user).getUsername();
        				String pass = ((Leerling) user).getPassword();
           				if(name.equals(le.getUsername()) && pass.equals(le.getPassword())){//print alleen de leerling zelf uit met radio button
           					out.println("Inlognaam: " + le.getUsername()+"<br/>Email: "+ le.getEmail() +"<br/>Klas: "+ le.getKlas() +"<br/>Begeleider: "+ 
           				le.getBegeleider() +"<br/>Geboorte Datum: "+ le.getGeboortedatum() +"<br/>Roepnaam: "+ le.getRoepnaam()+"<br/>Achternaam: "+ le.getAchternaam());
           				}
           			}
           			
           		}
           		if(user instanceof Docent){ //kijkt of ingelogde gebruiker een leerling is
           			for(Docent de : d.getAllDocenten()){
           				String name = ((Docent) user).getUsername();
        				String pass = ((Docent) user).getPassword();
           				if(name.equals(de.getUsername()) && pass.equals(de.getPassword())){//print alleen de leerling zelf uit met radio button
           					out.println("Inlognaam: " + de.getUsername()+"<br/>Email: "+ de.getEmail());
           				}
           			}
           			
           		}
           		if(user instanceof StageBedrijf){ //kijkt of ingelogde gebruiker een leerling is
           			for(StageBedrijf sbe : sb.getAllStageBedrijven()){
           				String name = ((StageBedrijf) user).getUsername();
        				String pass = ((StageBedrijf) user).getPassword();
           				if(name.equals(sbe.getUsername()) && pass.equals(sbe.getPassword())){//print alleen de leerling zelf uit met radio button
           					out.println("Inlognaam: " + sbe.getUsername()+"<br/>Email: "+ sbe.getEmail()+"<br/>Plaats: "+ sbe.getPlaats()+"<br/>Code: "+ sbe.getCode());
           				}
           			}
           			
           		}
           		if(user instanceof StageBegeleider){ //kijkt of ingelogde gebruiker een leerling is
           			for(StageBegeleider stbe : sbg.getAllBegeleiders()){
           				String name = ((StageBegeleider) user).getUsername();
        				String pass = ((StageBegeleider) user).getPassword();
           				if(name.equals(stbe.getUsername()) && pass.equals(stbe.getPassword())){//print alleen de leerling zelf uit met radio button
           					out.println("Inlognaam: " + stbe.getUsername()+"<br/>Email: "+ stbe.getEmail());
           				}
           			}
           			
           		}
             %>	
				
				
			</div>
		</article>
		<!-- end of styles article -->
		<div class="spacer"></div>
	</section>
	</div>
</body>

</html>