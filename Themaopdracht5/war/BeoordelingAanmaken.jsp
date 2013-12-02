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
		
	
		  <% 
Object msgs = request.getAttribute("msgs");
if (msgs != null) { 
out.println(msgs);
}
%>
		
		
		
		<article class="module width_full">
			<header><h3>Home</h3></header>
				<div class="module_content">
					<%@ page import="com.appspot.Accent.model.Stage" %>
								<%@ page import="com.appspot.Accent.model.Beoordeling" %>
				
				<%@ page import="com.appspot.Accent.model.Competentie" %>
	<%@ page import="com.appspot.Accent.model.Stelling" %>
	<%@ page import="com.appspot.Accent.model.Leerling" %>
	<%@ page import="java.util.ArrayList" %>
				
				<form action="/BeoordelingAanmakenServlet.do" methode="GET">
				<%
				Object initleerling = request.getAttribute( "initLeerling");
				Object initStage = request.getAttribute( "initStage");
				Object save = request.getAttribute("save");

				if(initleerling != null){
				ArrayList<Leerling> array = (ArrayList<Leerling>) request.getAttribute("studenten"); //alle leerlingen worden opgehaald
				out.println("<input list='leerlingen' name='leerlingen' required>");//lijst van leerlingen wordt aangemaakt
				out.println("<datalist id='leerlingen'>");
				if (array != null) {
					for (int i = 0; i < array.size(); i++) {

						Leerling fluf = array.get(i);
						out.println(" <option value='"+  fluf.getRoepnaam() + " " + fluf.getAchternaam()+  "'/>") ;
					}
					out.println(" </datalist>");
				
					}
				out.println("<input type='submit' value='Verder' name='initStage'/>");
				}
				
				if(initStage != null){
					ArrayList<Stage> array = (ArrayList<Stage>) request.getAttribute("stages"); //alle stages worden opgehaald
					out.println("<input list='stages' name='stages' required>");//lijst van stages wordt aangemaakt
					out.println("<datalist id='stages'>");
					if (array != null) {
						for (int i = 0; i < array.size(); i++) {

							Stage fluf = array.get(i);
							out.println(" <option value='"+  fluf.getId() + "'/>") ;
						}
						out.println(" </datalist>");
							
						}
					out.println("<input type='submit' value='Verder' name='create'/>");
					}
				
				
				if(save != null){
					Leerling student = null;
					Stage stage =(Stage) request.getSession().getAttribute("destage");
					ArrayList<Leerling> array = (ArrayList<Leerling>) request.getAttribute("studenten"); //alle leerlingen worden opgehaald
					
					for(Leerling l: array){
						if(stage.getDeLeerling().equals(l.getUsername())){
							student = l;
						}
					}
					 	 
					out.print("<label class='nameclass'>De Leerling:</label><label class='inputclass'>" + student.getRoepnaam() + " " + student.getAchternaam()+ "</label><br/>"); 
					out.print("<label class='nameclass'>Stage ID:</label><label class='inputclass'>" + stage.getId() +"</label><br/>"); 
					out.print("<label class='nameclass'>Stage bedrijf:</label><label class='inputclass'>" + stage.getHetBedrijf() +"</label><br/>"); 
					out.print("<label class='nameclass'>Stage opleider:</label><label class='inputclass'>" + stage.getDeOpleider() +"</label><br/><br/>"); 
					
					ArrayList<Competentie> competenties = (ArrayList<Competentie>) request.getAttribute("competenties");
					
					for(Competentie c : competenties){
						out.print("<input type='checkbox' name='"+ c.getEigenId() +"' value='"+ c.getEigenId() +"'/><label class='competentieclass'>"+ c.getTitel() +"</label><input type='radio' name='radio"+c.getEigenId()+"' value='1'/><input type='radio' name='radio"+c.getEigenId()+"' value='2'/><input type='radio' name='radio"+c.getEigenId()+"' value='3'/><br/> ");
					}
					out.println("<input type='submit' value='Beoordeling Opslaan' name='save'/>");

					
				}
				
				%>
				
				</form>
			
					</div>
					
					
		</article><!-- end of styles article -->
		<div class="spacer"></div>
	</section>

</div>

</body>

</html>