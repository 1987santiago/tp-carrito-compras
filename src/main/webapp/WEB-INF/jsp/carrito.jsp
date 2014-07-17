<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html>
<head>
    <title>Carrito</title>
    <link href="<c:url value="/resources/css/normalize.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet" type="text/css">
<body>
	
	<div class="wrapper">

		<header>
			<h1>Carrito</h1>
		</header>

		<div data-role="main">
							
			<ul class="product-list">
			<c:forEach items="${productos}" var="producto">
				<li>
					${producto.nombre} <span class="stock">(${producto.cantidad})</span> 
					<span class="action-buttons"><a class="delete-link" href="/tp-carrito-compras/carrito/remover/${producto.nombre}">Remover</a></span>
				</li>
			</c:forEach>
			</ul>
					
			<a class="button important-button" href="/tp-carrito-compras/carrito/comprar">Comprar</a>
			<a class="button relevant-button" href="/tp-carrito-compras/carrito/vaciar">Vaciar carrito</a>
			<a class="return-link" href="/tp-carrito-compras/listarStock">Volver al listado</a>
	
		</div>

	</div>
		
	<c:import url="footer.jsp" charEncoding="ISO-8859-1"></c:import>
	
</body>

</html>