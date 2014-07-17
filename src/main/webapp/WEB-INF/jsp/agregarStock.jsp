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
			
			<p>Producto : ${producto}</p>
			<p>Stock : ${stock}</p>
			
			<a href="/tp-carrito-compras/agregarStock/${producto}/cantidad/5">Agregar 5 unidades</a>
			<a href="/tp-carrito-compras/agregarStock/${producto}/cantidad/10">Agregar 10 unidades</a>
			<a href="/tp-carrito-compras/agregarStock/${producto}/cantidad/50">Agregar 50 unidades</a>
			<a href="/tp-carrito-compras/agregarStock/${producto}/cantidad/100">Agregar 100 unidades</a>
			
			<%-- Generamos el form para solicitar el ingreso de la cantidad de unidades a agregar 
			<form:form action="confirmAddStock" method="POST" modelAttribute="carrito">
				<form:input path="quantity"/>
			</form:form> --%>
			
			<div>
				<a href="/tp-carrito-compras/listarStock">Volver al listado</a>
			</div>
	
		</div>

	</div>
		
	<c:import url="footer.jsp" charEncoding="ISO-8859-1"></c:import>
	
</body>

</html>