<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Comprar Producto</title>
</head>
<body>
	
	<h1>Comprar Producto</h1>
	
	<p>${producto}</p>	
	<p>${stock}</p>	
	<c:if test="${message != ''}">
		<p>${message}</p>
	</c:if>
	<a href="/tp-carrito-compras/buying/product/${producto}/10">Comprar 10</a>

	<div>
		<a href="/tp-carrito-compras/listarStock">Volver al listado</a>
	</div>
	
</body>

</html>