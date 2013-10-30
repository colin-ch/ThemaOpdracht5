<!doctype html>
<html lang="en">

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

	<header id="header">
		<hgroup>
			<h1 class="site_title"><a href="index.html">Website Admin</a></h1>
			<h2 class="section_title">Dashboard</h2>
		</hgroup>
	</header> <!-- end of header bar -->
	
	<section id="secondary_bar">
		<div class="user">
			<!-- <a class="logout_user" href="#" title="Logout">Logout</a> -->
		</div>
		<div class="breadcrumbs_container">
			<article class="breadcrumbs"><a href="index.html">Website Admin</a> <div class="breadcrumb_divider"></div> <a class="current">Dashboard</a></article>
		</div>
	</section><!-- end of secondary bar -->
	
	<aside id="sidebar" class="column">
		<form class="quick_search">
			<input type="text" value="Zoeken" onfocus="if(!this._haschanged){this.value=''};this._haschanged=true;">
		</form>
		<hr/>
		<h3>Competenties</h3>
		<ul class="toggle">
			<li class="icn_new_article"><a href="#">Nieuwe competentie</a></li>
			<li class="icn_edit_article"><a href="#">Beoordelen</a></li>
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
			<li class="icn_jump_back"><a href="#">Loguit</a></li>
		</ul>
		
		<footer>
			<hr />
			<p><strong>Accent Nijkerk</strong></p>
			<p>Ontwikkeld door &nbsp;<a href="http://www.hu.nl"><img src="http://www.sporttop.nl/111929/HU_Logo.png" width="20px" height="15px"/></a></p>
		</footer>
	</aside><!-- end of sidebar -->
	
	<section id="main" class="column">
		
		<h4 class="alert_info">Welkom, dit is het competentie beoordelings systeem van Accent Nijkerk. Je hebt nog geen afspraken.</h4>
		
		<article class="module width_full">
			<header><h3>Stats</h3></header>
			<div class="module_content">
				<article class="stats_graph">
					<img src="http://chart.apis.google.com/chart?chxr=0,0,3000&chxt=y&chs=520x140&cht=lc&chco=76A4FB,80C65A&chd=s:Tdjpsvyvttmiihgmnrst,OTbdcfhhggcTUTTUadfk&chls=2|2&chma=40,20,20,30" width="520" height="140" alt="" />
				</article>
				
				<article class="stats_overview">
					<div class="overview_today">
						<p class="overview_day">Totale score</p>
						<p class="overview_count">84/100</p>
						<p class="overview_type">Bedrijf</p>
						<p class="overview_count">72/100</p>
						<p class="overview_type">Jijzelf</p>
					</div>
					<div class="overview_previous">
						<p class="overview_day">Gemiddeld</p>
						<p class="overview_count">78/100</p>
						<p class="overview_type">punten</p>
						<p class="overview_count">6</p>
						<p class="overview_type">Te behalen</p>
					</div>
				</article>
				<div class="clear"></div>
			</div>
		</article><!-- end of stats article -->
		
		
		<h4 class="alert_warning">Je hebt 3 afspraken</h4>
		
		<h4 class="alert_error">Er is een veld niet ingevuld</h4>
		
		<h4 class="alert_success">Competentie succesvol beoordeeld</h4>
		
		<article class="module width_full">
			<header><h3>Basic Styles</h3></header>
				<div class="module_content">
					<h1>Header 1</h1>
					<h2>Header 2</h2>
					<h3>Header 3</h3>
					<h4>Header 4</h4>
					<p>Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Cras mattis consectetur purus sit amet fermentum. Maecenas faucibus mollis interdum. Maecenas faucibus mollis interdum. Cras justo odio, dapibus ac facilisis in, egestas eget quam.</p>

<p>Donec id elit non mi porta <a href="#">link text</a> gravida at eget metus. Donec ullamcorper nulla non metus auctor fringilla. Cras mattis consectetur purus sit amet fermentum. Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis vestibulum.</p>

					<ul>
						<li>Donec ullamcorper nulla non metus auctor fringilla. </li>
						<li>Cras mattis consectetur purus sit amet fermentum.</li>
						<li>Donec ullamcorper nulla non metus auctor fringilla. </li>
						<li>Cras mattis consectetur purus sit amet fermentum.</li>
					</ul>
				</div>
		</article><!-- end of styles article -->
		<div class="spacer"></div>
	</section>


</body>

</html>