<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8" />
<title>Profiel gegevens</title>
<%@ include file="imports.jsp"%>
</head>

<body>
	<%@ include file="header.jsp"%>
	<section id="main" class="column"
		style="min-width: 1110px; min-height: 600px !important;">
		
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
				UserOfyDAOImpl u = new UserOfyDAOImpl();
               	StageOfyDAOImpl st = new StageOfyDAOImpl();
               	LeerlingOfyDAOImpl l = new LeerlingOfyDAOImpl();
           		DocentOfyDAOImpl d = new DocentOfyDAOImpl();
           		StageBedrijfOfyDAOImpl sb = new StageBedrijfOfyDAOImpl();
           		StageBegeleiderOfyDAOImpl sbg = new StageBegeleiderOfyDAOImpl();//Objectify klassen
           		
           		if(user instanceof Leerling){ //kijkt of ingelogde gebruiker een leerling is
           			for(Leerling le : l.getAllLeerlingen()){
           				String email = ((Leerling) user).getEmail();
           				if(email.equals(le.getEmail())){//print alleen de leerling zelf uit met radio button
           					out.println("Inlognaam: " + le.getUsername()+"<br/>Email: "+ le.getEmail() +"<br/>Klas: "+ le.getKlas() +"<br/>Begeleider: "+ 
           				le.getBegeleider() +"<br/>Roepnaam: "+ le.getRoepnaam()+"<br/>Achternaam: "+ le.getAchternaam());
           				}
           			}
           			
           		}
           		if(user instanceof Docent){ //kijkt of ingelogde gebruiker een docent is
           			for(Docent de : d.getAllDocenten()){
           				String email = ((Docent) user).getEmail();
           				if(email.equals(de.getUsername())){//print alleen de leerling zelf uit met radio button
           					out.println("Inlognaam: " + de.getUsername()+"<br/>Email: "+ de.getEmail());
           				}
           			}
           			
           		}
           		if(user instanceof StageBedrijf){ //kijkt of ingelogde gebruiker een Stage bedrijf is
           			for(StageBedrijf sbe : sb.getAllStageBedrijven()){
           				String email = ((StageBedrijf) user).getEmail();
           				if(email.equals(sbe.getUsername())){//print alleen de leerling zelf uit met radio button
           					out.println("Inlognaam: " + sbe.getUsername()+"<br/>Email: "+ sbe.getEmail()+"<br/>Plaats: "+ sbe.getPlaats()+"<br/>Code: "+ sbe.getCode());
           				}
           			}
           			
           		}
           		if(user instanceof StageBegeleider){ //kijkt of ingelogde gebruiker een stage begeleider is
           			for(StageBegeleider stbe : sbg.getAllBegeleiders()){
           				String email = ((StageBegeleider) user).getEmail();
           				if(email.equals(stbe.getUsername())){
           					out.println("Inlognaam: " + stbe.getUsername()+"<br/>Email: "+ stbe.getEmail());
           				}
           			}
           			
           		}
           		if(user instanceof User){
           			for(User us : u.getAllUsers()){
           				String email = ((User) user).getEmail();
           				if(email.equals(us.getEmail())){
           					out.println("Inlognaam: " + us.getUsername()+"<br/>Email: "+ us.getEmail());
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