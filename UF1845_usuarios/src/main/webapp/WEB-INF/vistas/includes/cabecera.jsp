<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Usuario</title>
<base href="${pageContext.request.contextPath}/">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
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
					<c:if test="${sessionScope.usuario != null}">
						<li class="nav-item"><a class="nav-link"
							href="admin/usuarios">Administración</a></li>
					</c:if>
				</ul>

			</div>
			<span class="navbar-text"> ${sessionScope.usuario.email} </span>
			<ul class="navbar-nav mb-2 mb-lg-0">
				<c:choose>
					<c:when test="${sessionScope.usuario == null}">
						<li class="nav-item"><a class="nav-link" href="login">Login</a></li>
					</c:when>
					<c:otherwise>
						<li class="nav-item"><a class="nav-link" href="logout">Logout</a></li>
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
	</div></c:if>