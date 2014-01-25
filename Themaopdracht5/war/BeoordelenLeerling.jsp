<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8" />
<title>Dashboard I Admin Panel</title>

<link rel="stylesheet" href="css/layout.css" type="text/css"
	media="screen" />
<!--[if lt IE 9]>
	<link rel="stylesheet" href="css/ie.css" type="text/css" media="screen" />
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
<script src="js/jquery-1.5.2.min.js" type="text/javascript"></script>
<script src="js/hideshow.js" type="text/javascript"></script>
<script src="js/jquery.tablesorter.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.equalHeight.js"></script>
<script type="text/javascript">
	
	$(document).ready(function() 
    	{ 
      	  $(".tablesorter").tablesorter(); 
   	 } 
	);
	$(document).ready(function() {

	//When page loads...
	$(".tab_content").hide(); //Hide all content
	$("ul.tabs li:first").addClass("active").show(); //Activate first tab
	$(".tab_content:first").show(); //Show first tab content

	//On Click Event
	$("ul.tabs li").click(function() {

		$("ul.tabs li").removeClass("active"); //Remove any "active" class
		$(this).addClass("active"); //Add "active" class to selected tab
		$(".tab_content").hide(); //Hide all tab content

		var activeTab = $(this).find("a").attr("href"); //Find the href attribute value to identify the active tab + content
		$(activeTab).fadeIn(); //Fade in the active ID content
		return false;
	});

});
    </script>
<script type="text/javascript">
    $(function(){
        $('.column').equalHeight();
    });
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
				<h3>Beoordelen</h3>
			</header>
			<div class="module_content">
				<%@ page import="com.appspot.Accent.model.Stage"%>
				<%@ page import="com.appspot.Accent.model.Beoordeling"%>

				<%@ page import="com.appspot.Accent.model.Competentie"%>
				<%@ page import="com.appspot.Accent.model.Stelling"%>
				<%@ page import="com.appspot.Accent.model.Leerling"%>
				<%@ page import="java.util.ArrayList"%>
				<%@ page import="com.googlecode.objectify.Objectify"%>
				<%@ page import="com.googlecode.objectify.ObjectifyService"%>
				<%@ page import="com.appspot.Accent.model.service.*"%>

				<form action="/BeoordeelServlet.do" method="GET">
					<%
				Objectify ofy = ObjectifyService.begin(); //alle objectify klassen die nodig zijn 
				StageOfyDAOImpl stod = new StageOfyDAOImpl();
				Object o = request.getSession().getAttribute("userobject");
				BeoordelingOfyDAOImpl bod = new BeoordelingOfyDAOImpl();
				CompetentieOfyDAOImpl cod = new CompetentieOfyDAOImpl();
				StellingOfyDAOImpl sod = new StellingOfyDAOImpl();
				StellingBeoordeeldOfyDAOImpl sbod = new StellingBeoordeeldOfyDAOImpl();
ArrayList<StellingBeoordeeld> beoordeelStellingen = (ArrayList <StellingBeoordeeld>) sbod.getAllStellingenBeoordeeld();
				ArrayList < Stage > allStages = (ArrayList < Stage > ) stod.getAllStages();//alle stages worden opgehaald
				ArrayList < Beoordeling > beoordelingen = (ArrayList < Beoordeling > ) bod.getAllBeoordelingen(); //alle beoordelingen worden opgehaald

				for (Stage s: allStages) { //alle stages worden door lopen
				    if (o instanceof Leerling) {//kijkt of ingelogde gebruiker een leerling is

				        if (s.getDeLeerling().equals(((Leerling) o).getUsername())) {//zoekt stage dmw van ingelogde gebruikersnaam te vergelijken met naam van leerling in stage
				            for (Beoordeling be: beoordelingen) {//alle beoordelingen doorlopen
				            	
				              if(be.getStage() == s.getId()){
				            	
				            	
				            	if (be.getDatum() == null) {
				            		ArrayList<Integer> beoordelencomp = be.getCompetenties();

				                    ArrayList < Competentie > competenties = (ArrayList < Competentie > ) cod.getAllCompetenties();
				                    int teller = 0;
				                    for (Competentie c: competenties) {
				                    	
				                    for(Integer inter : beoordelencomp){//alle competenties doorlopen
				                        //System.out.println(" "  + c.getTitel());
									if(inter == c.getEigenId()){
				                        out.println("<h2>" + c.getTitel() + "</h2><br/>");

				                        ArrayList < Stelling > stellingen = (ArrayList < Stelling > ) sod.getAllStellingen();
				                        ArrayList <StellingBeoordeeld> currentbeoordelen = new ArrayList<StellingBeoordeeld>();
				                        ArrayList<Integer> controleArray = new ArrayList<Integer>();
				                        for(StellingBeoordeeld sbfill : beoordeelStellingen){
				                        	if(s.getId() == sbfill.getDeStage()){
				                        		if(sbfill.getDeWaardeLeerling() == null){
				                        			currentbeoordelen.add(sbfill);
				                        		}
				                        	}
				                        }
				                        
			                        	for(StellingBeoordeeld sb : currentbeoordelen){//alle stellingen door lopen
				                        for (Stelling st: stellingen) {
					                       if (st.getEigenId() == c.getEigenId()) {
				                            	if(st.getUniekID() == sb.getUniekID()){
				                            		boolean check =true;
				                            	for(int ctrl : controleArray){
				                            		if(ctrl == st.getUniekID()){
				                            			
				                            			check = false;
				                            		}

				                            	}
				                            	
				                   

				                            	if(check == true){
				                            		controleArray.add(sb.getUniekID());
				                                teller++;
				                                String waarde = st.getDeWaarde();

				                                out.println("<h4>" + st.getDeStelling() + "</h4>");
												//voor iedere stelling radio buttons maken
				                                if (waarde == null || waarde.equals("")) {
				                                    out.println("1<input type='radio' name='" + st.getUniekID() + "' value='1'>2<input type='radio' name='" + st.getUniekID() + "' value='2'>3<input type='radio' name='" + st.getUniekID() + "' value='3'>4<input type='radio' name='" + st.getUniekID() + "' value='4'><br/>");
				                                }

				                                if (waarde.equals("1")) {
				                                    out.println("1<input type='radio' name='" + st.getUniekID() + "' checked='checked' value='1'>2<input type='radio' name='" + st.getUniekID() + "' value='2'>3<input type='radio' name='" + st.getUniekID() + "' value='3'>4<input type='radio' name='" + st.getUniekID() + "' value='4'><br/>");
				                                }

				                                if (waarde.equals("2")) {
				                                    out.println("1<input type='radio' name='" + st.getUniekID() + "' value='1'>2<input checked='checked' type='radio' name='" + st.getUniekID() + "' value='2'>3<input type='radio' name='" + st.getUniekID() + "' value='3'>4<input type='radio' name='" + st.getUniekID() + "' value='4'><br/>");
				                                }
				                                if (waarde.equals("3")) {
				                                    out.println("1<input type='radio' name='" + st.getUniekID() + "' value='1'>2<input  type='radio' name='" + st.getUniekID() + "' value='2'>3<input checked='checked' type='radio' name='" + st.getUniekID() + "' value='3'>4<input type='radio' name='" + st.getUniekID() + "' value='4'><br/>");
				                                }
				                                if (waarde.equals("4")) {
				                                    out.println("1<input type='radio' name='" + st.getUniekID() + "' value='1'>2<input type='radio' name='" + st.getUniekID() + "' value='2'>3<input checked='checked' type='radio' name='" + st.getUniekID() + "' value='3'>4<input type='radio' name='" + st.getUniekID() + "' value='4'></br>");
				                                }
				                               
				                            	}

				                            }
				                            }
				                        }}
				                    }}}
				                }break;
				             }
				            }
				        }
				    }
				}
				out.println("eventuele Opmerkingen:<input type='text' name='opmerking' value=''> ");
				out.println("<input type='submit' value='Opslaan' name='Opslaan' />");
				%>

				</form>
				
				
			</div>


		</article>
		<!-- end of styles article -->
		<div class="spacer"></div>
	</section>

	</div>

</body>

</html>