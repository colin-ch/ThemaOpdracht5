<html>
  <head>
  	      <%@ page import="java.util.ArrayList"%>
          <%@ page import="javax.servlet.ServletContextEvent"%>
          <%@ page import="com.appspot.Accent.model.Stelling"%>
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
       
          
          
          
    <script type="text/javascript">
    
    
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      
      

      
     
      
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Beoordeling', 'Stage Opleider', 'Student'],
      	  
          ['1', '1', '4'],

          <%
        	ArrayList<Stelling> alleStellingenLijst2 = new ArrayList<Stelling>();
        	alleStellingenLijst2 =(ArrayList<Stelling>) request.getAttribute("stellingen");
			for (Stelling s : alleStellingenLijst2) {
        		out.println("['1', '" + s.getDeStelling() + "' , '" + s.getDeWaarde() + "'],");       
         	}   
           %>
        ]);
        var options = {
          title: 'Laatste competenties',
          hAxis: {title: 'Score', titleTextStyle: {color: 'green'}},
          vAxis: {title: 'Beoordeling nummer', titleTextStyle: {color: 'green'}},
          // Allow multiple simultaneous selections.
          selectionMode: 'multiple',
          colors: ['#BEF781','green']		
        };
        var chart = new google.visualization.BarChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
 </script>
  </head>
  <body>
    <div id="chart_div" style="width: 900px; height: 500px;"></div>
  </body>
</html>