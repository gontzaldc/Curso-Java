<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<title>Modificar</title>
</head>
<body class="container">
	<h3>Modificar producto con ID: ${producto.id}</h3>

	<form action="modificar" method="post">
		<div class="form-floating mb-3" hidden>
			<input type="text" class="form-control" id="id" name="id"
				placeholder="Introduce tu id" value="${producto.id}"> <label
				for="id">id</label>
		</div>
		<div class="form-floating mb-3">
			<input type="text" class="form-control" id="nombre" name="nombre"
				placeholder="Introduce tu nombre" value="${producto.nombre}">
			<label for="nombre">Nombre</label>
		</div>
		<div class="form-floating mb-3">
			<input type="text" class="form-control" id="stock" name="stock"
				placeholder="La cantidad de stock" value="${producto.stock}">
			<label for="stock">Stock</label>
		</div>
		<div class="form-floating mb-3">
			<input type="text" class="form-control" id="descripcion"
				name="descripcion" placeholder="Introduce la descripcion"
				value="${producto.descripcion}"> <label for="descripcion">Descripcion</label>
		</div>
		<div class="mb-3 form-check">

			<c:choose>
				<c:when test="${producto.vendiendo}">
					<input type="checkbox" class="form-check-input" id="vendiendo"
						name="vendiendo" checked>
				</c:when>
				<c:otherwise>
					<input type="checkbox" class="form-check-input" id="vendiendo"
						name="vendiendo">
				</c:otherwise>
			</c:choose>

			<label class="form-check-label" for="vendiendo">En venta</label>
		</div>

		<button class="btn btn-primary">Modificar</button>
	</form>

</body>
</html>