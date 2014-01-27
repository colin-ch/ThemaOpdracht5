<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8" />
<title>Leerling aanmaken</title>
<%@ include file="imports.jsp"%>
</head>

<body>
	
<%@ include file="header.jsp"%>
	<section id="main" class="column"
		style="min-width: 1110px; min-height: 600px !important;">
		
		<article class="module width_full">
			<header>
				<h3>Leerling aanmaken</h3>
			</header>
			<div class="module_content">
			
			
			
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
				
				<%@ page import="com.appspot.Accent.model.service.StageBegeleiderOfyDAOImpl"%>
				<%@ page import="com.appspot.Accent.model.StageBegeleider"%>
				<%@ page import="java.util.*"%>
				<%
				StageBegeleiderOfyDAOImpl sb = new StageBegeleiderOfyDAOImpl();
				ArrayList<StageBegeleider> array = (ArrayList<StageBegeleider>) sb.getAllBegeleiders(); //alle stages worden opgehaald
					out.println("<input list='begeleiders' name='begeleiders' required>");//lijst van stages wordt aangemaakt
					out.println("<datalist id='begeleiders'>");
					if (array != null) {
						for (int i = 0; i < array.size(); i++) {

							StageBegeleider fluf = array.get(i);
							out.println(" <option value='"+  fluf.getEmail() + "'>"+ fluf.getEmail() +"</option>") ;
						}
						out.println(" </datalist><br/>");
							
						}
					
					
					%>

				Geboortedatum van de leerling
				<input type="date" name="gebdat" required="required"><br/>
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
