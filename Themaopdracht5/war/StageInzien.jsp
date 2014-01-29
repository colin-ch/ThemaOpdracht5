<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8" />
<title>Stage inzien</title>
<%@ include file="imports.jsp"%>

</head>

<body>
	<%@ include file="header.jsp"%>
	<section id="main" class="column"
		style="min-width: 1110px; min-height: 600px !important;">

		<% //msgs=request.getAttribute( "msgs"); if (msgs !=null) { out.println(msgs); } %>
		<article class="module width_full">
			<header>
				<h3>Stage inzien</h3>
			</header>
			<div class="module_content">

				

					<%@ page import="java.util.*"%>
					<%@ page import="java.text.*"%>
					<%@ page import="com.appspot.Accent.model.*"%>
					<%@ page import="com.appspot.Accent.model.service.*"%>
					<%
								
								
                            	StageOfyDAOImpl st = new StageOfyDAOImpl();
                            	ArrayList<Stage> alleStages = (ArrayList<Stage>) st.getAllStages();
                            	LeerlingOfyDAOImpl l = new LeerlingOfyDAOImpl();
                            	ArrayList<Leerling> leerlingen = (ArrayList<Leerling>)l.getAllLeerlingen();

                        		DocentOfyDAOImpl d = new DocentOfyDAOImpl();
                        		StageBedrijfOfyDAOImpl sb = new StageBedrijfOfyDAOImpl();
                            	ArrayList<StageBedrijf> bedrijven = (ArrayList<StageBedrijf>)sb.getAllStageBedrijven();

                        		StageBegeleiderOfyDAOImpl sbg = new StageBegeleiderOfyDAOImpl();//Objectify klassen
                            	ArrayList<StageBegeleider> begeleiders = (ArrayList<StageBegeleider>)sbg.getAllBegeleiders();

                        		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy"); 
                        		Object x = request.getAttribute("destage");
                        		if(x != null){
                        		Stage destage = ((Stage)x);
                        		Leerling deleerling = null;
                        		StageBegeleider begeleider = null;
                        		StageBedrijf bedrijf = null;
                        		for(StageBedrijf bedr: bedrijven){
                        			if(bedr.getUsername().equals(destage.getHetBedrijf())){
                        				bedrijf = bedr;
                        			}
                        		}
                        		for(StageBegeleider beg: begeleiders){
                        			if(beg.getEmail().equals(destage.getDeBegeleider())){
                        				begeleider = beg;
                        			}
                        		}
                        		for(Leerling stud: leerlingen){
                        			if(stud.getEmail().equals(destage.getDeLeerling())){
                        				deleerling = stud;
                        			}
                        		}
                        		out.println( "<h4>De Stage:</h4><br/>Stage id: "+ destage.getId() + "<br/>");
                        		out.println("Leerling: "+ deleerling.getRoepnaam() + " " + deleerling.getAchternaam()+ "<br/>");
                        		out.println("Begeleider: "+ begeleider.getUsername() + "<br/>");
							    out.println("StageBedrijf: " + bedrijf.getUsername()+ "<br/>");
                        		out.println("Begin datum stage: "+ destage.getBegindatum()+ "<br/>");
                        		out.println("Eind datum stage: "+ destage.getEinddatum());

                        		}
                        		
                        	%>
                        	
				
							
				<div id="table-div"></div>
			</div>
		</article>
		<!-- end of styles article -->
		<div class="spacer">
		</div>
	</section>
	</div>
</body>

</html>