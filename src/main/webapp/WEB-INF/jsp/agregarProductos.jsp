<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!doctype html>
<html>
<head>
    <title>Agregar Productos</title>
    <link href="<c:url value="/resources/css/normalize.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet" type="text/css">
</head>
<body>

	<div class="wrapper">
	
		<header>
			<h1>Productos en stock</h1>
		</header>
			
		<div data-role="main">
		
			<c:forEach items="${productos}" var="product">
				<p>${product.nombre}</p>
			</c:forEach>
			
			<h2>Agregar productos:</h2>	
			<p><a href="/tp-carrito-compras/productos/agregar/Zapallo">Agregar Zapallo</a></p>
			<p><a href="/tp-carrito-compras/productos/agregar/Melon">Agregar Mel�n</a></p>
			<p><a href="/tp-carrito-compras/productos/agregar/Kiwi">Agregar Kiwi</a></p>
			
		<%-- 	<form action="agregarProducto.jsp" method="post"> --%>
		<!-- 		<label for="productName">Nombre de producto</label> -->
		<!-- 		<input id="productName" name="productName" type="text" /> -->
		<!-- 		<input type="submit" value="Agregar Producto" /> -->
		<%-- 	</form> --%>
			<div>
				<a href="/tp-carrito-compras/listarStock">Volver al listado</a>
			</div>
	
		</div>

	</div>
		
	<c:import url="footer.jsp" charEncoding="ISO-8859-1"></c:import>
	
</body>

</html>