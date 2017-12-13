<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="main.css">
<title>Lisää levy</title>
</head>
<body>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Lisää levy<br><br>
<form action="LisaaLevy" method=post name="lisaaLomake" id="lisaaLomake">

<table>
<tr>
<td align="right">Artisti: </td>
<td> <input type="text" name="levyArtisti" id="levyArtisti"></td>
</tr>
<tr>
<td align="right">Levyn nimi: </td>
<td> <input type="text" name="levyNimi" id="levyNimi"></td>
</tr>
<tr>
<td align="right">Julkaisuvuosi: </td>
<td> <input type="text" name="julkaisuVuosi" id="julkaisuVuosi"></td>
</tr>
<tr>
<td align="right">Formaatti: </td>
<td> <input type="text" name="formaatti" id="formaatti"></td>
</tr>
<tr>
<td align="right">Levy-yhtiö: </td>
<td> <input type="text" name="levyYhtio" id="levyYhtio"></td>
</tr>
<tr>
<td align="right">Genre: </td>
<td> <input type="text" name="genre" id="genre"></td>
</tr>

<tr>
<td colspan="2"><input type="submit" value="Lisää" style="width:260px">
</td>
</tr>

</table>
</form>

</body>
</html>