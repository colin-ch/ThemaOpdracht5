<!doctype html>
<html>
<head>


<title>Competenties</title>

<link rel="stylesheet" href="css/layout.css" type="text/css"
	media="screen" />
<!--[if lt IE 9]>
	<link rel="stylesheet" href="css/ie.css" type="text/css" media="screen" />
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
<script src="js/jquery-1.5.2.min.js" type="text/javascript"></script>
<script src="js/hideshow.js" type="text/javascript"></script>
<script src="js/jquery.tablesorter.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.equalHeight.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".tablesorter").tablesorter();
	});
	$(document).ready(function() {

		//When page loads...
		$(".tab_content").hide(); //Hide all content
		$("ul.tabs li:first").addClass("active").show(); //Activate first tab
		$(".tab_content:first").show(); //Show first tab content

		//On Click Event
		$("ul.tabs li").click(function() {

			$("ul.tabs li").removeClass("active"); //Remove any "active" class
			$(this).addClass("active"); //Add "active" class to selected tab
			$(".tab_content").hide(); //Hide all tab content

			var activeTab = $(this).find("a").attr("href"); //Find the href attribute value to identify the active tab + content
			$(activeTab).fadeIn(); //Fade in the active ID content
			return false;
		});

	});
</script>
<script type="text/javascript">
	$(function() {
		$('.column').equalHeight();
	});
</script>
</head>
<body>









<header id="header" style="min-width: 850px;">
	
</header>
<!-- end of header bar -->

<section id="secondary_bar" style="min-width: 850px;">
	<div class="user">
	
	<p>leerling1 Student</p>

		<!-- <a class="logout_user" href="#" title="Logout">Logout</a> -->
	</div>
	
</section>
<!-- end of secondary bar -->

<div style="width: 1410px;">
	<aside id="sidebar" class="column"
		style="min-width: 250px; width: 288px !important; height: 100% !important; min-height: 600px !important;">
		<form class="quick_search">
			<input type="text" value="Zoeken"
				onfocus="if(!this._haschanged){this.value=''};this._haschanged=true;">
		</form>
		<hr />
		<h3>Competenties</h3>
		<ul class="toggle">
			<li class="icn_new_article"><a href="/BeoordelingAanmakenServlet.do?initLeerling=initLeerling">Nieuwe competentie
					missing</a></li>
			<li class="icn_edit_article"><a href="/BeoordeelServlet.do">Beoordelen</a></li>
			<li class="icn_categories"><a href="CompetentieSelecteren.jsp">Competenties bekijken
					</a></li>
			
		</ul>
		<h3>Stages</h3>
		<ul class="toggle">
			<li class="icn_view_users"><a href="StageOverzicht.jsp">Stages overzicht</a></li>
		</ul>
		<h3>Leerlingen</h3>
		<ul class="toggle">
			<li class="icn_add_user"><a href="Beheerder.jsp">Beheerders pagina</a></li>
			<li class="icn_view_users"><a href="overzichtgebruikers.jsp">Beoordelingen bekijken</a></li>
			<li class="icn_view_users"><a href="Profiel.jsp">Profiel gegevens</a></li>
			<li class="icn_jump_back"><a href="/LogoutServlet.do">Loguit</a></li>
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
<%@ page import="com.appspot.Accent.model.Stage"%>
<%@ page import="com.appspot.Accent.model.Beoordeling"%>
<%@ page import="com.appspot.Accent.model.StageBegeleider"%>
<%@ page import="com.appspot.Accent.model.Competentie"%>
<%@ page import="com.appspot.Accent.model.Stelling"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.googlecode.objectify.Objectify"%>
<%@ page import="com.googlecode.objectify.ObjectifyService"%>
<%@ page import="com.appspot.Accent.model.service.*"%>

<%




CompetentieOfyDAOImpl cod = new CompetentieOfyDAOImpl();
ArrayList<Competentie> comps = (ArrayList<Competentie>) cod.getAllCompetenties();
%>

	<h2>Kies een Competentie</h2>
	<form action="CompetentieOverzichtServlet.do" method="GET">
		<select name='competentie'>
		<%
		int iterator = 0;
		for(Competentie c : comps){
			iterator++;
			out.println("<option  value='"+ c.getEigenId() +"'>" + c.getTitel() +"</option>");
		}
		
		%>
		</select>

		<br /> <input type='submit' value='overzicht'>
	</form>
	
</div>
	




</body>
</html>
