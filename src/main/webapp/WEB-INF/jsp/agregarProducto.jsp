<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Agregar Producto</title>
</head>
<body>
	
	<h1>Title</h1>
	
	<div>
		Aca se debe agregar un nuevo Producto.
	</div>
	
	<c:out value="${param}"></c:out>	

	<div>
		<a href="/tp-carrito-compras/listarStock">Volver al listado</a>
	</div>
	
</body>

</html>