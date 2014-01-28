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


<%
	Object o = request.getSession().getAttribute("userobject");
	StellingOfyDAOImpl sod = new StellingOfyDAOImpl();
	ArrayList<Stelling> stellingen = (ArrayList<Stelling>) sod
			.getAllStellingen();
	CompetentieOfyDAOImpl cod = new CompetentieOfyDAOImpl();
	ArrayList<Competentie> competenties = (ArrayList<Competentie>) cod
			.getAllCompetenties();
%>
<title>Competenties</title>
<%@ include file="imports.jsp"%>
</head>
<body>
	<%@ include file="header.jsp"%>

	<section id="main" class="column"
		style="min-width: 1110px; min-height: 600px !important;"> <article
		class="module width_full"> <header>
	<h3>Competentie Overzicht</h3>
	</header>
	<div class="module_content">
		<%
			Object msgs = request.getAttribute("msgs");
			if (msgs != null) {
				out.println("<h2 class='alert_info'>" + msgs + "</h2>");

				Object competentie = request.getAttribute("competentie");

			}
		%>


		<form action="StellingAanpassenServlet.do" method="GET">
			<%
				int iterator = 0;
				String eigenId = null;
				
				boolean b = false;
				for (Competentie c : competenties) {
					for (Stelling s : stellingen) {
						String stellingId = Integer.toString(s.getEigenId());
						
						if (b == false) {
							if (msgs.equals(c.getTitel())) {
								Competentie comp = c;
								eigenId = Integer.toString(c.getEigenId());
								
								b = true;
							}
						}
						if (stellingId.equals(eigenId) && msgs.equals(c.getTitel()) ) {
						
							iterator++;
							out.println(iterator + "." + s.getDeStelling()
									+ "<br> <br>");
							if (o instanceof User) {

								out.println("<input required style='width:500px'name='"
										+ s.getUniekID()
										+ "' type='text' value='"
										+ s.getDeStelling() + "'/></br></br>");
							}
						}

					}
				}
				if (o instanceof User) {
					out.println("<input type='submit' value='opslaan'>");
				}
				out.println("<a href='CompetentieSelecteren.jsp'><input type='button' value='terug'></a>");
			%>
		</form>
	</div>

	</div>


	</article> <!-- end of styles article -->
	<div class="spacer"></div>
	</section>
</body>
</html>