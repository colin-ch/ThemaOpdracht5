<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8" />
<title>Overzicht competenties stagebedrijven</title>

<%@ page import="java.util.*"%>
<%@ page import="javax.servlet.ServletContextEvent"%>
<%@ page import="com.appspot.Accent.model.*"%>
<%@ page import="com.appspot.Accent.model.service.*"%>
<%@ page import="com.appspot.Accent.model.service.StageOfyDAOImpl"%>

<%@ page import="com.googlecode.objectify.Objectify"%>
          <%@ page import="com.googlecode.objectify.ObjectifyService"%>  

<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">

      google.load("visualization", "1.0", {packages:["controls"]});
      google.setOnLoadCallback(drawDashboard);
      //google chart wordt ge�nitialiseerd
      
      
      function drawDashboard() {
        var data = new google.visualization.DataTable();
          data.addColumn('string', 'Stage bedrijf');
          data.addColumn('number', 'Gemiddelde competentie1');
          data.addColumn('number', 'Gemiddelde competentie2');
          data.addColumn('number', 'Gemiddelde competentie3');
          data.addColumn('number', 'Gemiddelde competentie4');
          data.addColumn('number', 'Gemiddelde competentie5');
          data.addColumn('number', 'Gemiddelde competentie6');
          data.addColumn('number', 'Gemiddelde competentie7');
          data.addColumn('number', 'Gemiddelde competentie8');
          data.addColumn('number', 'Gemiddelde competentie9');
          data.addColumn('number', 'Gemiddelde competentie10');
          
                
		  data.addRows([
       <% 
	      
          Objectify ofy;
		    ofy = ObjectifyService.begin();
		    StellingBeoordeeldOfyDAOImpl sb = new StellingBeoordeeldOfyDAOImpl();
		    LeerlingOfyDAOImpl l = new LeerlingOfyDAOImpl();
		    StageOfyDAOImpl st = new StageOfyDAOImpl();
		    StellingOfyDAOImpl stelling = new StellingOfyDAOImpl();
		    BeoordelingOfyDAOImpl bod = new BeoordelingOfyDAOImpl();
		    CompetentieOfyDAOImpl cod = new CompetentieOfyDAOImpl();
		    StageBedrijfOfyDAOImpl sbod = new StageBedrijfOfyDAOImpl();
		  
		    
		    for (StageBedrijf sbe : sbod.getAllStageBedrijven()) {
		    	int competentie1 = 0;
			    int competentie2 = 0;
			    int competentie3 = 0;
			    int competentie4 = 0;
			    int competentie5 = 0;
			    int competentie6 = 0;
			    int competentie7 = 0;
			    int competentie8 = 0;
			    int competentie9 = 0;
			    int competentie10 = 0;
			    
			    int teller1 = 0;
			    int teller2 = 0;
			    int teller3 = 0;
			    int teller4 = 0;
			    int teller5 = 0;
			    int teller6 = 0;
			    int teller7 = 0;
			    int teller8 = 0;
			    int teller9 = 0;
			    int teller10 = 0;
	    	
	    		for(Stage stage : st.getAllStages()){ //loop door alle stages
	    			if(sbe.getUsername().equals(stage.getHetBedrijf())){
	    				for (StellingBeoordeeld s : sb.getAllStellingenBeoordeeld()) {
	    					if(s.getDeStage() == stage.getId()){
	    						for(Stelling ste : stelling.getAllStellingen()){
	    							if(s.getUniekID() == ste.getUniekID()){
	    								for(Competentie co : cod.getAllCompetenties()){
	    									if(ste.getEigenId() == co.getEigenId()){
	    										int i = Integer.parseInt(s.getDeWaardeStagebedrijf());
	    										if(co.getEigenId() == 1){
	    											competentie1 =+ i;
	    											teller1++;
	    										}
	    										if(co.getEigenId() == 2){
	    											competentie2 =+ i;
	    											teller2++;
	    										}
	    										if(co.getEigenId() == 3){
	    											competentie3 =+ i;
	    											teller3++;
	    										}
	    										if(co.getEigenId() == 4){
	    											competentie4 =+ i;
	    											teller4++;
	    										}
	    										if(co.getEigenId() == 5){
	    											competentie5 =+ i;
	    											teller5++;
	    										}
	    										if(co.getEigenId() == 6){
	    											competentie6 =+ i;
	    											teller6++;
	    										}
	    										if(co.getEigenId() == 7){
	    											competentie7 =+ i;
	    											teller7++;
	    										}
	    										if(co.getEigenId() == 8){
	    											competentie8 =+ i;
	    											teller8++;
	    										}
	    										if(co.getEigenId() == 9){
	    											competentie9 =+ i;
	    											teller9++;
	    										}
	    										if(co.getEigenId() == 10){
	    											competentie10 =+ i;
	    											teller10++;
	    										}
	    									}
	    								}
	    							}
	    						}
	    					}
	    				}
	    			}
    			}
	    		int gemiddelde1 = 0;
	    		int gemiddelde2 = 0;
	    		int gemiddelde3 = 0;
	    		int gemiddelde4 = 0;
	    		int gemiddelde5 = 0;
	    		int gemiddelde6 = 0;
	    		int gemiddelde7 = 0;
	    		int gemiddelde8 = 0;
	    		int gemiddelde9 = 0;
	    		int gemiddelde10 = 0;
	    		
	    		if(teller1 == 0){}
	    		else{
	    			gemiddelde1 = competentie1/teller1;
	    		}
	    		if(teller2 == 0){}
	    		else{
	    			gemiddelde2 = competentie2/teller2;
	    		}
	    		if(teller2 == 0){}
	    		else{
	    			gemiddelde2 = competentie2/teller2;
	    		}
	    		if(teller3 == 0){}
	    		else{
	    			gemiddelde3 = competentie3/teller3;
	    		}
	    		if(teller4 == 0){}
	    		else{
	    			gemiddelde4 = competentie4/teller4;
	    		}
	    		if(teller5 == 0){}
	    		else{
	    			gemiddelde5 = competentie5/teller5;
	    		}
	    		if(teller6 == 0){}
	    		else{
	    			gemiddelde6 = competentie1/teller6;
	    		}
	    		if(teller7 == 0){}
	    		else{
	    			gemiddelde7 = competentie1/teller7;
	    		}
	    		if(teller8 == 0){}
	    		else{
	    			gemiddelde8 = competentie8/teller8;
	    		}
	    		if(teller9 == 0){}
	    		else{
	    			gemiddelde9 = competentie9/teller9;
	    		}
	    		if(teller10 == 0){}
	    		else{
	    			gemiddelde10 = competentie10/teller10;
	    		}
	    		
	    		out.println("['"+sbe.getUsername()+"', "+gemiddelde1+", "+gemiddelde2+", "+gemiddelde3+", "+gemiddelde4+", "+gemiddelde5+", "+gemiddelde6+", "+gemiddelde7+", "+gemiddelde8+", "+gemiddelde9+", "+gemiddelde10+"],");

	    		out.println();
	    		
	    		
    		}
	    
		    
         %>  
        ['', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        
        ]);
        //opties voor de google chart
        var chart = new google.visualization.ChartWrapper({
        	'chartType' : 'BarChart',
        	'containerId' : 'chart1',
          'options': {
            'filterColumnLabel': 'Stagebedrijven',
            'ui': {
            'labelStacking': 'vertical',
              'allowTyping': true,
              'allowMultiple': false
            }
          }
        });
        
        var categoryPicker = new google.visualization.ControlWrapper({
          'controlType': 'CategoryFilter',
          'containerId': 'control1',
          'options': {
            'filterColumnLabel': 'Stage bedrijf',
            'ui': {
            'labelStacking': 'vertical',
              'allowTyping': true,
              'allowMultiple': false
            }
          }
        });
        new google.visualization.Dashboard(document.getElementById('dashboard')).bind([categoryPicker], [chart]).draw(data);
      }
        </script>
        </head>
        <div id="dashboard"></div>
        <div id="control1"></div>
        </html>