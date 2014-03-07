<!doctype html>
<html lang="en">

<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8" />
<title>KPI Accent Nijkerk</title>
<%@ include file="imports.jsp"%>

<%@ page import="java.util.*"%>
<%@ page import="javax.servlet.ServletContextEvent"%>
<%@ page import="com.appspot.Accent.model.*"%>
<%@ page import="com.appspot.Accent.model.service.*"%>
<%@ page import="com.appspot.Accent.model.service.StageOfyDAOImpl"%>

<%@ page import="com.googlecode.objectify.Objectify"%>
          <%@ page import="com.googlecode.objectify.ObjectifyService"%>  

<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
<% String selectie = "all";
 if(request.getAttribute("competentie") != null){
   selectie = ""+ request.getAttribute("competentie");
     }
 %>

      google.load("visualization", "1.0", {packages:["controls"]});
      google.setOnLoadCallback(drawDashboard);
      
      
      function drawDashboard() {
        var data = new google.visualization.DataTable();
          data.addColumn('string', 'Stage bedrijf');
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
		    ArrayList<Competentie>competenties = new ArrayList<Competentie>();
		    for(Competentie c : cod.getAllCompetenties()){
		    	competenties.add(c);
		    }
		    
		    for(Competentie co : competenties){
		    	out.println("data.addColumn('"+co.getTitel()+"' + 'number');");
		    }
          %>
                
		  data.addRows([
       <% 	  
		    
       	
		    for (StageBedrijf sbe : sbod.getAllStageBedrijven()) {
		    	
		    	String titel1 = "";
		    	String titel2 = "";
		    	String titel3 = "";
		    	String titel4 = "";
		    	String titel5 = "";
		    	String titel6 = "";
		    	String titel7 = "";
		    	String titel8 = "";
		    	String titel9 = "";
		    	String titel10 = "";
		    	
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
	    	
			    /*Loop voor alle waardes
			   for(Stage stage : st.getAllStages()){ 
				   
			   }
				   */
			  
			    
	    		for(Stage stage : st.getAllStages()){ //loop door alle stages
	    				for (StellingBeoordeeld s : sb.getAllStellingenBeoordeeld()) {
	    					if(s.getDeStage() == stage.getId()){
	    						for(Stelling ste : stelling.getAllStellingen()){
	    							if(s.getUniekID() == ste.getUniekID()){
	    								for(Competentie co : competenties){
	    									if(ste.getEigenId() == co.getEigenId()){
	    										int i = 0;
	    										if(s.getDeWaardeStagebedrijf() != null){
	    											i = Integer.parseInt(s.getDeWaardeStagebedrijf());
	    										}
	    										if(co.getEigenId() == 1){
	    											competentie1 = competentie1 + i;
	    											titel1 = co.getTitel();
	    											teller1++;
	    										}
	    										if(co.getEigenId() == 2){
	    											competentie2 = competentie2 + i;
	    											titel2 = co.getTitel();
	    											teller2++;
	    											
	    										}
	    										if(co.getEigenId() == 3){
	    											competentie3 = competentie3 + i;
	    											titel3 = co.getTitel();
	    											teller3++;
	    										}

	    										if(co.getEigenId() == 4){
	    											competentie4 = competentie4 + i;
	    											titel4 = co.getTitel();
	    											teller4++;
	    										}
	    										if(co.getEigenId() == 5){
	    											competentie5 = competentie5 + i;
	    											titel5 = co.getTitel();
	    											teller5++;
	    										}
	    										if(co.getEigenId() == 6){
	    											competentie6 = competentie6 + i;
	    											titel6 = co.getTitel();
	    											teller6++;
	    										}
	    										if(co.getEigenId() == 7){
	    											competentie7 = competentie7 + i;
	    											titel7 = co.getTitel();
	    											teller7++;
	    										}
	    										if(co.getEigenId() == 8){
	    											competentie8 = competentie8 + i;
	    											titel8 = co.getTitel();
	    											teller8++;
	    										}
	    										if(co.getEigenId() == 9){
	    											competentie9 = competentie9 + i;
	    											titel9 = co.getTitel();
	    											teller9++;
	    										}
	    										if(co.getEigenId() == 10){
	    											competentie10 = competentie10 + i;
	    											titel10 = co.getTitel();
	    											teller10++;
	    										}
	    									}
	    								}
	    							}
	    						}
	    					}
	    				}
	    			}
		   		
	    		int gemiddelde1 = 3;
	    		int gemiddelde2 = 2;
	    		int gemiddelde3 = 4;
	    		int gemiddelde4 = 1;
	    		int gemiddelde5 = 2;
	    		int gemiddelde6 = 4;
	    		int gemiddelde7 = 2;
	    		int gemiddelde8 = 3;
	    		int gemiddelde9 = 1;
	    		int gemiddelde10 = 4;
	    		
	    		if(teller1 == 0){
	    			gemiddelde1 = 0;
	    		}
	    		else{
	    			gemiddelde1 = competentie1/teller1;
	    		}
	    		if(teller2 == 0){
	    			gemiddelde2 = 0;
	    		}
	    		else{
	    			gemiddelde2 = competentie2/teller2;
	    		}
	    		if(teller3 == 0){
	    			gemiddelde3 = 0;
	    		}
	    		else{
	    			gemiddelde3 = competentie3/teller3;
	    		}
	    		if(teller4 == 0){
	    			gemiddelde4 = 0;
	    		}
	    		else{
	    			gemiddelde4 = competentie4/teller4;
	    		}
	    		if(teller5 == 0){
	    			gemiddelde5 = 0;
	    		}
	    		else{
	    			gemiddelde5 = competentie5/teller5;
	    		}
	    		if(teller6 == 0){
	    			gemiddelde6 = 0;
	    		}
	    		else{
	    			gemiddelde6 = competentie6/teller6;
	    		}
	    		if(teller7 == 0){
	    			gemiddelde7 = 0;
	    		}
	    		else{
	    			gemiddelde7 = competentie7/teller7;
	    		}
	    		if(teller8 == 0){
	    			gemiddelde8 = 0;
	    		}
	    		else{
	    			gemiddelde8 = competentie8/teller8;
	    		}
	    		if(teller9 == 0){
	    			gemiddelde9 = 0;
	    		}
	    		else{
	    			gemiddelde9 = competentie9/teller9;
	    		}
	    		if(teller10 == 0){
	    			gemiddelde10 = 0;
	    		}
	    		else{
	    			gemiddelde10 = competentie10/teller10;
	    		}
	    		
	    		out.println("['"+titel1+"', "+gemiddelde1+"],");
	    		out.println("['"+titel2+"', "+gemiddelde2+"],");
	    		out.println("['"+titel3+"', "+gemiddelde3+"],");
	    		out.println("['"+titel4+"', "+gemiddelde4+"],");
	    		out.println("['"+titel5+"', "+gemiddelde5+"],");
	    		
	    		out.println("['"+titel6+"', "+gemiddelde6+"],");
	    		out.println("['"+titel7+"', "+gemiddelde7+"],");
	    		out.println("['"+titel8+"', "+gemiddelde8+"],");
	    		out.println("['"+titel9+"', "+gemiddelde9+"],");
	    		out.println("['"+titel10+"', "+gemiddelde10+"],");
     			}
      
	    
		    
         %>  
        ['', 0]
        
        ]);
		  new google.visualization.ColumnChart(document.getElementById('dashboard')).
	      draw(data,
	           {title:"Competenties gemiddelde van Accent Nijkerk",
	            width:600, height:400,
	            hAxis: {title: "Competentie"}});
	    }
        </script>




</head>

<body>
	<%@ include file="header.jsp"%>
	<section id="main" class="column"
		style="min-width: 1110px; min-height: 600px !important;">
		
		<% 
		Object msgs=request.getAttribute( "msgs");
		if (msgs !=null) { 
			out.println("<h4 class='alert_success'>"+msgs+"</h4>"); 
			}			
			%>
		<article class="module width_full">
			<header>
			<form action="kpiaccent.do" method="get">
				<select name="select" onChange="this.form.submit()" id="select">
				<option value="all">Alle competenties</option>
				
				<%
				int teller = 0;
				for(Competentie c: competenties){
					teller++;
					out.println("<option value="+teller+">"+c.getTitel() + "</option>");
				}
				
				%>
				
				
				</select>
				</form>
			</header>
			<div class="module_content">
			<div id="control1"></div>

        <div id="dashboard"></div>
        
        <div id="chart1" style="height: 1000px;" ></div>
			
			
			</div>
		</article>
		<!-- end of styles article -->
		<div class="spacer"></div>
	</section>
	</div>
</body>

</html>