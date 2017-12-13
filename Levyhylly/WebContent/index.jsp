<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="main.css">
<title>Levy hylly</title>
</head>
<body>
<h1>Kirjaudu sisään
</h1>

<div id="kirjaudu">
<form action="Kirjautuminen" method="post" name="kirjauduLomake" id="kirjauduLomake">
<span class="login">Tunnus: </span><input type="text" name="kayttaja" id="kayttaja" value=""><br>
<span class="login">Salasana: </span><input type="password" name="salasana" value=""><br>
<span class="login"></span><input type="submit" value="Kirjaudu">
</form>
<p>käyttäjätunnus = kayttaja salasana = password</p>
<%
if(request.getParameter("login")!=null){
	if(request.getParameter("login").equals("0")){
		out.print("Antamasi tunnus/salasana ei kelpaa!");
	}	
}
%>
</div>

<script>
	$(document).ready(function(){
		$("#kayttaja").focus();	
		$("#kirjauduLomake").validate({						
			rules: {
				kayttaja:  {
					required: true					
				},	
				salasana:  {
					required: true
				}		
			},
			messages: {
				kayttaja: {
					required: "Pakollinen"					
				},
				salasana: {
					required: "Pakollinen"
				}
			},			
			submitHandler: function (form) {				
				document.forms["kirjauduLomake"].submit();
			}		
		});
	});
</script>

</body>
</html>