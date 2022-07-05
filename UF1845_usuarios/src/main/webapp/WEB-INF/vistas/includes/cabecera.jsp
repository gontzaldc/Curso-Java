<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Usuario</title>
<base href="${pageContext.request.contextPath}/">

<link href="CSS/bootstrap.min.css" rel="stylesheet">
<script src="JS/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="CSS/all.min.css">
<link rel="stylesheet" href="CSS/datatables.min.css">
<script src="JS/datatables.min.js"></script>

<script>
	$(function() {
		$('table').DataTable();
	});
</script>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">MyApp</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Home</a></li>
					<c:if test="${sessionScope.usuario.rol == 'ADMIN'}">
						<li class="nav-item"><a class="nav-link"
							href="admin/usuarios">Administración</a></li>
					</c:if>
					<c:if test="${sessionScope.usuario != null}">
						<li class="nav-item"><a class="nav-link" href="libros">libros</a></li>
					</c:if>
				</ul>

			</div>

			<a href="libros/reservas"><i class="fa-solid fa-book"></i> Mis
				libros</a>

			<ul class="navbar-nav mb-2 mb-lg-0">
				<c:choose>
					<c:when test="${sessionScope.usuario != null}">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-bs-toggle="dropdown" aria-expanded="false">
								<span class="navbar-text"> ${sessionScope.usuario.email}
									<i class="fa-solid fa-user"></i>
							</span>
						</a>
							<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
								<li><a class="dropdown-item" href="libros/reservas"><i
										class="fa-solid fa-book"></i> Mis libros</a></li>
								<li><a class="dropdown-item" href="logout"><i
										class="fa-solid fa-arrow-right-from-bracket"></i> Cerrar
										sesión</a></li>

							</ul></li>
					</c:when>
					<c:otherwise>
						<li class="nav-item"><a class="nav-link" aria-current="page"
							href="login">Login <i
								class="fa-solid fa-arrow-right-to-bracket"></i></a></li>
					</c:otherwise>
				</c:choose>

			</ul>
		</div>
	</nav>

	<c:if test="${textoAlerta!=null}">
		<div class="alert alert-${nivelAlerta} alert-dismissible fade show"
			role="alert">
			${textoAlerta}
			<button type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close"></button>
		</div>
	</c:if>
	<main>