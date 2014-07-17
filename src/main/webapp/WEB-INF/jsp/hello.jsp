<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!doctype html>
<html>
<head>
    <title>Ejemplo de Spring MVC</title>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet" type="text/css">
</head>
<body>
    
    <p>Hola ${nombre}!</p>
    
    <a href="/spring-example">Volver</a>
    
    <div>
    	<a href="../../contadorLetras/${nombre}">Contar Letras</a>
    </div>
	
	<c:import url="footer.jsp" charEncoding="ISO-8859-1"></c:import>
    
</body>
</html>