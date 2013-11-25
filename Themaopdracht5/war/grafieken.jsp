<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8" />
<title>Dashboard I Admin Panel</title>

<link rel="stylesheet" href="css/layout.css" type="text/css"
	media="screen" />
<!--[if lt IE 9]>
	<link rel="stylesheet" href="css/ie.css" type="text/css" media="screen" />
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
<script src="js/jquery-1.5.2.min.js" type="text/javascript"></script>
<script src="js/hideshow.js" type="text/javascript"></script>
<script src="js/jquery.tablesorter.min.js" type="text/javascript"></script>
<script src="js/add2home.js" type="text/javascript"></script>
<link rel="stylesheet" href="js/add2home.css" type="text/css"
	media="screen"></link>
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
<%@ page import="java.util.*"%>
<%@ page import="javax.servlet.ServletContextEvent"%>
<%@ page import="com.appspot.Accent.model.Stelling"%>
<%@ page import="com.appspot.Accent.model.Competentie"%>

<script type="text/javascript" src="https://www.google.com/jsapi"></script>

<script>
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      
      
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Beoordeling', 'Stage Opleider', 'Student'],
      	         
		
       <% 
       
	      ArrayList<Stelling> alleStellingenLijst1 = (ArrayList<Stelling>) getServletContext().getAttribute("stellingen");
	         
				for (Stelling s : alleStellingenLijst1) {
					
	        		out.println("['"+s.getDeStelling() +"', " + "2" + " , " + s.getDeWaarde() + "],");       
	         	}
		
			
         %>  
        ['2', 2, 2]
        ]);
        
        var options = {
          title: 'Laatste competenties',
          hAxis: {title: 'Score', titleTextStyle: {color: 'green'}},
         
          // Allow multiple simultaneous selections.
          selectionMode: 'multiple',
          colors: ['#BEF781','green']		
        };
        var chart = new google.visualization.BarChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
 </script>

</head>


<body>

	<%@ include file="header.jsp"%>

	<section id="main" class="column"
		style="min-width: 1110px; min-height: 600px !important;">

		<h4 class="alert_info">Welkom, dit is het competentie
			beoordelings systeem van Accent Nijkerk. Je hebt nog geen afspraken.</h4>





		<article class="module width_full">
			<header>
				<h3>Home</h3>
			</header>
			<div class="module_content">
				<div id="chart_div" style="width: 80%; height: 700px"></div>
			</div>
		</article>
		<!-- end of styles article -->
		<div class="spacer"></div>
	</section>

	</div>

</body>

</html>