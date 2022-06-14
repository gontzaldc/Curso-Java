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
<title>Usuario</title>
</head>
<body>
	<c:set var="id" scope="session" value="${usuario.id}" />
	<c:if test="${id!=null}">

		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nombre</th>
					<th>Email</th>
					<th>Contraseña</th>
				</tr>
			</thead>
			<tbody>

				<tr>

					<th>${usuario.id}</th>
					<td>${usuario.nombre}</td>
					<td>${usuario.email}</td>
					<td>${usuario.contrasena}</td>


				</tr>

			</tbody>
		</table>
	</c:if>

</body>
</html>