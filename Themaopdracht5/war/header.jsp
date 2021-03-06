
<header id="header" style="min-width: 850px;">
	
</header>
<!-- end of header bar -->

<section id="secondary_bar" style="min-width: 850px;">
	<div class="user">
	<%@ page import="com.appspot.Accent.model.*" %>
	<%
	
	Object user = session.getAttribute("userobject");
	String naam = "";
	String rol = "";
	if(user instanceof Leerling){
		naam = ((Leerling) user).getRoepnaam() +" " + ((Leerling) user).getAchternaam();
		rol = "leerling";
	}
	if(user instanceof Docent){
		naam = ((Docent) user).getUsername();
		rol = "Docent";
	}
	if(user instanceof StageBedrijf){
		naam = ((StageBedrijf) user).getUsername();
		rol = "Stage bedrijf";
	}
	if(user instanceof StageBegeleider){
		naam = ((StageBegeleider) user).getUsername();
		rol = "Stagebegeleider";
	}
	if(user instanceof User){
		naam = ((User) user).getUsername();
		rol = "beheerder";
	}
	
	out.println("<p>"+ naam +"</p>"); 
	%>
		<!-- <a class="logout_user" href="#" title="Logout">Logout</a> -->
	</div>
	
</section>
<!-- end of secondary bar -->

<div style="min-width: 1410px; width: auto;">
	<aside id="sidebar" class="column"
		style="min-width: 250px; width: 288px !important; height: 100% !important; min-height: 600px !important;">
		<form class="quick_search">
			
		</form>
		<hr />
		<h3>Menu</h3>
		<ul class="toggle">
		<% 
		if(user instanceof Leerling){
			out.println("<li class='icn_edit_article'><a href='/BeoordeelServlet.do'>Beoordelen</a></li>");
			out.println("<li class='icn_view_users'><a href='overzichtgebruikers.jsp'>Beoordelingen bekijken</a></li>");
			out.println("<li class='icn_view_users'><a href='Profiel.jsp'>Profiel gegevens</a></li>");
			out.println("<li class='icn_jump_back'><a href='/LogoutServlet.do'>Loguit</a></li>");
		}
		if(user instanceof Docent){
			out.println("<li class='icn_categories'><a href='CompetentieSelecteren.jsp'>Competenties bekijken</a></li>");
			out.println("<li class='icn_view_users'><a href='overzichtgebruikers.jsp'>Beoordelingen bekijken</a></li>");
			out.println("<li class='icn_view_users'><a href='Profiel.jsp'>Profiel gegevens</a></li>");
			out.println("<li class='icn_jump_back'><a href='/LogoutServlet.do'>Loguit</a></li>");
		}
		if(user instanceof StageBedrijf){
			out.println("<li class='icn_edit_article'><a href='beoordelenOpleider.jsp'>Beoordelen</a></li>");
			out.println("<li class='icn_view_users'><a href='overzichtgebruikers.jsp'>Beoordelingen bekijken</a></li>");
			out.println("<li class='icn_view_users'><a href='Profiel.jsp'>Profiel gegevens</a></li>");
			out.println("<li class='icn_jump_back'><a href='/LogoutServlet.do'>Loguit</a></li>");
		}
		if(user instanceof StageBegeleider){
			out.println("<li class='icn_new_article'><a href='/BeoordelingAanmaken.jsp'>Beoordeling aanmaken</a></li>");
			out.println("<li class='icn_view_users'><a href='overzichtgebruikers.jsp'>Beoordelingen bekijken</a></li>");
			out.println("<li class='icn_view_users'><a href='StageAanmaken.jsp'>Stage aanmaken</a></li>");
			out.println("<li class='icn_view_users'><a href='StageOverzicht.jsp'>Stages overzicht</a></li>");
			out.println("<li class='icn_view_users'><a href='Profiel.jsp'>Profiel gegevens</a></li>");
			out.println("<li class='icn_jump_back'><a href='/LogoutServlet.do'>Loguit</a></li>");
		}
		if(user instanceof User){
			out.println("<li class='icn_new_article'><a href='/BeoordelingAanmakenServlet.do?initLeerling=initLeerling'>Beoordeling aanmaken</a></li>");
			out.println("<li class='icn_view_users'><a href='overzichtgebruikers.jsp'>Beoordelingen bekijken</a></li>");
			out.println("<li class='icn_view_users'><a href='StageOverzicht.jsp'>Stages overzicht</a></li>");
			out.println("<li class='icn_add_user'><a href='Beheerder.jsp'>Beheerders pagina</a></li>");
			out.println("<li class='icn_view_users'><a href='Profiel.jsp'>Profiel gegevens</a></li>");
			out.println("<li class='icn_jump_back'><a href='/LogoutServlet.do'>Loguit</a></li>");
		}
		%>
		
		</ul>

		<footer>
			<hr />
			<p>
				<strong>Accent Nijkerk</strong>
			</p>
			<p>
				Ontwikkeld door &nbsp;<a href="http://www.hu.nl"><img src="http://www.sporttop.nl/111929/HU_Logo.png" width="20" height="15" alt=" "/></a>
			</p>
		</footer>
	</aside>
	<!-- end of sidebar -->
