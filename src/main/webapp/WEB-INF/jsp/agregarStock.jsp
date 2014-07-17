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
			
			<form:form method="post" action="/tp-carrito-compras/producto/agregarStock" modelAttribute="producto">
				<input type="hidden" id="nombreProducto" name="nombreProducto" value="${producto}" />
				<div>
					<label for="cantidadProducto">Cantidad de unidades: </label>
					<input type="number" id="cantidadProducto" name="cantidadProducto" />
				</div>
				<input type="submit" value="sumar stock" disabled="disabled"/>
			</form:form>
						
			<div>
				<a href="/tp-carrito-compras/listarStock">Volver al listado</a>
			</div>
	
		</div>

	</div>
		
	<c:import url="footer.jsp" charEncoding="ISO-8859-1"></c:import>
	
	<script type="text/javascript">
		var form = document.getElementById('producto'),
			submitBtn = form.querySelector("input[type=submit]");
		
		form.cantidadProducto.onchange = function(event) {

			if (form.cantidadProducto.value !== '' && form.cantidadProducto.value > 0) {
				submitBtn.disabled = false;
			} else if (form.cantidadProducto.value <= 0) {
				submitBtn.disabled = true;				
			}
			
		};
	</script>
	
</body>

</html>