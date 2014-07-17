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
			
			<form:form method="post" action="/tp-carrito-compras/producto/nuevoProducto" modelAttribute="producto">
				<div>
					<label for="nombreProducto">Nombre del producto: </label>
					<input type="text" id="nombreProducto" name="nombreProducto" />
				</div>
				<div>
					<label for="cantidadProducto">Cantidad de unidades: </label>
					<input type="number" id="cantidadProducto" name="cantidadProducto" />
				</div>
				<input type="submit" value="agregarProducto" />
			</form:form>
			
			<div>
				<a href="/tp-carrito-compras/listarStock">Volver al listado</a>
			</div>
	
		</div>

	</div>
		
	<c:import url="footer.jsp" charEncoding="ISO-8859-1"></c:import>
	
</body>

</html>