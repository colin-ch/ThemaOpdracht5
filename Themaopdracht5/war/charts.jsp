<html>
  <head>
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
   
    <script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      
      
      <% 
		ArrayList<Stelling> alleStellingenLijst = sce.getServletContext().setAttribute("stellingen", alleStellingen);
		 %>
      
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Beoordeling', 'Stage Opleider', 'Student'],
      
          
          <% for(alleStellingenLijst : s){
          %>[1, <% s.getDeStelling() %> , <% s.getDeWaarde() %>]
          
          <% } %>
          
          ['1',  1,      4],
          
          
          
          ['2',  3,      2],
          ['3',  2,       1],
          ['4',  4,      3]
        ]);

        var options = {
          title: 'Laatste competenties',
          hAxis: {title: 'Score', titleTextStyle: {color: 'green'}},
          vAxis: {title: 'Beoordeling nummer', titleTextStyle: {color: 'green'}},
          // Allow multiple simultaneous selections.
          selectionMode: 'multiple',
          colors: ['#BEF781','green'],
          is3D: true
        
        		
        };

        var chart = new google.visualization.BarChart(document.getElementById('chart_div'));
        var chart2 = new google.visualization.PieChart(document.getElementById('chart2_div'));
        
        
        chart.draw(data, options);
        chart2.draw(data, options);
      }
    </script>
  </head>
  <body>
    <div id="chart_div" style="width: 900px; height: 500px;"></div>
    <div id="chart2_div" style="width: 900px; height: 500px;"></div>
  </body>
</html>