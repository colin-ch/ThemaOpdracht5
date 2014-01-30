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
          data.addColumn({type:'string', label:'Selecteer een competentie', role: 'annotationText'});
          data.addColumn({type:'string', label:'Selecteer een stage', role: 'annotationText'});
          data.addColumn({type:'string', label:'Selecteer een beoordeling', role: 'annotationText'});
          
                
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
		    			
		    			for(Beoordeling beoordeling : bod.getBeoordelingen(stage.getId())){
		    				
		    				//if(beoordeling.getDatumLeerling().equals(getServletContext().getAttribute("datum"))){
		    			
				    			if(stage.getDeLeerling().equals(le.getUsername())){ //zoekt bijbehorende stage
				    				
				    				for (StellingBeoordeeld s : sb.getAllStellingenBeoordeeld()) { //loop door alle stellingenbeoordeeld
				    					for(int i : beoordeling.getStellingBeoordeeld()){
				    						if(i == s.getUniekID()){
				    					
				    					if(s.getDeStage() == stage.getId()){
				    						if(s.getIDBeoordeling().equals(beoordeling.getIDBeoordeling())){
				    						for(Stelling stel : stelling.getAllStellingen()){
				    							if(stel.getUniekID() == s.getUniekID()){
				    								for(Competentie c : cod.getAllCompetenties()){
				    	        	    				if(stel.getEigenId() == c.getEigenId()){
		    										out.println("['"+stel.getDeStelling() +"', " + s.getDeWaardeStagebedrijf() + " , '" + s.getDeWaardeStagebedrijf() + "'," + s.getDeWaardeLeerling() + ", '"+ s.getDeWaardeLeerling() + "','" + c.getTitel() + "','"+ stage.getId()+"','"+beoordeling.getDatumLeerling()+"'],"); 
				    	        	    				}
				    	        	    				}
		    									}}
		    					
		    								}
				    					}
				         				}
				    					}
		    						}
		    					}
		    				//}
		    			}
		    		}
		    	}
		    }
		    
         %>  
        ['', 0, '' , 0,'', '','','']
        
        ]);
        //opties voor de google chart
        var chart = new google.visualization.ChartWrapper({
        	'chartType' : 'BarChart',
        	'containerId' : 'chart_div',
        'options' : {
          'width':1400, 'chartArea':{left:600,top:10,width:"30%"},
          title: 'Laatste competenties',
          bar: {groupWidth: '70%'},
          hAxis: {title: 'Score', gridlines: {count: 5},  ticks: [0,1,2,3,4], titleTextStyle: {color: '#52A512'}},
          
         
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
        var initStateStage= {selectedValues: []};
        var initStateBeoordeling= {selectedValues: []};
        <%
        for (Leerling le : l.getAllLeerlingen()) { //loop door alle leerlingen
        	
        	if (le.getUsername().equals(getServletContext().getAttribute("geselecteerd"))){ //als leerling gelijk is aan de eerder geselecteerde leerling
        		
        		for(Stage stage : st.getAllStages()){ //loop door alle stages
        			
        			if(le.getUsername().equals(stage.getDeLeerling())){
        				%>
    					initStateStage.selectedValues.push(
    							
    						<% out.println("'"+ stage.getId() +"'"); %>
    						
    					);
    					
    					
    					<%
        			
        		
        			for(Beoordeling beoordeling : bod.getAllBeoordelingen()){ //getAllBeoordelingen() test
        				
        				if(beoordeling.getDatumLeerling().equals(getServletContext().getAttribute("datum"))){
        					%>
        					initStateBeoordeling.selectedValues.push(
        							
        						<% out.println("'"+ beoordeling.getDatumLeerling() +"'"); %>
        						
        					);
        				
        					
        					
        					<%
        				}
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
        %>
        
        
        var compRangeSlider = new google.visualization.ControlWrapper({
            'controlType': 'CategoryFilter',
            'containerId': 'filter_div',
            'options': {
              'filterColumnLabel': 'Selecteer een competentie',
              
              'ui': {
            	  'allowTyping': true,
                  'allowMultiple': true,
                  'selectedValuesLayout': 'belowStacked',
                  'caption' : 'Selecteer competenties'
            	  
              }
            },
            state: initState
          });
        
        var stageRangeSlider = new google.visualization.ControlWrapper({
            'controlType': 'CategoryFilter',
            'containerId': 'filter_div2',
     
            'options': {
              'filterColumnLabel': 'Selecteer een stage',
              
              'ui': {
            	  'selectedValuesLayout': 'belowStacked',
                  'allowTyping': true,
                  'allowMultiple': true,
                  'caption' : 'Selecteer stage'
                }
            },
            state: initStateStage
          });
        
        var BeoordelingRangeSlider = new google.visualization.ControlWrapper({
            'controlType': 'CategoryFilter',
            'containerId': 'filter_div3',
            'options': {
              'filterColumnLabel': 'Selecteer een beoordeling',
              
              'ui': {
                  'labelStacking': 'vertical',
                  'allowTyping': false,
                  'allowMultiple': false,
                  'caption' : 'Selecteer beoordeling'
                }
        
            },
            state: initStateBeoordeling
          });
        

        dashboard.bind([compRangeSlider, stageRangeSlider, BeoordelingRangeSlider],[chart]);
        
        dashboard.draw(data);
      }
 </script>
<%@ include file="imports.jsp"%>
</head>


<body>

	<%@ include file="header.jsp"%>

	<section id="main" class="column"
		style="min-width: 1110px; min-height: 600px !important;">
		
		<form action="/Overzicht.do" method="get" id="form">
		<select name="select" onchange="this.form.submit()" id="select">
	
		<% 
		String geselecteerd = getServletContext().getAttribute("geselecteerd").toString();
		BeoordelingOfyDAOImpl b = new BeoordelingOfyDAOImpl();
		ArrayList < Beoordeling > beoordelingen = (ArrayList < Beoordeling > ) b.getAllBeoordelingen();
		StageOfyDAOImpl s = new StageOfyDAOImpl();
		for (Stage sta: s.getAllStages()) {
		    if (sta.getDeLeerling().equals(geselecteerd)) {

		        for (Beoordeling be: b.getBeoordelingen(sta.getId())) {
		            if (be.getDatumLeerling() != null && be.getDatumBedrijf() != null) {
		                if (be.getDatumLeerling().equals(getServletContext().getAttribute("datum"))) {
		                    out.println("<option value='" + be.getDatumLeerling() + "' selected>Stage ID: " + sta.getId() + " - Datum:" + be.getDatumLeerling() + "</option>");
		                } else {
		                    out.println("<option value='" + be.getDatumLeerling() + "'>Stage ID: " + sta.getId() + " - Datum:" + be.getDatumLeerling() + "</option>");
		                }
		            }
		            else{
		            	out.println("<option disabled>Beoordeling nog niet gedaan door zowel bedrijf als leerling</option>");
		            }

		        }

		    }
		}
		
		%>
		
	    </select>
	    <%out.println("<input type='hidden' name='geselecteerde' value='" + geselecteerd +"'/>"); %>
		</form>
			<script type="text/javascript">	
			$(document).ready(function () {

			    $('#select .niet').each(function () {
			        if ($(this).is(':selected')) {
			            $('#form input[type="submit"]').attr('disabled', 'disabled');
			        }
			        
			    });
			    
			    $('#select .wel').each(function () {
			        if ($(this).is(':selected')) {
			            $('#form input[type="submit"]').removeAttr('disabled');
			        }
			        
			    });
			    
			    });
				</script>
		<article class="module width_full">
			<header>
				<h3>Home</h3>
			</header>
			<div class="module_content">
				
				<% 
				 
				
				  for (Leerling le2: l.getAllLeerlingen()) { //loop door alle leerlingen

				      if (le2.getUsername().equals(getServletContext().getAttribute("geselecteerd"))) { //als leerling gelijk is aan de eerder geselecteerde leerling

				          for (Stage sta: s.getAllStages()) {
				              if (sta.getDeLeerling().equals(geselecteerd)) {

				                  for (Beoordeling be: b.getBeoordelingen(sta.getId())) {
				                	  int StellingBeoordeeldTotaal = 0;
									  int StellingBeoordeeldTotaalLeerling = 0;
									  int StellingBeoordeeldTotaalBedrijf = 0;
									  ArrayList<String> stellingen = new ArrayList<String>();
									
									  
				                      if (be.getDatumLeerling() != null && be.getDatumBedrijf() != null) {

				                          if (be.getDatumLeerling().equals(getServletContext().getAttribute("datum"))) {

				                              out.println("<div class='beoordeling selected'>" + be.getDatumLeerling() + "");
				                          } else {
				                              out.println("<div class='beoordeling'>" + be.getDatumLeerling() + "");
				                          }
				                      } else {
				                          out.println("<div class='beoordeling niet'>Beoordeling nog niet gedaan door zowel bedrijf als leerling");
				                      }
				                      if (sta.getDeLeerling().equals(le2.getUsername())) { //zoekt bijbehorende stage
				                    	  if (be.getDatumLeerling() != null && be.getDatumBedrijf() != null) { 

					                          for (StellingBeoordeeld stelb: sb.getAllStellingenBeoordeeld()) { //loop door alle stellingenbeoordeeld

					                              if (stelb.getDeStage() == sta.getId()) {
					                                  for (Stelling stel: stelling.getAllStellingen()) {
					                                      if (stel.getUniekID() == stelb.getUniekID()) {
					                                          for (Competentie c: cod.getAllCompetenties()) {
					                                              if (stel.getEigenId() == c.getEigenId()) {
					                                            	  if(stelb.getIDBeoordeling().equals(be.getIDBeoordeling())){
					                                            	  stellingen.add(stelb.getDeWaardeLeerling());
					                                                  StellingBeoordeeldTotaalLeerling = StellingBeoordeeldTotaalLeerling + Integer.parseInt(stelb.getDeWaardeLeerling());
					                                                  StellingBeoordeeldTotaalBedrijf = StellingBeoordeeldTotaalBedrijf + Integer.parseInt(stelb.getDeWaardeStagebedrijf());
					                                            	  System.out.println(StellingBeoordeeldTotaalLeerling);
					                                            	  }
					                                              }
					                                          }
					                                      }
	
					                                  }
	
					                              
				                              }

				                          }
				                      }
				                      
				                  StellingBeoordeeldTotaal = StellingBeoordeeldTotaal + StellingBeoordeeldTotaalLeerling + StellingBeoordeeldTotaalBedrijf;  
				                  int GemiddeldBeoordeling = StellingBeoordeeldTotaal / (stellingen.size()*2);
				                  out.println("<h2>Beoordeling totaal:"+ StellingBeoordeeldTotaal +"</h2>");
				                  out.println("<h2> Totaal Bedrijf " +  StellingBeoordeeldTotaalBedrijf +"</h2>");
				                  out.println("<h2>Totaal Leerling " + StellingBeoordeeldTotaalLeerling +"</h2>");
				                  out.println("<h1>Gemiddelde "+ GemiddeldBeoordeling +"</h1>");

								  out.println("</div>");
				                  }
				              }


				          }

				      }
				  }
				  }
				
				%>		
				<br style="clear: both;" />
				
				
				
				
				
			</div>
			
			<div id="dashboard_div" style="width: 90%; height: 700px">
			 <div id="filter_div" class="fd"></div>
			 <div id="filter_div2" class="fd"></div>
			 <div id="filter_div3" class="fd"></div>
			 <br class="clear" />
      <div id="chart_div" class="cd"></div>
			</div>
		</article>
		<!-- end of styles article -->
		<div class="spacer"></div>
	</section>


</body>

</html>