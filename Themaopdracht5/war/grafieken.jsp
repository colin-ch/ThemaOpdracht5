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

<script type="text/javascript">

      google.load("visualization", "1.0", {packages:["controls"]});
      google.setOnLoadCallback(drawDashboard);
      //google chart wordt geïnitialiseerd
      
      
      function drawDashboard() {
        var data = new google.visualization.DataTable();
          data.addColumn('string', 'Beoordeling');
          data.addColumn('number', 'Stage Opleider');
          data.addColumn({type:'string', role: 'annotation'});
          data.addColumn('number', 'Student');
          data.addColumn({type:'string', role: 'annotation'});
          data.addColumn({type:'string', label:'competentiestelling', role: 'annotationText'});
          
                
		  data.addRows([
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
		    				
		    				if(beoordeling.getDatumLeerling().equals(getServletContext().getAttribute("datum"))){
		    			
				    			if(stage.getDeLeerling().equals(le.getUsername())){ //zoekt bijbehorende stage
				    				
				    				for (StellingBeoordeeld s : sb.getAllStellingenBeoordeeld()) { //loop door alle stellingenbeoordeeld
				    					
				    					if(s.getDeStage() == stage.getId()){
				    						
				    						for(Stelling stel : stelling.getAllStellingen()){
				    							if(stel.getUniekID() == s.getUniekID()){
				    								for(Competentie c : cod.getAllCompetenties()){
				    	        	    				if(stel.getEigenId() == c.getEigenId()){
		    										out.println("['"+stel.getDeStelling() +"', " + s.getDeWaardeStagebedrijf() + " , '" + s.getDeWaardeStagebedrijf() + "'," + s.getDeWaardeLeerling() + ", '"+ s.getDeWaardeLeerling() + "','" + c.getTitel() + "'],"); 
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
		    	}
		    }
		    
         %>  
        ['', 0, '' , 0,'', '']
        
        ]);
        //opties voor de google chart
        var chart = new google.visualization.ChartWrapper({
        	'chartType' : 'BarChart',
        	'containerId' : 'chart_div',
        'options' : {
          'width':1400, 'chartArea':{left:600,top:10,width:"30%"},
          title: 'Laatste competenties',
          bar: {groupWidth: '100%'},
          hAxis: {title: 'Score', titleTextStyle: {color: '#52A512'}},
          
         
          // Allow multiple simultaneous selections.
          selectionMode: 'multiple',
          colors: ['#BEF781','#52A512']		
        }
        });
        
        
        var dashboard = new google.visualization.Dashboard(
                document.getElementById('dashboard_div'));
        google.visualization.events.addListener(dashboard, 'ready', function() {
        	  // Dashboard redraw, have a look at how many rows the barChart is displaying
        	  var numRows = chart.getDataTable().getNumberOfRows();
        	  var expectedHeight = numRows * 60;
        	  if (parseInt(chart.getOption('height'), 10) != expectedHeight) {
        	    // Update the chart options and redraw just it
        	    chart.setOption('height', expectedHeight);
        	    chart.draw();
        	  }
        	});
        
        var initState= {selectedValues: []};
        <%
        for (Leerling le : l.getAllLeerlingen()) { //loop door alle leerlingen
        	
        	if (le.getUsername().equals(getServletContext().getAttribute("geselecteerd"))){ //als leerling gelijk is aan de eerder geselecteerde leerling
        		
        		for(Stage stage : st.getAllStages()){ //loop door alle stages
        			
        			if(le.getUsername().equals(stage.getDeLeerling())){
        			
        			
        		
        			for(Beoordeling beoordeling : bod.getBeoordelingen(stage.getId())){ //getAllBeoordelingen() test
        				
        				if(beoordeling.getDatumLeerling().equals(getServletContext().getAttribute("datum"))){
        			
        	    			for(Integer i : beoordeling.getCompetenties()){
        	    				for(Competentie c : cod.getAllCompetenties()){
        	    				if(i == c.getEigenId()){
        	    					%>
        	    					initState.selectedValues.push(
        	    							
        	    						<% out.println("'"+ c.getTitel() +"'"); %>
        	    						
        	    					);
        	    					
        	    					
        	    					<%
        	    					
        	    					
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
        
        
        var donutRangeSlider = new google.visualization.ControlWrapper({
            'controlType': 'CategoryFilter',
            'containerId': 'filter_div',
            'options': {
              'filterColumnLabel': 'competentiestelling',
              'ui': {
            	  'allowTyping': true,
                  'allowMultiple': true,
                  'selectedValuesLayout': 'belowStacked'
            	  
              }
            },
            state: initState
          });
        

        dashboard.bind(donutRangeSlider, chart);
        
        dashboard.draw(data);
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
					if(be.getDatumLeerling().equals(getServletContext().getAttribute("datum"))){
					out.println("<option value='"+ be.getDatumLeerling() +"' selected>Stage ID: " + sta.getId() + " - Datum:"   + be.getDatumLeerling() + "</option>");
				}
				else{
					out.println("<option value='"+ be.getDatumLeerling() +"'>Stage ID: " + sta.getId() + " - Datum:"   + be.getDatumLeerling() + "</option>");
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
				
				
				
				
				
				
				<div>
				<script>
				<%
				
				for (Leerling le : l.getAllLeerlingen()) { //loop door alle leerlingen
			    	
			    	if (le.getUsername().equals(getServletContext().getAttribute("geselecteerd"))){ //als leerling gelijk is aan de eerder geselecteerde leerling
			    		
			    		for(Stage stage : st.getAllStages()){ //loop door alle stages
			    			
			    			if(le.getUsername().equals(stage.getDeLeerling())){
			    			out.println("<div>Stages van deze leerling: " + stage.getId() +   "</div>");
			    			
			    		
			    			for(Beoordeling beoordeling : bod.getBeoordelingen(stage.getId())){ //getAllBeoordelingen() test
			    				
			    				if(beoordeling.getDatumLeerling().equals(getServletContext().getAttribute("datum"))){
			    			
					    			for(Integer i : beoordeling.getCompetenties()){
					    				for(Competentie c : cod.getAllCompetenties()){
					    				if(i == c.getEigenId()){
					    					
					    					out.println("<div><h3>Competenties uit deze beoordeling: "+ c.getTitel() + "</h3></div>");
					    					
					    				}
					    				
					    				}
					    			}
			    				}
			    			}
			    			}
			    		}
			    	}
			    }%>
				</script><%
for (Leerling le : l.getAllLeerlingen()) { //loop door alle leerlingen
			    	
			    	if (le.getUsername().equals(getServletContext().getAttribute("geselecteerd"))){ //als leerling gelijk is aan de eerder geselecteerde leerling
			    		
			    		for(Stage stage : st.getAllStages()){ //loop door alle stages
			    			
			    			
			    			
			    			for(Beoordeling beoordeling : bod.getBeoordelingen(stage.getId())){ //getAllBeoordelingen() test
			    				
			    				if(beoordeling.getDatumLeerling().equals(getServletContext().getAttribute("datum"))){
			    			
					    			if(stage.getDeLeerling().equals(le.getUsername())){ //zoekt bijbehorende stage
					    				out.println("<div>Stage: " + stage.getId() +   "</div>");
					    				
			    					}
			    				}
			    			}
			    		}
			    	}
			    }
				%>
				
				
				</div>
				
				
				
				
			</div>
			
			<div id="dashboard_div" style="width: 90%; height: 700px">
			 <div id="filter_div"></div>
      <div id="chart_div"style="width: 100%; height: 100%"></div>
			</div>
		</article>
		<!-- end of styles article -->
		<div class="spacer"></div>
	</section>


</body>

</html>