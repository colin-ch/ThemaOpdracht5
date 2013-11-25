<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8" />
<title>Dashboard I Admin Panel</title>
<%@ include file="imports.jsp"%>
</head>

<body>
	<%@ include file="header.jsp"%>
	<section id="main" class="column"
		style="min-width: 1110px; min-height: 600px !important;">

		<% Object msgs=request.getAttribute( "msgs"); if (msgs !=null) { out.println(msgs); } %>
		<article class="module width_full">
			<header>
				<h3>Selecteren gebruiker</h3>
			</header>
			<div class="module_content">

				<form action="BeoordelingOphalenServlet.do" method="GET">

					<%@ page import="java.util.*"%>
					<%@ page import="com.appspot.Accent.model.*"%>
					<%@ page import="com.appspot.Accent.model.service.*"%>
					<%
                            	Object user = session.getAttribute("userobject");
                            	StageOfyDAOImpl st = new StageOfyDAOImpl();
                            	LeerlingOfyDAOImpl l = new LeerlingOfyDAOImpl();
                        		DocentOfyDAOImpl d = new DocentOfyDAOImpl();
                        		StageBedrijfOfyDAOImpl sb = new StageBedrijfOfyDAOImpl();
                        		StageBegeleiderOfyDAOImpl sbg = new StageBegeleiderOfyDAOImpl();
                        		
                        		if(user instanceof Leerling){
                        			for(Leerling le : l.getAllLeerlingen()){
                        				String naam = ((Leerling) user).getUsername();
                        				String pass = ((Leerling) user).getPassword();
                        				if(naam.equals(le.getUsername()) && pass.equals(le.getPassword())){
                        					out.println("<input type='radio' name='radio' value='"+ naam +"'>"+ naam +" "+ ((Leerling) user).getEmail() +" "+ ((Leerling) user).getKlas() +" "+ ((Leerling) user).getBegeleider()+"<br/>");
                        				}
                        			}
                        			
                        		}
                        		if(user instanceof Docent){
                        			for(Leerling le : l.getAllLeerlingen()){
                        				out.println("<input type='radio' name='radio' value='"+ le.getUsername() +"'>"+ le.getUsername() +" "+ le.getEmail() +" "+ le.getKlas() +" "+ le.getBegeleider()+"<br/>");
                        			}
                        		}
                        		if(user instanceof StageBedrijf){
                        			for(Stage stage: st.getAllStages()){
                        				if(stage.getHetBedrijf().equals(((StageBedrijf) user).getUsername())){
                        					out.println("<input type='radio' name='radio' value='"+ stage.getDeLeerling() +"'>"+ stage.getDeLeerling() +" "+ stage.getHetBedrijf() +" "+ stage.getDeOpleider() +" "+ stage.getBegindatum()+"<br/>");
                        				}
                        			}
                        		}
                        		if(user instanceof StageBegeleider){
                        			for(Leerling le : l.getAllLeerlingen()){
                        				if(le.getBegeleider().equals(((StageBegeleider) user).getEmail())){
                        					out.println("<input type='radio' name='radio' value='"+ le.getUsername() +"'>"+ le.getUsername() +" "+ le.getEmail() +" "+ le.getKlas() +" "+ le.getBegeleider()+"<br/>");
                        				}
                        			}
                        		}
                        		
                        	
                        		
                        		
                            	%>

					<input type="submit" value="verder">
				</form>
			</div>
		</article>
		<!-- end of styles article -->
		<div class="spacer"></div>
	</section>
	</div>
</body>

</html>