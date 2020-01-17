<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>communes-rest</title>
</head>
<body>
<%
	String protocol = request.getScheme();
	String host = request.getServerName();
	String port = String.valueOf(request.getServerPort());
	String baseUrl = getServletContext().getContextPath();
%>
<h2>Utilisation du web service REST</h2>
<div><%=protocol%>://<%=host%>:<%=port%><%=baseUrl %>/rest/communes/cp/972 : liste des communes dont le code postal débute par 972</div>
<div><%=protocol%>://<%=host%>:<%=port%><%=baseUrl %>/rest/communes/nom/din : liste des communes dont le code postal débute par din</div>
<div><%=protocol%>://<%=host%>:<%=port%><%=baseUrl %>/rest/communes/id/56	 : commune dont l'identifiant en base est 56</div>

</body>
</html>