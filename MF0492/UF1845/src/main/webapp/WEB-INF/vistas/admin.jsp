
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.gontzal.servlets.modelos.Producto,java.util.TreeMap"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<title>Productos</title>
</head>
<body>



	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Nombre</th>
				<th scope="col">Descripcion</th>
				<th scope="col">Stock</th>
				<th scope="col">En venta</th>
				<th scope="col">Opciones</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${productos}" var="producto">

				<tr>

					<th scope="row">${producto.id}</th>
					<td>${producto.nombre}</td>
					<td>${producto.descripcion}</td>
					<td>${producto.stock}</td>
					<td><c:choose>
							<c:when test="${producto.vendiendo}">
								<input type="checkbox" checked disabled >
							</c:when>
							<c:otherwise>
								<input type="checkbox"  disabled >
							</c:otherwise>
						</c:choose></td>
					<td><a href="borrar?id=${producto.id }"
						class="btn btn-danger btn-sm">Borrar</a> <a
						href="modificar?id=${producto.id }" class="btn btn-info btn-sm">Modificar</a>
					</td>

				</tr>
			</c:forEach>

		</tbody>
	</table>
	<ul>


	</ul>

</body>
</html>