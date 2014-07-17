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
				
			<h2>¿¿¿COMO CORNO SE MANEJAN LOS FORM???&lt;form:form&gt;</h2>
			
			<ul class="product-list">
			<c:forEach items="${productos}" var="producto">
				<li>
					${producto.nombre} - ${producto.cantidad} 
					<span class="action-buttons"><a href="/tp-carrito-compras/carrito/remover/${producto.nombre}">Remover</a></span>
				</li>
			</c:forEach>
			</ul>
					
			<div>
				<a href="/tp-carrito-compras/carrito/vaciar">Vaciar carrito</a>
			</div>
			<div>
				<a href="/tp-carrito-compras/listarStock">Volver al listado</a>
			</div>
	
		</div>

	</div>
		
	<c:import url="footer.jsp" charEncoding="ISO-8859-1"></c:import>
	
</body>

</html>