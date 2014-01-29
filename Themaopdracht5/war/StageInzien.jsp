<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8" />
<title>Stage inzien</title>
<%@ include file="imports.jsp"%>

</head>

<body>
	<%@ include file="header.jsp"%>
	<section id="main" class="column"
		style="min-width: 1110px; min-height: 600px !important;">

		<% //msgs=request.getAttribute( "msgs"); if (msgs !=null) { out.println(msgs); } %>
		<article class="module width_full">
			<header>
				<h3>Stage inzien</h3>
			</header>
			<div class="module_content">

				

					<%@ page import="java.util.*"%>
					<%@ page import="java.text.*"%>
					<%@ page import="com.appspot.Accent.model.*"%>
					<%@ page import="com.appspot.Accent.model.service.*"%>
					<%
								Object initStage = request.getAttribute( "initStage");
								
							    Object user2 = session.getAttribute("userobject");//haalt huidige ingelogde gebruiker op
                            	StageOfyDAOImpl st = new StageOfyDAOImpl();
                            	ArrayList<Stage> alleStages = (ArrayList<Stage>) st.getAllStages();
                            	LeerlingOfyDAOImpl l = new LeerlingOfyDAOImpl();
                        		DocentOfyDAOImpl d = new DocentOfyDAOImpl();
                        		StageBedrijfOfyDAOImpl sb = new StageBedrijfOfyDAOImpl();
                        		StageBegeleiderOfyDAOImpl sbg = new StageBegeleiderOfyDAOImpl();//Objectify klassen
                        		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                        	%>
                        	
				
							
				<div id="table-div"></div>
			</div>
		</article>
		<!-- end of styles article -->
		<div class="spacer">
		</div>
	</section>
	</div>
</body>

</html>