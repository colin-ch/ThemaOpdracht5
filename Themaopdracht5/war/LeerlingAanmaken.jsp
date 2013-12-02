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
				<h3>Leerling aanmaken</h3>
			</header>
			<div class="module_content">
			<%@ page import="com.appspot.Accent.model.StageBegeleider" %>
			<%@ page import="com.appspot.Accent.model.service.StageBegeleiderOfyDAOImpl" %>
			<%@ page import="java.util.ArrayList" %>
			<form action="/LeerlingAanmaken.do" method="get">
				Inlognaam van de leerling
				<input type="text" name="username" placeholder="inlognaam"><br/>
				Wachtwoord van de leerling
				<input type="text" name="wachtwoord" placeholder="Wachtwoord"><br/>
				Email van de leerling
				<input type="text" name="email" placeholder="Email"><br/>
				Klas van de leerling
				<input type="text" name="klas" placeholder="Klas"><br/>
				Naam van de begeleider van de leerling
				<input list="begeleiders" name="begeleiders" placeholder="email begeleider"><br/>
				<%
				StageBegeleiderOfyDAOImpl sbod = new StageBegeleiderOfyDAOImpl();
				out.println("<datalist name='begeleider' id='begeleiders'>");
				if (sbod.getAllBegeleiders() != null) {
					for (StageBegeleider sb : sbod.getAllBegeleiders()) {
						
						out.println(" <option value='"+  sb.getEmail() + "'/>") ;
					}
					out.println(" </datalist>");
				}
				else{
					out.println("Error") ;
				} %>
				</br>Geboortedatum van de leerling
				<input type="date" name="gebdat" placeholder="Geboortedatum"><br/>
				Roepnaam van de leerling
				<input type="date" name="roepnaam" placeholder="Roepnaam"><br/>
				Achternaam van de leerling
				<input type="date" name="achternaam" placeholder="Achternaam"><br/>
				<input type="submit" value="Maak leerling aan" name="leerling">
			</form>	
			</div>
		</article>
		<!-- end of styles article -->
		<div class="spacer"></div>
	</section>
	</div>
</body>

</html>