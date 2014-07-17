<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!doctype html>
<html>
<head>
    <title>Listar Stock</title>
    <link href="<c:url value="/resources/css/normalize.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet" type="text/css">
</head>
<body>
	
	<div class="wrapper">
	
		<header>
			<h1>Listado de productos en stock</h1>
		</header>
	
		<div data-role="main">
		
			<ul class="product-list">
			<c:forEach items="${productos}" var="producto">
				<li>
					${producto.nombre} <span>(stock: ${producto.cantidad})</span>
					<span class="action-buttons">
						<a href="/tp-carrito-compras/buying/product/${producto.nombre}" title="comprar">comprar</a>
						<a href="/tp-carrito-compras/agregarStock/${producto.nombre}" title="agregar stock">agregar stock</a>
					</span>
				</li>
			</c:forEach>
			</ul>
					
			<a href="productos/listar">Agregar Producto</a>
			
			<div><a href="carrito/listar">Ver mis compras</a></div>
		
		</div>
	
	</div>
		
	<c:import url="footer.jsp" charEncoding="ISO-8859-1"></c:import>
	
</body>

</html>