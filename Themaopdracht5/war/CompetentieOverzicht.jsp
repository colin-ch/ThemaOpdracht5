<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<%@ page import="com.appspot.Accent.model.Stage"%>
<%@ page import="com.appspot.Accent.model.Beoordeling"%>
<%@ page import="com.appspot.Accent.model.StageBegeleider"%>
<%@ page import="com.appspot.Accent.model.Competentie"%>
<%@ page import="com.appspot.Accent.model.Stelling"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.googlecode.objectify.Objectify"%>
<%@ page import="com.googlecode.objectify.ObjectifyService"%>
<%@ page import="com.appspot.Accent.model.service.*"%>
<%@ include file="header.jsp"%>
<head>
<%
	Object msgs=request.getAttribute( "msgs"); 
		if (msgs !=null) { 
	out.println("<h2 class='alert_info'>"+msgs+"</h2>"); 
	
		}
%>
<%
	Object o = request.getSession().getAttribute("userobject");
	StellingOfyDAOImpl sod = new StellingOfyDAOImpl();
		ArrayList < Stelling > stellingen = (ArrayList <Stelling> ) sod.getAllStellingen();
		CompetentieOfyDAOImpl cod = new CompetentieOfyDAOImpl();

%>
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
<body>
	
<form action="CompetentieAanpassenServlet.do" method="GET">
<%for(Competentie c : cod.getAllCompetenties()){
			if(c.getEigenId()== 1){
		 		out.println("<input type='text' style='width:500px'name='"+c.getEigenId()+"' value='" + c.getTitel()+" '><br>");
		 		break;
			}
			if(c.getEigenId()==2){
				 out.println("<input type='text'style='width:500px' name='"+c.getEigenId()+"' value='" + c.getTitel()+" '><br>");
				break;
			}
	}%>
			<input type="submit" value="opslaan"><br><br>
</form>

	<form action="StellingAanpassenServlet.do" methode="GET">
		<%
		int iterator=0;
			for (Stelling s : stellingen) {
				
					if (msgs.equals("Samenwerken en overleggen")) {
						if (s.getEigenId() == 1) {
							iterator++;
							out.println(iterator+"." + s.getDeStelling() + "<br> <br>");
							if(o instanceof StageBegeleider){
								
								out.println("<input required style='width:500px'name='"+s.getUniekID()+"' type='text' value='" + s.getDeStelling() + "'/></br></br>");
							}
						}
					}
					if (msgs.equals("Aandacht en begrip tonen")) {
						if (s.getEigenId() == 2) {
							iterator++;
							out.println(iterator+"." + s.getDeStelling() + "<br> <br>");
							if(o instanceof StageBegeleider){
							
							out.println("<input required style='width:500px'name='"+s.getUniekID()+"' type='text' value='" + s.getDeStelling() + "'/></br></br>");
							}
						}
					}

				}
			if(o instanceof StageBegeleider){
		out.println("<input type='submit' value='opslaan'>");
			}
			out.println("<a href='CompetentieSelecteren.jsp'><input type='button' value='terug'></a>");	
		

		%>
	</form>




</body>
</html>