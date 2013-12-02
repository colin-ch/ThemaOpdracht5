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
				<h3>Gebruiker aanmaken</h3>
			</header>
			<div class="module_content">
			<%@ page import="com.appspot.Accent.model.StageBegeleider" %>
			<%@ page import="com.appspot.Accent.model.service.StageBegeleiderOfyDAOImpl" %>
			<%@ page import="java.util.ArrayList" %>
			<button><a href="/LeerlingAanmaken.jsp">Maak een leerling aan</a></button>
			<button><a href="#">Maak een docent aan</a></button>
			<button><a href="#">Maak een stagebegeleider aan</a></button>
			<button><a href="#">Maak een stagebedrijf aan</a></button>
			
			</div>
		</article>
		<!-- end of styles article -->
		<div class="spacer"></div>
	</section>
	</div>
</body>

</html>