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
				<h3>Beheerders pagina</h3>
			</header>
			<div class="module_content">
				<p>Import / export</p><br/>
				<form method="post" action="Importeer.do" enctype="multipart/form-data">
					<input type="file" name="bestand"/>
					<input value="Importeer leerlingen met CSV" type="submit"/>
				</form>
				<form method="post" action="Importeers.do" enctype="multipart/form-data">
					<input type="file" name="bestand"/>
					<input value="Importeer stages met CSV" type="submit"/>
				</form>
				<form action="/Userlijst.zip" method="get">
				<input type="submit" value="export">
				</form>
				<br/><p>Gebruikers aanmaken</p><br/>
				<%@ page import="com.appspot.Accent.model.StageBegeleider" %>
				<%@ page import="com.appspot.Accent.model.service.StageBegeleiderOfyDAOImpl" %>
				<%@ page import="java.util.ArrayList" %>
				<button><a href="/LeerlingAanmaken.jsp">Maak een leerling aan</a></button>
				<button><a href="/DocentAanmaken.jsp">Maak een docent aan</a></button>
				<button><a href="/StageBegeleiderAanmaken.jsp">Maak een stagebegeleider aan</a></button>
				<button><a href="/StagebedrijfAanmaken.jsp">Maak een stagebedrijf aan</a></button>
				<br/><p>Competenties wijzigen</p>
				<br/><p>Stage aanmaken</p>
				<a href="StageAanmaken.jsp">Stage aanmaken</a>
			</div>
		</article>
		<!-- end of styles article -->
		<div class="spacer"></div>
	</section>
	</div>
</body>

</html>