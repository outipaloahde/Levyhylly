<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="model.Levy"%> 
<%@ page import="dao.LevyDAO"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="main.css">
<title>Insert title here</title>
</head>
<body>

<table border="1">

		<tr>
			<td>Artisti</td>
			<td>Levyn nimi</td>
			<td>Julkaisuvuosi</td>
			<td>Formaatti</td>
			<td>Levy-yhtiö</td>
			<td>Genre</td>
		</tr>
		
		
		
		<%
		LevyDAO dao = new LevyDAO();
		ArrayList<Levy> levyt = dao.listaaKaikki();
		for(int i=0;i<levyt.size();i++){
			out.print("<tr>");
			out.print("<td>" + levyt.get(i).getLevyArtisti() + "</td>");
			out.print("<td>" + levyt.get(i).getLevyNimi() + "</td>");
			out.print("<td>" + levyt.get(i).getJulkaisuVuosi() + "</td>");
			out.print("<td>" + levyt.get(i).getFormaatti() + "</td>");
			out.print("<td>" + levyt.get(i).getLevyYhtio() + "</td>");
			out.print("<td>" + levyt.get(i).getGenre() + "</td>"); /*
			out.print("<td><a class='poista' href='PoistaLevy?poista_id="+levyt.get(i).getId()+"'>X</a></td>"); */
			out.print("</tr>");
		}
		%>

</body>
</html>