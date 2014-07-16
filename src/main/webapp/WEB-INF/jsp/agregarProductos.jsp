<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Agregar Productos</title>
</head>
<body>
	
	<h1>Productos en stock</h1>
		
	<c:forEach items="${productos}" var="product">
		<p>${product}</p>
	</c:forEach>
	
	<h2>Agregar productos:</h2>	
	<p><a href="/tp-carrito-compras/productos/agregar/Zapallo">Agregar Zapallo</a></p>
	<p><a href="/tp-carrito-compras/productos/agregar/Melon">Agregar Melón</a></p>
	<p><a href="/tp-carrito-compras/productos/agregar/Kiwi">Agregar Kiwi</a></p>
	
<%-- 	<form action="agregarProducto.jsp" method="post"> --%>
<!-- 		<label for="productName">Nombre de producto</label> -->
<!-- 		<input id="productName" name="productName" type="text" /> -->
<!-- 		<input type="submit" value="Agregar Producto" /> -->
<%-- 	</form> --%>
	<div>
		<a href="/tp-carrito-compras/listarStock">Volver al listado</a>
	</div>
	
</body>

</html>