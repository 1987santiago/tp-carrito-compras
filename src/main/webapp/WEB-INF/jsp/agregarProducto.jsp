<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!doctype html>
<html>
<head>
    <title>Agregar Producto</title>
    <link href="<c:url value="/resources/css/normalize.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet" type="text/css">
</head>
<body>

	<div class="wrapper">
	
		<header>
			<h1>Title</h1>
		</header>

		<div data-role="main">

			<div>
				Aca se debe agregar un nuevo Producto.
			</div>
			
			<c:out value="${param}"></c:out>	
		
			<div>
				<a href="/tp-carrito-compras/listarStock">Volver al listado</a>
			</div>

		</div>		

	</div>
	
	<c:import url="footer.jsp" charEncoding="ISO-8859-1"></c:import>
	
</body>

</html>