<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>	
<%@ page import="java.util.ArrayList"%> 
<%@ page import="model.Levy"%> 
<%@ page import="dao.LevyDAO"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="main.css">
<title>Levyhylly</title>
</head>
<body>
<%
out.print("Kirjautuneena: " + session.getAttribute("kayttaja") + "<br>");
%>
<br>

	<form action="HaeLevyt" method="post">
	Hakusana:
		<input type="text" name="hakusana" id="hakusana">&nbsp;
		<input type="submit" value="Hae">
		<input type="button" value="Lisää uusi levy" id="lisaa">
	</form>
	<%
		if (request.getParameter("ilmo") != null) {
			out.print(request.getParameter("ilmo"));
		}
	%>
	<br>
	<table id="roundcorners">

		<tr class="bottom_border">
			<td>Artisti</td>
			<td>Levyn nimi</td>
			<td>Julkaisuvuosi</td>
			<td>Formaatti</td>
			<td>Levy-yhtiö</td>
			<td>Genre</td>
		</tr>

		<%
			if (request.getAttribute("levyt") != null) {
				ArrayList<Levy> levyt = (ArrayList<Levy>) request.getAttribute("levyt");
				for (int i = 0; i < levyt.size(); i++) {
					out.print("<tr>");
					out.print("<td>" + levyt.get(i).getLevyArtisti() + "</td>");
					out.print("<td>" + levyt.get(i).getLevyNimi() + "</td>");
					out.print("<td>" + levyt.get(i).getJulkaisuVuosi() + "</td>");
					out.print("<td>" + levyt.get(i).getFormaatti() + "</td>");
					out.print("<td>" + levyt.get(i).getLevyYhtio() + "</td>");
					out.print("<td>" + levyt.get(i).getGenre() + "</td>"); 
					out.print("<td><a class='poista' href='PoistaLevy?poista_id=" + levyt.get(i).getId()
							+ "'><abbr title='poista'>X</abbr></a>&nbsp");
					out.print("<a class='muuta' href='muutaLevy.jsp?muuta_id=" + levyt.get(i).getId()
							+ "&muuta_artisti=" + levyt.get(i).getLevyArtisti() 
							+ "&muuta_levynimi=" + levyt.get(i).getLevyNimi()
							+ "&muuta_julkaisuvuosi=" + levyt.get(i).getJulkaisuVuosi()
							+ "&muuta_formaatti=" + levyt.get(i).getFormaatti()
							+ "&muuta_levyyhtio=" + levyt.get(i).getLevyYhtio()
							+ "&muuta_genre=" + levyt.get(i).getGenre()
							+ "'><abbr title='muuta'>M</abbr></a></td>"); 
					out.print("</tr>");
				}
			}
		%>

	</table>
	
	<script>
	$(document).ready(function(){
		$("#hakusana").focus();
	    $("#lisaa").click(function(){
	    	window.location.href = 'lisaaLevy.jsp';
	    });
	});
</script>
<br>
</body>
</html>