<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8" />
<title>Stage aanmaken</title>
<%@ include file="imports.jsp"%>
</head>

<body>
	<%@ include file="header.jsp"%>
	<section id="main" class="column"
		style="min-width: 1110px; min-height: 600px !important;">
		<% 
		Object msgs=request.getAttribute( "msgs"); 
		if (msgs !=null) { 
			out.println(msgs); 
		} 
		%>
		<article class="module width_full">
			<header>
				<h3>Stage aanmaken</h3>
			</header>
			<div class="module_content">
			<%@ page import="com.appspot.Accent.model.*" %>
			<%@ page import="com.appspot.Accent.model.service.*" %>
			<%@ page import="java.util.ArrayList" %>
			<form action="/StageAanmaken.do" method="get">
			<%
			StageOfyDAOImpl sod = new StageOfyDAOImpl();
			ArrayList<Stage>stages = (ArrayList<Stage>) sod.getAllStages();
			
			int i = 0;

			boolean x = true;

			while(x){
				boolean f = true;
				double id = (Math.random() * 101); 
				i = (int) id;
				System.out.println("de i die getest wordt:" +i);

				for(Stage st : stages){
					if(st.getId() == i){
						System.out.println(st.getId());

							f = false;
					}
				}
				
				if(f){
					x = false;
				}
			}
			System.out.println("i is uiteiendelijk:" +i);


			if(x == false){		
				
				
				out.println("<input type='hidden' name='id' value='"+i+"'>");
			}
			%>
				Username van de deelnemende leerling
				<input list="leerlingen" name="leerlingen" placeholder="Naam van de leerling"><br/>
				<%
				LeerlingOfyDAOImpl lod = new LeerlingOfyDAOImpl();
				out.println("<datalist id='leerlingen'>");
				if (lod.getAllLeerlingen() != null) {
					for (Leerling l : lod.getAllLeerlingen()) {
						
						out.println(" <option value='"+  l.getUsername() + "'>"+l.getRoepnaam()+ " " + l.getAchternaam() +"</option>") ;
					}
					out.println(" </datalist>");
				}
				else{
					out.println("Error") ;
				} %>
				Naam van de begeleider van de leerling
				<input list="begeleiders" name="begeleiders" placeholder="Naam begeleider"><br/>
				<%
				StageBegeleiderOfyDAOImpl sbod = new StageBegeleiderOfyDAOImpl();
				out.println("<datalist id='begeleiders'>");
				if (sbod.getAllBegeleiders() != null) {
					for (StageBegeleider sb : sbod.getAllBegeleiders()) {
						
						out.println(" <option value='"+  sb.getEmail() + "'>"+sb.getUsername()+"</option>") ;
					}
					out.println(" </datalist>");
				}
				else{
					out.println("Error") ;
				} %>
				Naam van de opleider
				<input type="text" name="opleider" placeholder="Opleider"><br/>
				
				Naam van het bedrijf
				<input list="bedrijf" name="bedrijf" placeholder="Naam bedrijf"><br/>
				<%
				StageBedrijfOfyDAOImpl bod = new StageBedrijfOfyDAOImpl();
				out.println("<datalist id='bedrijf'>");
				if (bod.getAllStageBedrijven() != null) {
					for (StageBedrijf sbe : bod.getAllStageBedrijven()) {
						
						out.println(" <option value='"+  sbe.getUsername() + "'>"+sbe.getUsername()+"</option>") ;
					}
					out.println(" </datalist>");
				}
				else{
					out.println("Error") ;
				} %>
				
				Begin datum stage
				<input type="date" name="begin" required="required"><br/>
				Eind datum stage
				<input type="date" name="einde" required="required"><br/>

				<input type="submit" value="Maak stage aan" name="stage">
			</form>	
			</div>
		</article>
		<!-- end of styles article -->
		<div class="spacer"></div>
	</section>
	</div>
</body>

</html>
