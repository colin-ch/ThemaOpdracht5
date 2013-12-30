<!doctype html>
<html lang="en">

<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
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
				<input type="submit" value="Export leerlingen / stages">
				</form>
				<br/><p>Gebruikers aanmaken</p><br/>
				<%@ page import="com.appspot.Accent.model.StageBegeleider" %>
				<%@ page import="com.appspot.Accent.model.service.StageBegeleiderOfyDAOImpl" %>
				<%@ page import="java.util.ArrayList" %>
				<a href="/LeerlingAanmaken.jsp"><button>Maak een leerling aan</button></a>
				<a href="/DocentAanmaken.jsp"><button>Maak een docent aan</button></a>
				<a href="/StageBegeleiderAanmaken.jsp"><button>Maak een stagebegeleider aan</button></a>
				<a href="/StagebedrijfAanmaken.jsp"><button>Maak een stagebedrijf aan</button></a>
				<br/><p>Competenties wijzigen</p>
				<a href="/CompetentieSelecteren.jsp"><button>Pas een competentie aan</button></a>
				<br/><p>Stage aanmaken</p>
				<a href="StageAanmaken.jsp"><button>Stage aanmaken</button></a>
			</div>
		</article>
		<!-- end of styles article -->
		<div class="spacer"></div>
	</section>
</body>

</html>