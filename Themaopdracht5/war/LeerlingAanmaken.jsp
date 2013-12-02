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
		<% 
		Object msgs=request.getAttribute( "msgs"); 
		if (msgs !=null) { 
			out.println("<h4 class='alert_info'>"+msgs+"</h4>"); 
		} 
		%>
		<article class="module width_full">
			<header>
				<h3>Leerling aanmaken</h3>
			</header>
			<div class="module_content">
			<%@ page import="com.appspot.Accent.model.StageBegeleider" %>
			<%@ page import="com.appspot.Accent.model.service.StageBegeleiderOfyDAOImpl" %>
			<%@ page import="java.util.ArrayList" %>
			<form action="/GebruikerAanmaken.do" method="get">
				Inlognaam van de leerling
				<input type="text" name="username" placeholder="inlognaam" required="required"><br/>
				Wachtwoord van de leerling
				<input type="text" name="wachtwoord" placeholder="Wachtwoord" required="required"><br/>
				Email van de leerling
				<input type="email" name="email" placeholder="Email" required="required"><br/>
				Klas van de leerling
				<input type="text" name="klas" placeholder="Klas" required="required"><br/>
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
				Geboortedatum van de leerling
				<input type="date" name="gebdat" placeholder="Geboortedatum" required="required"><br/>
				Roepnaam van de leerling
				<input type="text" name="roepnaam" placeholder="Roepnaam" required="required"><br/>
				Achternaam van de leerling
				<input type="text" name="achternaam" placeholder="Achternaam" required="required"><br/>
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