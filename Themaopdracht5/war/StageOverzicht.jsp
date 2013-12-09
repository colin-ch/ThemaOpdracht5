<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8" />
<title>Dashboard I Admin Panel</title>
<%@ include file="imports.jsp"%>

</head>

<body>
	<%@ include file="header.jsp"%>
	<section id="main" class="column"
		style="min-width: 1110px; min-height: 600px !important;">

		<% //msgs=request.getAttribute( "msgs"); if (msgs !=null) { out.println(msgs); } %>
		<article class="module width_full">
			<header>
				<h3>Overzicht Stages</h3>
			</header>
			<div class="module_content">

				

					<%@ page import="java.util.*"%>
					<%@ page import="com.appspot.Accent.model.*"%>
					<%@ page import="com.appspot.Accent.model.service.*"%>
					<%
								
							    Object user2 = session.getAttribute("userobject");//haalt huidige ingelogde gebruiker op
                            	StageOfyDAOImpl st = new StageOfyDAOImpl();
                            	ArrayList<Stage> alleStages = (ArrayList<Stage>) st.getAllStages();
                            	LeerlingOfyDAOImpl l = new LeerlingOfyDAOImpl();
                        		DocentOfyDAOImpl d = new DocentOfyDAOImpl();
                        		StageBedrijfOfyDAOImpl sb = new StageBedrijfOfyDAOImpl();
                        		StageBegeleiderOfyDAOImpl sbg = new StageBegeleiderOfyDAOImpl();//Objectify klassen
                        	%>
                        		 <script type="text/javascript" src="//www.google.com/jsapi"></script>
    <script type="text/javascript">
      google.load('visualization', '1', {packages: ['table']});
    </script>
    <script type="text/javascript">
    function drawVisualization() {
      // Create and populate the data table.
       var data = google.visualization.arrayToDataTable([
        ['Naam', 'Stage bedrijf', 'Begin datum', 'Eind datum'],
        <% for(Stage stl : alleStages) {
       //	 out.println("['"+stl.getDeLeerling()+"', '"+stl.getHetBedrijf()+"', '"+stl.getDeBegeleider()+"', '"+stl.getBegindatum()+"','"+stl.getEinddatum()+"'],");
       	 out.println("['"+stl.getDeLeerling()+"', '"+stl.getHetBedrijf()+"', '"+stl.getBegindatum()+"','"+stl.getEinddatum()+"'],");
      	 System.out.println("['"+stl.getDeLeerling()+"', '"+stl.getHetBedrijf()+"', '"+stl.getDeBegeleider()+"', '"+stl.getBegindatum()+"','"+stl.getEinddatum()+"'],");
       	   }
        System.out.println("End of Stage loop");
       		      %>
      ]);
    
      // Create and draw the visualization.
      visualization = new google.visualization.Table(document.getElementById('table-div'));
      visualization.draw(data, null);
    }
    

    google.setOnLoadCallback(drawVisualization);
    </script>

					
				
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