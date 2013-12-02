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
				<h3>StageBegeleider aanmaken</h3>
			</header>
			<div class="module_content">
			<%@ page import="com.appspot.Accent.model.StageBegeleider" %>
			<%@ page import="com.appspot.Accent.model.service.StageBegeleiderOfyDAOImpl" %>
			<%@ page import="java.util.ArrayList" %>
			<form action="/GebruikerAanmaken.do" method="get">
				Inlognaam van de StageBegeleider
				<input type="text" name="username" placeholder="inlognaam"><br/>
				Wachtwoord van de StageBegeleider
				<input type="text" name="wachtwoord" placeholder="Wachtwoord"><br/>
				Email van de StageBegeleider
				<input type="email" name="email" placeholder="Email"><br/>
				<input type="submit" value="Maak docent aan" name="stagebegeleider">
			</form>	
			</div>
		</article>
		<!-- end of styles article -->
		<div class="spacer"></div>
	</section>
	</div>
</body>

</html>