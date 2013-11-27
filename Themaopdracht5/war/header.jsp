

<header id="header" style="min-width: 850px;">
	<hgroup>
		<h1 class="site_title" style="min-width: 250px;">
			<a href="index.html">Website Admin</a>
		</h1>
		<h2 class="section_title" style="min-width: 250px;">Dashboard</h2>
	</hgroup>
</header>
<!-- end of header bar -->

<section id="secondary_bar" style="min-width: 850px;">
	<div class="user">
		<p>Welkom, Cor Kok</p>
		<!-- <a class="logout_user" href="#" title="Logout">Logout</a> -->
	</div>
	<div class="breadcrumbs_container">
		<article class="breadcrumbs">
			<a href="index.html">Website Admin</a>
			<div class="breadcrumb_divider"></div>
			<a class="current">Dashboard</a>
		</article>
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
			<li class="icn_new_article"><a href="#">Nieuwe competentie
					missing</a></li>
			<li class="icn_edit_article"><a href="/BeoordeelServlet.do">Beoordelen</a></li>
			<li class="icn_categories"><a href="#">Competenties bekijken
					missing</a></li>
			<li class="icn_tags"><a href="/Overzicht.do">Overzicht
					beoordelingen</a></li>
		</ul>
		<h3>Leerlingen</h3>
		<ul class="toggle">
			<li class="icn_add_user"><a href="#">Leerlingen toevoegen
					missing</a></li>
			<li class="icn_view_users"><a href="overzichtgebruikers.jsp">Beoordelingen
					bekijken</a></li>
			<li class="icn_jump_back"><a href="/LogoutServlet.do">Loguit</a></li>
		</ul>


		<footer>
			<hr />
			<p>
				<strong>Accent Nijkerk</strong>
			</p>
			<p>
				Ontwikkeld door &nbsp;<a href="http://www.hu.nl"><img
					src="http://www.sporttop.nl/111929/HU_Logo.png" width="20px"
					height="15px" /></a>
			</p>
		</footer>
	</aside>
	<!-- end of sidebar -->
