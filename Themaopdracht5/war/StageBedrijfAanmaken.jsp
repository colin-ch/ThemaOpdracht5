<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8" />
<title>Stage bedrijf aanmaken</title>
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
				<h3>Stage bedrijf aanmaken</h3>
			</header>
			<div class="module_content">
			<%@ page import="com.appspot.Accent.model.StageBegeleider" %>
			<%@ page import="com.appspot.Accent.model.service.StageBegeleiderOfyDAOImpl" %>
			<%@ page import="java.util.ArrayList" %>
			<form action="/GebruikerAanmaken.do" method="get">
				Inlognaam van het stagebedrijf
				<input type="text" name="username" placeholder="inlognaam"><br/>
				Wachtwoord van het stagebedrijf
				<input type="text" name="wachtwoord" placeholder="Wachtwoord"><br/>
				Email van het stagebedrijf
				<input type="email" name="email" placeholder="Email"><br/>
				Plaats van het stagebedrijf
				<input type="text" name="plaats" placeholder="Plaats van bedrijf"><br/>
				Code van het stagebedrijf
				<input type="text" name="code" placeholder="code"><br/>
				<input type="submit" value="Maak docent aan" name="stagebedrijf">
			</form>	
			</div>
		</article>
		<!-- end of styles article -->
		<div class="spacer"></div>
	</section>
	</div>
</body>

</html>