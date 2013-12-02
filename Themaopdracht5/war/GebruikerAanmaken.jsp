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
			<input type="button" value="LeerlingAanmaken.jsp">Maak een leerling aan</button>
			<input type="button" value="LeerlingAanmaken.jsp">Maak een leerling aan</button>
			<input type="button" value="LeerlingAanmaken.jsp">Maak een leerling aan</button>
			<input type="button" value="LeerlingAanmaken.jsp">Maak een leerling aan</button>
			</div>
		</article>
		<!-- end of styles article -->
		<div class="spacer"></div>
	</section>
	</div>
</body>

</html>