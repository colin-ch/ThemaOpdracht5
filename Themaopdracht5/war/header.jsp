<html>

<head>
	<meta charset="utf-8"/>
	<title>Dashboard I Admin Panel</title>
	
	<link rel="stylesheet" href="css/layout.css" type="text/css" media="screen" />
	<!--[if lt IE 9]>
	<link rel="stylesheet" href="css/ie.css" type="text/css" media="screen" />
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
	<script src="js/jquery-1.5.2.min.js" type="text/javascript"></script>
	<script src="js/hideshow.js" type="text/javascript"></script>
	<script src="js/jquery.tablesorter.min.js" type="text/javascript"></script>
	<script src="js/add2home.js" type="text/javascript"></script>
		<link rel="stylesheet" href="js/add2home.css" type="text/css" media="screen"></link>
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

<header id="header"  style="min-width: 850px;">
		<hgroup>
			<h1 class="site_title" style="min-width: 250px;"><a href="index.html">Website Admin</a></h1>
			<h2 class="section_title" style="min-width: 250px;">Dashboard</h2>
		</hgroup>
	</header> <!-- end of header bar -->
	
	<section id="secondary_bar"  style="min-width: 850px;">
		<div class="user">
			<p>Welkom, Cor Kok</p>
			<!-- <a class="logout_user" href="#" title="Logout">Logout</a> -->
		</div>
		<div class="breadcrumbs_container">
			<article class="breadcrumbs"><a href="index.html">Website Admin</a> <div class="breadcrumb_divider"></div> <a class="current">Dashboard</a></article>
		</div>
	</section><!-- end of secondary bar -->
	
	<div   style="width: 1410px;">
	<aside id="sidebar" class="column" style="min-width: 250px; width: 288px!important; height: 100%!important; min-height: 600px!important;">
		<form class="quick_search">
			<input type="text" value="Zoeken" onfocus="if(!this._haschanged){this.value=''};this._haschanged=true;">
		</form>
		<hr/>
		<h3>Competenties</h3>
		<ul class="toggle">
			<li class="icn_new_article"><a href="#">Nieuwe competentie</a></li>
			<li class="icn_edit_article"><a href="/BeoordeelServlet.do">Beoordelen</a></li>
			<li class="icn_categories"><a href="#">Competenties bekijken</a></li>
			<li class="icn_tags"><a href="/Overzicht.do">Overzicht beoordelingen</a></li>
		</ul>
		<h3>Leerlingen</h3>
		<ul class="toggle">
			<li class="icn_add_user"><a href="#">Leerlingen toevoegen</a></li>
			<li class="icn_view_users"><a href="#">Bekijk leerlingen</a></li>
			<li class="icn_profile"><a href="#">Zoek leerling</a></li>
		</ul>
		
		<h3>Instellingen</h3>
		<ul class="toggle">
			<li class="icn_settings"><a href="#">Opties</a></li>
			<li class="icn_security"><a href="#">Beveiliging</a></li>
			<li class="icn_jump_back"><a href="/LogoutServlet.do">Loguit</a></li>
		</ul>
		
		<footer>
			<hr />
			<p><strong>Accent Nijkerk</strong></p>
			<p>Ontwikkeld door &nbsp;<a href="http://www.hu.nl"><img src="http://www.sporttop.nl/111929/HU_Logo.png" width="20px" height="15px"/></a></p>
		</footer>
	</aside><!-- end of sidebar -->
	

</body>


</html>