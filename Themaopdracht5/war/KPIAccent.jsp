<!doctype html>
<html lang="en">

<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8" />
<title>KPI Accent Nijkerk</title>
<%@ include file="imports.jsp"%>


 <script type="text/javascript" src="//www.google.com/jsapi"></script>
    <script type="text/javascript">
      google.load('visualization', '1.1', {packages: ['controls']});
    </script>
    <script type="text/javascript">
      function drawVisualization() {
        // Prepare the data
       var data = google.visualization.arrayToDataTable([
          ['Competentie', 'Score', 'Aantal beoordelingen', 'Aantal leerlingen'],
          ['Samenwerken en Overleggen' , 3.9 , 12, 5],
          ['Aandacht en begrip tonen', 1.5, 20, 7],
          ['Klantvriendelijk en dienstverlenend', 2.4, 7, 3],
          ['Instructies en procedures opvolgen', 2.8, 54, 2],
          ['Plannen en organiseren', 3.4, 22, 6],
          ['Kwaliteit en vakdeskundigheid', 4.0, 3, 1],
          ['Veilig werken', 3.7, 42, 8],
          ['Met druk en tegenslag omgaan', 2.0, 3, 1],
          ['Omgaan met verandering en aanpassen', 1.7, 42, 8],
          ['Leren', 2.2, 33, 6]
        ]);
      
        // Define a slider control for the Age column.
        var slider = new google.visualization.ControlWrapper({
          'controlType': 'NumberRangeFilter',
          'containerId': 'control1',
          'options': {
            'filterColumnLabel': 'Score',
          'ui': {'labelStacking': 'vertical'}
          }
        });
      
        // Define a category picker control for the Gender column
        var categoryPicker = new google.visualization.ControlWrapper({
          'controlType': 'CategoryFilter',
          'containerId': 'control2',
          'options': {
            'filterColumnLabel': 'Competentie',
            'ui': {
            'labelStacking': 'vertical',
              'allowTyping': false,
              'allowMultiple': false
            }
          }
        });
      
        // Define a Pie chart
        var pie = new google.visualization.ChartWrapper({
          'chartType': 'ColumnChart',
          'containerId': 'chart1',
          'options': {
            'width': 800,
            'height': 300,
            'legend': 'none',
            'title': 'Score gemiddeld per competentie',
            'chartArea': {'left': 15, 'top': 15, 'right': 0, 'bottom': 0},
            'pieSliceText': 'label'
          },
          // Instruct the piechart to use colums 0 (Name) and 3 (Donuts Eaten)
          // from the 'data' DataTable.
          'view': {'columns': [0, 1]}
        });
      
        // Define a table
        var table = new google.visualization.ChartWrapper({
          'chartType': 'Table',
          'containerId': 'chart2',
          'options': {
            'width': '500px'
          }
        });
	// var table1 = new google.visualization.Table({'chartType': 'Table', 'containerId': 'chart2'});
        
     
        var formatter = new google.visualization.ColorFormat();
        formatter.addRange(2, 4, 'white', 'green');
        formatter.addRange(0, 2, 'white', 'red');
        formatter.format(data, 1); // Apply formatter to second column
        // Create a dashboard
        new google.visualization.Dashboard(document.getElementById('dashboard')).
            // Establish bindings, declaring the both the slider and the category
            // picker will drive both charts.
            bind([slider, categoryPicker], [pie, table]).
            // Draw the entire dashboard.
            draw(data, {allowHtml: true, showRowNumber: true});
        
       
      
      // table1.draw(data, {allowHtml: true, showRowNumber: true});
        
      }
      

      google.setOnLoadCallback(drawVisualization);
    </script>
</head>

<body>
	<%@ include file="header.jsp"%>
	<section id="main" class="column"
		style="min-width: 1110px; min-height: 600px !important;">
		
	
		<article class="module width_full">
		<div id="dashboard">
			<header>
			 <div id="control1"></div>
            <div id="control2"></div>
			</header>
			
			
      <table>
        <tr style='vertical-align: top'>
          <td style='width: 300px; font-size: 0.9em;'>
           
            <div id="control3"></div>
          </td>
          <td style='width: 600px'>
            <div style="float: left;" id="chart1"></div>
            <div style="float: left;" id="chart2"></div>
            <div style="float: left;" id="chart3"></div>
          </td>
        </tr>
      </table>
    </div>
			
			
			
		</article>
		<!-- end of styles article -->
		<div class="spacer"></div>
	</section>
	</div>
</body>

</html>