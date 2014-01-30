<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8" />
<title>Index</title>
<%@ include file="imports.jsp"%>
</head>

<body>
	<%@ include file="header.jsp"%>
	<section id="main" class="column"
		style="min-width: 1110px; min-height: 600px !important;">
		
		
		<% 
		Object msgs=request.getAttribute( "msgs");
		if (msgs !=null) { 
			out.println("<h4 class='alert_success'>"+msgs+"</h4>"); 
			}			
			%>
		<article class="module width_full">
			<header>
				<h3>Home</h3>
			</header>
			<div class="module_content">
				<h1 id="welkom" style="">Welkom <% out.println(naam); %></h1>
				<h3 id="rol"><% out.println("functie: "+ rol); %></h3>
				<h4 id="welkomtekst">Dit is het beoordelings-systeem van Accent Nijkerk. </br> 
									 Aan de linker kant van het scherm vindt u het menu.</br>
				</h4>
			<div id="logo"><img src=http://www.accentnijkerk.nl/images/site9/logo.jpg alt="../images/logo.png"></div>
			</div>
		</article>
		<!-- end of styles article -->
		<div class="spacer"></div>
	</section>
	</div>
</body>

</html>