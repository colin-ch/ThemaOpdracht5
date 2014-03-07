<!doctype html>

<%@page import="com.appspot.Accent.model.service.CompetentieOfyDAOImpl"%>
<%@page import="com.appspot.Accent.model.service.StageOfyDAOImpl"%>
<%@page import="com.appspot.Accent.model.service.StellingOfyDAOImpl"%>
<%@page import="com.appspot.Accent.model.service.StellingBeoordeeldOfyDAOImpl"%>
<%@page import="com.appspot.Accent.model.service.BeoordelingOfyDAOImpl"%>
<%@page import="com.appspot.Accent.model.service.StageBegeleiderOfyDAOImpl"%>
<html lang="en">

<head>
<meta charset="utf-8" />
<%@ include file="imports.jsp"%>
<title>KPI Stagebegeleider</title>

             <%@ page import="com.googlecode.objectify.Objectify"%>
          <%@ page import="com.googlecode.objectify.ObjectifyService"%>  
          <%@ page import="com.appspot.Accent.model.*" %>
          <%@ page import="java.util.*"%>
          
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
        
    <script>
 <% String selectie = "all";
 if(request.getAttribute("competentie") != null){
   selectie = ""+ request.getAttribute("competentie");
     }
 %>
    google.load("visualization", "1", {packages:["corechart"]});
    
      
      function drawVisualization() {
        var data = google.visualization.arrayToDataTable([
          ['Stagebegeleider', 'Samenwerken en overleggen','Aandacht en begrip tonen',  'Klantvriendelijk en dienstverlenend', 'Instructies en procedures opvolgen',  'Plannen en organiseren',  'Kwaliteit en vakdeskundigheid',  'Veilig werken', 'Met druk en tegenslag omgaan', 'Omgaan met verandering en aanpassen', 'Leren'],
          <% 
         
		    Objectify ofy;
		    ofy = ObjectifyService.begin();
		  	StageBegeleiderOfyDAOImpl sbo = new StageBegeleiderOfyDAOImpl();
			ArrayList<StageBegeleider> begeleiders= (ArrayList<StageBegeleider>) sbo.getAllBegeleiders();
		 	StageOfyDAOImpl so = new StageOfyDAOImpl();
			ArrayList<Stage> stages = (ArrayList<Stage>) so.getAllStages();
			BeoordelingOfyDAOImpl bod = new BeoordelingOfyDAOImpl();
			ArrayList<Beoordeling> beoordelingen= (ArrayList<Beoordeling>) bod.getAllBeoordelingen();
			CompetentieOfyDAOImpl co = new CompetentieOfyDAOImpl();
			ArrayList<Competentie> competenties = (ArrayList<Competentie>) co.getAllCompetenties();
			StellingOfyDAOImpl sod = new StellingOfyDAOImpl();
			ArrayList<Stelling> stellingen= (ArrayList<Stelling>) sod.getAllStellingen();	
			StellingBeoordeeldOfyDAOImpl sbod = new StellingBeoordeeldOfyDAOImpl();
			ArrayList<StellingBeoordeeld> stellingenbeoordeeld= (ArrayList<StellingBeoordeeld>) sbod.getAllStellingenBeoordeeld();
	
			
			for(StageBegeleider begeleider : begeleiders){
				String competentienaam1 = " 1";
				int competentieWaarde1 = 0;
				String competentienaam2 = " 2";
				int competentieWaarde2 = 0;
				String competentienaam3 = " 3";
				int competentieWaarde3 = 0;
				String competentienaam4 = " 4";
				int competentieWaarde4 = 0;
				String competentienaam5 = " 5";
				int competentieWaarde5 = 0;
				String competentienaam6 = "6 ";
				int competentieWaarde6 = 0;
				String competentienaam7 = "7 ";
				int competentieWaarde7 = 0;
				String competentienaam8 = " 8";
				int competentieWaarde8 = 0;
				String competentienaam9 = "9 ";
				int competentieWaarde9 = 0;
				String competentienaam10 = "10 ";
				int competentieWaarde10 = 0;
				
				int teller1= 0;
				int teller2= 0;
				int teller3= 0;
				int teller4= 0;
				int teller5= 0;
				int teller6= 0;
				int teller7= 0;
				int teller8= 0;
				int teller9= 0;
				int teller10= 0;
				
				
				for(Stage stage : stages){
					if(stage.getDeBegeleider().equals(begeleider.getEmail())){
				for(Beoordeling be : beoordelingen){
					if(be.getStage() == stage.getId()){
						for(StellingBeoordeeld sb : stellingenbeoordeeld){
						if(be.getIDBeoordeling().equals(sb.getIDBeoordeling())){
						for(Stelling stel : stellingen){
							if(stel.getUniekID() == sb.getUniekID()){
						ArrayList<Integer> beoordeeldecompetenties = be.getCompetenties();
						for(Competentie comp : competenties){
							for(Integer unid : beoordeeldecompetenties){
							if(comp.getEigenId() ==  unid){
								if(comp.getEigenId() == stel.getEigenId()){
									
									int bedrijf = 0;
									int leerling = 0;
									
									if(sb.getDeWaardeStagebedrijf()!= null){
										bedrijf = Integer.parseInt(sb.getDeWaardeStagebedrijf());
									}
									if(sb.getDeWaardeLeerling() != null){
										leerling = Integer.parseInt(sb.getDeWaardeLeerling());
									}
									
									if(comp.getEigenId() == 1){
										teller1 = teller1 +  1;
										competentieWaarde1 = competentieWaarde1 + (bedrijf + leerling) ;
									}
									if(comp.getEigenId() == 2){
										teller2 = teller2 +  1;
										competentieWaarde2 =competentieWaarde2 + (bedrijf + leerling) ;
									}
									if(comp.getEigenId() == 3){
										teller3 =+  1;
										competentieWaarde3 = competentieWaarde3 + (bedrijf + leerling) ;
									}
									if(comp.getEigenId() == 4){
										teller4 =+  1;
										competentieWaarde4 = competentieWaarde4 + (bedrijf + leerling) ;
									}
									if(comp.getEigenId() == 5){
										teller5 =+  1;
										competentieWaarde5 =competentieWaarde5 + (bedrijf + leerling) ;
									}
									if(comp.getEigenId() == 6){
										teller6 =+  1;
										competentieWaarde6 =competentieWaarde6 + (bedrijf + leerling) ;
									}if(comp.getEigenId() == 7){
										teller7 =+  1;
										competentieWaarde7 =competentieWaarde7 + (bedrijf + leerling) ;
									}
									if(comp.getEigenId() == 8){
										teller8 =+  1;
										competentieWaarde8 =competentieWaarde8 + (bedrijf + leerling) ;
									}
									if(comp.getEigenId() == 9){
										teller9 =+  1;
										competentieWaarde9 =competentieWaarde9 + (bedrijf + leerling) ;
									}
									if(comp.getEigenId() == 10){
										teller10 =+  1;
										competentieWaarde10 =competentieWaarde10 + (bedrijf + leerling) ;
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
				}
				if(teller1 != 0){
				competentieWaarde1 = ((competentieWaarde1/2)/teller1);
				}else{competentieWaarde1 = (competentieWaarde1/2);}
				if(teller2 != 0){
				competentieWaarde2 = ((competentieWaarde2/2)/teller2);
				}else{competentieWaarde2 = (competentieWaarde2/2);}
				if(teller3 != 0){
				competentieWaarde3 = ((competentieWaarde3/2)/teller3);
				}else{competentieWaarde10 = (competentieWaarde3/2);}
				if(teller4 != 0){
				competentieWaarde4 = ((competentieWaarde4/2)/teller4);
				}else{competentieWaarde4 = (competentieWaarde4/2);}
				if(teller5 != 0){
				competentieWaarde5 = ((competentieWaarde5/2)/teller5);
				}else{competentieWaarde5 = (competentieWaarde5/2);}
				if(teller6 != 0){
				competentieWaarde6 = ((competentieWaarde6/2)/teller6);
				}else{competentieWaarde6 = (competentieWaarde6/2);}
				if(teller7 != 0){
				competentieWaarde7 = ((competentieWaarde7/2)/teller7);
				}else{competentieWaarde7 = (competentieWaarde7/2);}
				if(teller8 != 0){
				competentieWaarde8 = ((competentieWaarde8/2)/teller8);
				}else{competentieWaarde8 = (competentieWaarde8/2);}
				if(teller9 != 0){
				competentieWaarde9 = ((competentieWaarde9/2)/teller9);
				}else{competentieWaarde9 = (competentieWaarde9/2);}
				if(teller10 != 0){
				competentieWaarde10 = ((competentieWaarde10/2)/teller10);
				}else{competentieWaarde10 = (competentieWaarde10/2);}

				out.println("['"+ begeleider.getEmail()+ "', "+ competentieWaarde1 +","+ competentieWaarde2 +", "+ competentieWaarde3 +", "+ competentieWaarde4 +", "+ competentieWaarde5 +", "+ competentieWaarde6 +", "+ competentieWaarde7 +", "+ competentieWaarde8 +", "+ competentieWaarde9 +", "+ competentieWaarde10 +"],");

      }
			
		
			
			
	         %>
        
        
        ]);
        
        var view = new google.visualization.DataView(data);
        view.setColumns([0, 1,
                         { calc: "stringify",
                           sourceColumn: 1,
                           type: "string",
                           role: "annotation" },
                         2]);
        
        
      
        var options = {
                width: 1200,
                height: 800,
                legend: { position: 'right', maxLines: 8 },
        	bar: { groupWidth: '75%' },
                isStacked: true,
              };
        
        
        
        var categoryPicker = new google.visualization.ControlWrapper({
            'controlType': 'CategoryFilter',
            'containerId': 'control1',
            'options': {
              'filterColumnIndex': 0,
              'ui': {
                'allowTyping': false,
                'allowMultiple': true,
                'selectedValuesLayout': 'belowStacked'
              }
            }
          });
       
       var view = new google.visualization.DataView(data);
       view.setColumns([ <%if(selectie.equals("all")){out.println("0,1, 2,3,4,5,6,7,8,9,10");}if(selectie.equals("1")){out.println("0,1");}if(selectie.equals("2")){out.println("0, 2");}if(selectie.equals("3")){out.println("0,3");} if(selectie.equals("4")){out.println("0,4");} if(selectie.equals("5")){out.println("0,5");} if(selectie.equals("6")){out.println("0,6");}if(selectie.equals("7")){out.println("0,7");} if(selectie.equals("9")){out.println("0,8");} if(selectie.equals("9")){out.println("0,9");}if(selectie.equals("10")){out.println("0,10");} %>]
  );
      
       var options = {
    		   width: 1100,
    	        height: 700,
    	        legend: { position: 'right', maxLines: 10 },
    		bar: { groupWidth: '75%' },
    	        isStacked: true,
    		      };
      
       var chart = new google.visualization.BarChart(document.getElementById("chart1"));
       chart.draw(view, options);
      }
      google.setOnLoadCallback(drawVisualization);
 </script>



</head>


<body>

	<%@ include file="header.jsp"%>

	<section id="main" class="column"
		style="min-width: 1110px; min-height: 600px !important;">
		<% 
		Object msgs=request.getAttribute( "msgs"); 
		if (msgs !=null) { 
			out.println("<h4 class='alert_info'>"+msgs+"</h4>"); 
		} 
		%>


		<article class="module width_full">
			<header>
				<h3>KPI Stagebegeleiders</h3>
			</header>
			<div class="module_content" >
			
	<table>
        <tr style='vertical-align: top'>
            <div id="control1">      <form action="/KPIStagebegeleider.do" method="get" id="form">
		<select name="select" onChange="this.form.submit()" id="select">
  <option value="all" <% if(selectie.equals("all")){out.println("selected");} %>>alle competenties</option>
  <option value="1"<% if(selectie.equals("1")){out.println("selected");} %>>1</option>
  <option value="2"<% if(selectie.equals("2")){out.println("selected");} %>>2</option>
  <option value="3"<% if(selectie.equals("3")){out.println("selected");} %>>3</option>
  <option value="4"<% if(selectie.equals("4")){out.println("selected");} %>>4</option>
  <option value="5"<% if(selectie.equals("5")){out.println("selected");} %>>5</option>
  <option value="6"<% if(selectie.equals("6")){out.println("selected");} %>>6</option>
  <option value="7"<% if(selectie.equals("7")){out.println("selected");} %>>7</option>
  <option value="8"<% if(selectie.equals("8")){out.println("selected");} %>>8</option>
  <option value="9"<% if(selectie.equals("9")){out.println("selected");} %>>9</option>
  <option value="10"<% if(selectie.equals("10")){out.println("selected");} %>>10</option>
</select>
          </tr>
          <tr style='width: 600px'>
            <div style="float: left;" id="chart1"></div>
          </tr>
        
      </table>
				
			</div>
			
				
				
			</div>


		</article>
		<!-- end of styles article -->
		<div class="spacer"></div>
	</section>

	</div>

</body>

</html>