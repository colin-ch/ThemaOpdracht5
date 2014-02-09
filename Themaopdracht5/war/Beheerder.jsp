<!doctype html>
<html lang="en">

<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8" />
<title>Beheerder's pagina</title>
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
				<input type="submit" value="Export leerlingen / stages">
				</form>
				<br/><p>Gebruikers aanmaken</p><br/>
				<%@ page import="com.appspot.Accent.model.StageBegeleider" %>
				<%@ page import="com.appspot.Accent.model.service.StageBegeleiderOfyDAOImpl" %>
				<%@ page import="java.util.ArrayList" %>
				<button onclick="window.location.href='LeerlingAanmaken.jsp';">Maak een leerling aan</button>
				<button onclick="window.location.href='DocentAanmaken.jsp';">Maak een docent aan</button>
				<button onclick="window.location.href='StagebedrijfAanmaken.jsp';">Maak een bedrijf aan</button>
				<button onclick="window.location.href='StageBegeleiderAanmaken.jsp';">Maak een begeleider aan</button>
				<br/><p>Stelling/Competentie wijzigen</p>
				<button onclick="window.location.href='CompetentieSelecteren.jsp';">Pas een stelling aan</button>
				<button onclick="window.location.href='CompetentieOverzicht.jsp';">Pas een competentie aan</button>
				<br/><p>Stage aanmaken</p>
				<button onclick="window.location.href='StageAanmaken.jsp';">Stage aanmaken</button>
				<p>Wachtwoord</p>
				<button onclick="window.location.href='WachtwoordWijzigen.jsp';">Wachtwoord wijzigen</button>
				<%@ include file="uptime.html"%></div>
			</div><div>
		</article>
		<!-- end of styles article -->
		<div class="spacer"></div>
	</section>
	</div>
</body>

</html>