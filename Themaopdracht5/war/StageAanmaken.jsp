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
			out.println(msgs); 
		} 
		%>
		<article class="module width_full">
			<header>
				<h3>Stage aanmaken</h3>
			</header>
			<div class="module_content">
			<%@ page import="com.appspot.Accent.model.*" %>
			<%@ page import="com.appspot.Accent.model.service.*" %>
			<%@ page import="java.util.ArrayList" %>
			<form action="/StageAanmaken.do" method="get">
				ID van de stage
				<input type="number" name="id" placeholder="ID van de stage" required="required"><br/>
				Username van de deelnemende leerling
				<input list="leerlingen" name="leerlingen" placeholder="Naam van de leerling"><br/>
				<%
				LeerlingOfyDAOImpl lod = new LeerlingOfyDAOImpl();
				out.println("<datalist name='leerlingen' id='leerlingen'>");
				if (lod.getAllLeerlingen() != null) {
					for (Leerling l : lod.getAllLeerlingen()) {
						
						out.println(" <option value='"+  l.getRoepnaam() + "'/>") ;
					}
					out.println(" </datalist>");
				}
				else{
					out.println("Error") ;
				} %>
				Naam van de begeleider van de leerling
				<input list="begeleiders" name="begeleiders" placeholder="Naam begeleider"><br/>
				<%
				StageBegeleiderOfyDAOImpl sbod = new StageBegeleiderOfyDAOImpl();
				out.println("<datalist name='begeleider' id='begeleiders'>");
				if (sbod.getAllBegeleiders() != null) {
					for (StageBegeleider sb : sbod.getAllBegeleiders()) {
						
						out.println(" <option value='"+  sb.getEmail() + "'>"+sb.getUsername()+"</option>") ;
					}
					out.println(" </datalist>");
				}
				else{
					out.println("Error") ;
				} %>
				Naam van de opleider
				<input type="text" name="opleider" placeholder="Opleider"><br/>
				
				Naam van het bedrijf
				<input list="bedrijf" name="bedrijf" placeholder="Naam bedrijf"><br/>
				<%
				StageBedrijfOfyDAOImpl bod = new StageBedrijfOfyDAOImpl();
				out.println("<datalist name='bedrijf' id='bedrijf'>");
				if (bod.getAllStageBedrijven() != null) {
					for (StageBedrijf sbe : bod.getAllStageBedrijven()) {
						
						out.println(" <option value='"+  sbe.getUsername() + "'/>") ;
					}
					out.println(" </datalist>");
				}
				else{
					out.println("Error") ;
				} %>
				
				Begin datum stage
				<input type="date" name="begin" placeholder="Begin datum" required="required"><br/>
				Eind datum stage
				<input type="date" name="einde" placeholder="Einde datum" required="required"><br/>

				<input type="submit" value="Maak stage aan" name="stage">
			</form>	
			</div>
		</article>
		<!-- end of styles article -->
		<div class="spacer"></div>
	</section>
	</div>
</body>

</html>