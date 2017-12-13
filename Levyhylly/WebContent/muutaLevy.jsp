<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="main.css">
<title>Muuta levyn tietoja</title>
</head>
<%
String levyId = "";
if (request.getParameter("muuta_id")!=null) {
	levyId = request.getParameter("muuta_id");
}
String levyArtisti = "";
if (request.getParameter("muuta_artisti")!=null) {
	levyArtisti = request.getParameter("muuta_artisti");
}
String levyNimi = "";
if (request.getParameter("muuta_levynimi")!=null) {
	levyNimi = request.getParameter("muuta_levynimi");
}
String julkaisuVuosi= "";
if (request.getParameter("muuta_julkaisuvuosi")!=null) {
	julkaisuVuosi = request.getParameter("muuta_julkaisuvuosi");
}
String formaatti = "";
if (request.getParameter("muuta_formaatti")!=null) {
	formaatti = request.getParameter("muuta_formaatti");
}
String levyYhtio = "";
if (request.getParameter("muuta_levyyhtio")!=null) {
	levyYhtio = request.getParameter("muuta_levyyhtio");
}
String genre = "";
if (request.getParameter("muuta_genre")!=null) {
	genre = request.getParameter("muuta_genre");
}

%>
<body>
Muuta levyn tietoja
<br>
<form action="MuokkaaLevy" method=post>
<table>
<tr>
<td align="right">Artisti</td>
<td><input type="text" name="artistiUusi" id="levyArtisti" value="<%=levyArtisti%>"></td>
</tr>
<tr>
<td align="right">Levyn nimi</td>
<td><input type="text" name="nimiUusi" id="levyNimi" value="<%=levyNimi%>"></td>
</tr>
<tr>
<td align="right">Julkaisuvuosi</td>
<td><input type="text" name="vuosiUusi" id="julkaisuVuosi" value="<%=julkaisuVuosi%>"></td>
</tr>
<tr>
<td align="right">Formaatti</td>
<td><input type="text" name="formaattiUusi" id="formaatti" value="<%=formaatti%>"></td>
</tr>
<tr>
<td align="right">Levy-yhtiö</td>
<td><input type="text" name="yhtioUusi" id="levyYhtio" value="<%=levyYhtio%>"></td>
</tr>
<tr>
<td align="right">Genre</td>
<td><input type="text" name="genreUusi" id="genre" value="<%=genre%>"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="Muokkaa" style="width:260px"></td>
</tr>
</table>
<input type="hidden" name="id" value="<%=levyId%>">

</form>
<%
if(request.getParameter("ilmo")!=null){
	if(request.getParameter("ilmo").equals("1")){
		out.print("Levyn lisaaminen onnistui");	
	}else if(request.getParameter("ilmo").equals("0")){
		out.print("Levyn lisaaminen ei onnistunut");	
	}
}
%>
<script>
	$(document).ready(function(){
		$("#levyArtisti").focus();
	    $("#kaikki").click(function(){
	    	window.location.href = 'haeLevyt.jsp';
	    });
	});
</script>
<br>

</body>
</html>