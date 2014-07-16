<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Listar Stock</title>
</head>
<body>
	
	<h1>Listado de productos en stock</h1>
	
	<h2>¿¿¿COMO CORNO SE MANEJAN LOS FORM???&lt;form:form&gt;</h2>
	
	<c:forEach items="${cantidades}" var="q">
		<span>${q}</span>
	</c:forEach>
	<ul>
	<c:forEach items="${productos}" var="producto">
		<li>
			<span>${producto}</span>
			<a href="/tp-carrito-compras/buying/product/${producto}">comprar</a>
		</li>
	</c:forEach>
	</ul>
	
	<ul>
	<c:forEach items="${stock}" var="stockProducto">
		<li>${stockProducto}</li>
	</c:forEach>
	</ul>

	<a href="productos/listar">Agregar Producto</a>
	
	<form>
		<label for="modifyStock">Modificar Stock:</label>
		<select id="modifyStock">
			<option>Producto X</option>
		</select>
		<input type="submit" value="ok" />
	</form>
	
</body>

</html>