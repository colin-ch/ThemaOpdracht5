<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8" />
<title>Dashboard I Admin Panel</title>

<link rel="stylesheet" href="css/layout.css" type="text/css"
	media="screen" />
<!-- ALLE IMPORTS VOOR ELKE JSP -->
<!--[if lt IE 9]>
	<link rel="stylesheet" href="css/ie.css" type="text/css" media="screen" />
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
<script src="js/jquery-1.5.2.min.js" type="text/javascript"></script>
<script src="js/hideshow.js" type="text/javascript"></script>
<script src="js/jquery.tablesorter.min.js" type="text/javascript"></script>
<script src="js/add2home.js" type="text/javascript"></script>
<link rel="stylesheet" href="js/add2home.css" type="text/css"
	media="screen"/>
<link rel="apple-touch-icon" href="images/iphonee.png" />
<link rel="apple-touch-icon" sizes="72x72" href="images/ipadd.png" />
<link rel="apple-touch-icon" sizes="114x114" href="images/iphone4.png" />
<script type="text/javascript" src="js/jquery.equalHeight.js"></script>
<script type="text/javascript">
	$(document).ready(function() 
    	{ 
      	  $(".tablesorter").tablesorter(); 
   	 } 
	);
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
    $(function(){
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
				<input list="begeleiders" name="begeleiders" placeholder="email begeleider"><br/>
				<datalist id='begeleiders'>
 <option value='yahoo@gmail.com' label="email"></option> 
 </datalist>

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
