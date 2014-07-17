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
			<c:if test="${stock <= 0}">
				<p>Stock agotado</p>
			</c:if>
						
			<c:if test="${stock > 0}">
			<form:form method="post" action="/tp-carrito-compras/producto/comprar" modelAttribute="producto">
				<input type="hidden" id="nombreProducto" name="nombreProducto" value="${producto}" />
				<div>
					<label for="cantidadProducto">Seleccione cantidad: </label>
					<select id="cantidadProducto" name="cantidadProducto">
						<option value="1">1</option>
						<option value="5">5</option>
						<option value="10">10</option>
						<option value="50">50</option>
					</select>
				</div>
				<input type="submit" value="agregar al carrito" />
			</form:form>
			</c:if>
		
			<div>
				<a href="/tp-carrito-compras/listarStock">Volver al listado</a>
			</div>
		
		</div>	
	
	</div>	
	
	<c:import url="footer.jsp" charEncoding="ISO-8859-1"></c:import>
	
</body>

</html>