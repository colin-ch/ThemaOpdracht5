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

<%
	Object msgs=request.getAttribute( "msgs"); 
		if (msgs !=null) { 
	out.println("<h2 class='alert_info'>"+msgs+"</h2>"); 
	
	Object competentie =request.getAttribute("competentie");
	
		}
%>
<%
	Object o = request.getSession().getAttribute("userobject");
	StellingOfyDAOImpl sod = new StellingOfyDAOImpl();
	ArrayList < Stelling > stellingen = (ArrayList <Stelling> ) sod.getAllStellingen();
	CompetentieOfyDAOImpl cod = new CompetentieOfyDAOImpl();

%>
<title>Competenties</title>
<%@ include file="imports.jsp"%>
</head>
<body>
	
<form action="CompetentieAanpassenServlet.do" method="GET">

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