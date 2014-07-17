<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!doctype html>
<html>
<head>
    <title>Comprar Producto</title>
    <link href="<c:url value="/resources/css/normalize.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet" type="text/css">
</head>
<body>

	<div class="wrapper">
	
		<header>
			<h1>Comprar Producto</h1>
		</header>
		
		<div data-role="main">	
		
			<p>${producto}</p>	
			<p>${stock}</p>	
			<c:if test="${message != ''}">
				<p>${message}</p>
			</c:if>
			<a href="/tp-carrito-compras/buying/product/${producto}/10">Comprar 10</a>
		
			<div>
				<a href="/tp-carrito-compras/listarStock">Volver al listado</a>
			</div>
		
		</div>	
	
	</div>	
	
	<c:import url="footer.jsp" charEncoding="ISO-8859-1"></c:import>
	
</body>

</html>