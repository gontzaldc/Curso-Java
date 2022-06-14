<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<title>Usuarios</title>
</head>
<body>

	<table class="table table-striped">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Email</th>
				<th>Contraseña</th>
				<th>Opciones</th>
			</tr>
		</thead>
		<tbody>
			
			<c:forEach items="${usuarios}" var="usuario">
				<a><tr onclick="window.location.href='usuario?id=${usuario.id}&ver=True';">
				
				<th >${usuario.id}</th>
				<td>${usuario.nombre}</td>
				<td>${usuario.email}</td>
				<td>${usuario.contrasena}</td>
				<td><a class="btn btn-info btn-sm" href="usuario?id=${usuario.id}">Modificar</a>
				<a class="btn btn-danger btn-sm" href="borrar?id=${usuario.id}">Borrar</a>
				</td>
				
				</tr>
			
			</c:forEach>
		</tbody>
		
		<tfoot>
		<tr>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td><a class="btn btn-success btn-sm" href="usuario">Añadir</a></td>
		</tr>
		</tfoot>
	</table>

</body>
</html>