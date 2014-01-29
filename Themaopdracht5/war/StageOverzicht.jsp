<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8" />
<title>Stage overzicht</title>
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
                        	<form action="/BeoordelingAanmakenServlet.do" method="GET">
				<%
                        	if(initStage != null){
					out.println("<h2> selecteer een stage: </h2>");

					ArrayList<Stage> array = (ArrayList<Stage>) request.getAttribute("stages"); //alle stages worden opgehaald
					out.println("<input list='stages' name='stages' required>");//lijst van stages wordt aangemaakt
					out.println("<datalist id='stages'>");
					if (array != null) {
						for (int i = 0; i < array.size(); i++) {

							Stage fluf = array.get(i);
							out.println(" <option value='"+  fluf.getId() + "'>"+ fluf.getId() +"</option>") ;
						}
						out.println(" </datalist>");
							
						}
					out.println("<input type='submit' value='Verder' name='create'/>");
					}%>
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
             	 out.println("['"+stl.getDeLeerling()+"', \""+stl.getHetBedrijf()+"\", '"+simpleDateFormat.format(stl.getBegindatum())+"','"+simpleDateFormat.format(stl.getEinddatum())+"'],");
             }
     
       		      %>
      ]);
       
    
      // Create and draw the visualization.
      visualization = new google.visualization.Table(document.getElementById('table-div'));
     
      function selectHandler(e) {
    	  var selection = visualization.getSelection();
    	  var message = '';
    	 var str = 'niks';
    	  for (var i = 0; i < selection.length; i++) {
    	    var item = selection[i];
    	    if (item.row != null && item.column != null) {
    	       str = data.getFormattedValue(item.row, item.column);
    	      message +=str;
    	    } else if (item.row != null) {
    	      str = data.getFormattedValue(item.row, 0);
    	      message +=str;
    	    } else if (item.column != null) {
    	       str = data.getFormattedValue(0, item.column);
    	      message += str;
    	    }
    	  }
    	  if (message == 'niks') {
    	    message = 'nothing';
    	  }
    	  
    	 window.location.href = 'http://localhost:8888/StageInzien.do?string='+str;
    	 
       }
      google.visualization.events.addListener(visualization, 'select', selectHandler);
      visualization.draw(data, null);
    

    }
    	 
       
   
    
    google.setOnLoadCallback(drawVisualization);
    
</script>
				<div id="table-div">
				</div>
			</div>
		</article>
		<!-- end of styles article -->
		<div class="spacer">
		</div>
	</section>
	</div>
</body>

</html>