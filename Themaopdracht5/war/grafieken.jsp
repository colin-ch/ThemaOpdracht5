<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8" />
<title>Overzicht beoordelingen</title>

<%@ page import="java.util.*"%>
<%@ page import="javax.servlet.ServletContextEvent"%>
<%@ page import="com.appspot.Accent.model.StellingBeoordeeld"%>
<%@ page import="com.appspot.Accent.model.service.StellingBeoordeeldOfyDAOImpl"%>
<%@ page import="com.appspot.Accent.model.service.StageOfyDAOImpl"%>
<%@ page import="com.appspot.Accent.model.service.LeerlingOfyDAOImpl"%>
<%@ page import="com.appspot.Accent.model.Stelling"%>
<%@ page import="com.appspot.Accent.model.service.BeoordelingOfyDAOImpl" %>
<%@ page import="com.appspot.Accent.model.service.StellingOfyDAOImpl" %>
<%@ page import="com.appspot.Accent.model.service.CompetentieOfyDAOImpl" %>
<%@ page import="com.appspot.Accent.model.Stage"%>
<%@ page import="com.appspot.Accent.model.Leerling"%>
<%@ page import="com.appspot.Accent.model.Competentie"%>
<%@ page import="com.googlecode.objectify.Objectify"%>
          <%@ page import="com.googlecode.objectify.ObjectifyService"%>  

<script type="text/javascript" src="https://www.google.com/jsapi"></script>

<script>

      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      //google chart wordt geïnitialiseerd
      
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Beoordeling', 'Stage Opleider', 'Student', {role: 'annotation'}],
      	         
		
       <% 
       	//Hier worden de stellingen opgehaald voor de beoordeling
	      
          Objectify ofy;
		    ofy = ObjectifyService.begin();
		    StellingBeoordeeldOfyDAOImpl sb = new StellingBeoordeeldOfyDAOImpl();
		    LeerlingOfyDAOImpl l = new LeerlingOfyDAOImpl();
		    StageOfyDAOImpl st = new StageOfyDAOImpl();
		    StellingOfyDAOImpl stelling = new StellingOfyDAOImpl();
		    BeoordelingOfyDAOImpl bod = new BeoordelingOfyDAOImpl();
		    CompetentieOfyDAOImpl cod = new CompetentieOfyDAOImpl();
		    
		    
		    
		    for (Leerling le : l.getAllLeerlingen()) { //loop door alle leerlingen
		    	
		    	if (le.getUsername().equals(getServletContext().getAttribute("geselecteerd"))){ //als leerling gelijk is aan de eerder geselecteerde leerling
		    		
		    		for(Stage stage : st.getAllStages()){ //loop door alle stages
		    			
		    			for(Beoordeling beoordeling : bod.getAllBeoordelingen()){
		    				
		    				if(beoordeling.getDatum().equals(getServletContext().getAttribute("datum"))){
		    			
				    			if(stage.getDeLeerling().equals(le.getUsername())){ //zoekt bijbehorende stage
				    				
				    				for (StellingBeoordeeld s : sb.getAllStellingenBeoordeeld()) { //loop door alle stellingenbeoordeeld
				    					
				    					if(s.getDeStage() == stage.getId()){
				    						
				    						for(Stelling stel : stelling.getAllStellingen()){
				    							if(stel.getUniekID() == s.getUniekID()){
		    								
		    										out.println("['"+stel.getDeStelling() +"', " + s.getDeWaardeStagebedrijf() + " , " + s.getDeWaardeLeerling() + "], '"+ s.getDeWaardeLeerling() + "'"); 
		    								
		    									}
		    					
		    								}
				        		      
				         				}
		    				
		    						}
		    					}
		    				}
		    			}
		    		}
		    	}
		    }
		    
         %>  
        ['', 0, 0]
        ]);
        //opties voor de google chart
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
<%@ include file="imports.jsp"%>
</head>


<body>

	<%@ include file="header.jsp"%>

	<section id="main" class="column"
		style="min-width: 1110px; min-height: 600px !important;">
		
		<form action="/Overzicht.do" method="get">
		<select name="select" onchange="this.form.submit()">
	
		<% 
		String geselecteerd = getServletContext().getAttribute("geselecteerd").toString();
		BeoordelingOfyDAOImpl b = new BeoordelingOfyDAOImpl();
		ArrayList < Beoordeling > beoordelingen = (ArrayList < Beoordeling > ) b.getAllBeoordelingen();
		StageOfyDAOImpl s = new StageOfyDAOImpl();
		for(Stage sta : s.getAllStages()){
			if(sta.getDeLeerling().equals(geselecteerd)){
				
				for(Beoordeling be : b.getBeoordelingen(sta.getId())){
					if(be.getDatum().equals(getServletContext().getAttribute("datum"))){
					out.println("<option value='"+ be.getDatum() +"' selected>Stage ID: " + sta.getId() + " - Datum:"   + be.getDatum() + "</option>");
				}
				else{
					out.println("<option value='"+ be.getDatum() +"'>Stage ID: " + sta.getId() + " - Datum:"   + be.getDatum() + "</option>");
				}
				}
				
			}
		}
		
		%>
		
	    </select>
	    <%out.println("<input type='hidden' name='geselecteerde' value='" + geselecteerd +"'/>"); %>
		</form>
		
		<article class="module width_full">
			<header>
				<h3>Home</h3>
			</header>
			<div class="module_content">
				<div id="chart_div" style="width: 80%; height: 700px"></div>
				
				
				
				
				
				<div>
				
				<%
				for (Leerling le : l.getAllLeerlingen()) { //loop door alle leerlingen
			    	
			    	if (le.getUsername().equals(getServletContext().getAttribute("geselecteerd"))){ //als leerling gelijk is aan de eerder geselecteerde leerling
			    		
			    		for(Stage stage : st.getAllStages()){ //loop door alle stages
			    			
			    			if(le.getUsername().equals(stage.getDeLeerling())){
			    			out.println("<div>Stages van deze leerling: " + stage.getId() +   "</div>");
			    			
			    		
			    			for(Beoordeling beoordeling : bod.getBeoordelingen(stage.getId())){ //getAllBeoordelingen() test
			    				
			    				if(beoordeling.getDatum().equals(getServletContext().getAttribute("datum"))){
			    			
					    			for(Integer i : beoordeling.getCompetenties()){
					    				for(Competentie c : cod.getAllCompetenties()){
					    				if(i == c.getEigenId()){
					    					
					    					out.println("<div>Competenties uit deze beoordeling"+ c.getEigenId() + "</div>");
					    					
					    				}
					    				
					    				}
					    			}
			    				}
			    			}
			    			}
			    		}
			    	}
			    }
				
for (Leerling le : l.getAllLeerlingen()) { //loop door alle leerlingen
			    	
			    	if (le.getUsername().equals(getServletContext().getAttribute("geselecteerd"))){ //als leerling gelijk is aan de eerder geselecteerde leerling
			    		
			    		for(Stage stage : st.getAllStages()){ //loop door alle stages
			    			
			    			out.println("<div>Stage: " + stage.getId() +   "</div>");
			    			
			    			for(Beoordeling beoordeling : bod.getBeoordelingen(stage.getId())){ //getAllBeoordelingen() test
			    				
			    				if(beoordeling.getDatum().equals(getServletContext().getAttribute("datum"))){
			    			
					    			if(stage.getDeLeerling().equals(le.getUsername())){ //zoekt bijbehorende stage
					    				
					    				
			    					}
			    				}
			    			}
			    		}
			    	}
			    }
				%>
				
				
				</div>
				
				
				
				
			</div>
		</article>
		<!-- end of styles article -->
		<div class="spacer"></div>
	</section>


</body>

</html>