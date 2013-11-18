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

	<%@ include file="header.jsp"%>
	
	<section id="main" class="column"   style="min-width: 1110px; min-height: 600px!important;">
		
		<h4 class="alert_info">Welkom, dit is het competentie beoordelings systeem van Accent Nijkerk. Je hebt nog geen afspraken.</h4>
		
		
		
		
		
		<article class="module width_full">
			<header><h3>Home</h3></header>
				<div class="module_content">
					<%@ page import="com.appspot.Accent.model.Stage" %>
								<%@ page import="com.appspot.Accent.model.Beoordeling" %>
				
				<%@ page import="com.appspot.Accent.model.Competentie" %>
	<%@ page import="com.appspot.Accent.model.Stelling" %>
	<%@ page import="java.util.ArrayList" %>
				
				<form action="/BeoordeelServlet.do" methode="GET">
				<%
				
				Stage s= (Stage) request.getAttribute("stage");	

					ArrayList<Beoordeling> beoordelingen = s.getBeoordelingen();

					
					
					
					
		for(Beoordeling be : beoordelingen){
			
		/*	if(be.getDatum() == null){
			ArrayList<Integer> competenties = be.getCompetenties();
				int teller = 0;
				for(Competentie c : competenties){
					ArrayList<Stelling> stellingen = new ArrayList<Stelling>();
					stellingen = c.getDeStellingen();
					System.out.println("test");
					out.println("</br><h2>"+  c.getTitel() +"</h2></br>");
					
					for(Stelling stel : stellingen){
						System.out.println("stelling");

						teller++;
						out.println("<h4>" + stel.getDeStelling() + "</h4>");
						out.println("1<input type='radio' name='waarde"+ teller+ "' value='1'>2<input type='radio' name='waarde"+ teller+ "' value='2'>3<input type='radio' name='waarde"+ teller+ "' value='3'>4<input type='radio' name='waarde"+ teller+ "' value='4'></br>");
					}
					}
				}*/
		}
		out.println("eventuele Opmerkingen:<input type='text' name='opmerking' value=''> ");
		
				%>
				
				<input type="submit" value="Opslaan" name="Opslaan"/>
				</form>
				<% 
				Object msgs = request.getAttribute("msgs");
				if (msgs != null) { 
				out.println(msgs);
				}
				%>
					</div>
					
					
		</article><!-- end of styles article -->
		<div class="spacer"></div>
	</section>

</div>

</body>

</html>