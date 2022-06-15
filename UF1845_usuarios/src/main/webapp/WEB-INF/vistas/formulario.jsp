<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Formulario</title>
</head>
<body>

	<h1>Añadir Usuario</h1>
	<form action="usuario" method="post">
		<c:if test="${usuario.id!=null}">
			<div class="form-floating mb-3">
				<input type="text" class="form-control" id="id" name="id" value="${usuario.id}" readonly> <label
					for="id">ID</label>
			</div>
		</c:if>
		<div class="form-floating mb-3">
			<input type="text" class="form-control" id="nombre" name="nombre"
				placeholder="Introduce tu nombre" value="${usuario.nombre}"> <label for="nombre">Nombre</label>
		</div>
		<div class="form-floating mb-3">
			<input type="email" class="form-control" id="email" name="email"
				placeholder="Introduce tu email value="${usuario.email}"> <label for="email">Email</label>
		</div>
		<div class="form-floating mb-3">
			<input type="password" class="form-control" id="contra" name="contra"
				placeholder="Introduce tu contraseña" value="${usuario.contrasena}"> <label for="contra">Contraseña</label>
		</div>
		<button class="btn btn-info">Enviar formulario</button>
	</form>
</body>
</html>