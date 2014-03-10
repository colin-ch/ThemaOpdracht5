<!--
You are free to copy and use this sample in accordance with the terms of the
Apache license (http://www.apache.org/licenses/LICENSE-2.0.html)
-->

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="content-type" content="text/html; charset=utf-8" />
  <title>Google Visualization API Sample</title>
  <script type="text/javascript" src="//www.google.com/jsapi"></script>
  <script type="text/javascript">
    google.load('visualization', '1', {packages: ['table']});
    function drawVisualization() {
      // Create and populate the data table.
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
    
      // Create and draw the visualization.
      var table1 = new google.visualization.Table(document.getElementById('visualization'));
    
      var formatter = new google.visualization.ColorFormat();
      formatter.addRange(0, 2, 'white', 'red');
      formatter.addRange(2, 5, 'white', 'green');
      formatter.format(data, 1); // Apply formatter to second column
    
      table1.draw(data, {allowHtml: true, showRowNumber: true});
    }
    
    google.setOnLoadCallback(drawVisualization);
  </script>
</head>
<body style="font-family: Arial;border: 0 none;">
<div id="visualization" style="width: 800px; height: 400px;"></div>
</body>
</html>