<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<form action="login" method="post">
	
	<div class="form-floating mb-3">
		<input type="email" class="form-control" id="email" name="email"
			placeholder="Introduce tu email" value="${usuario.email}"> <label
			for="email">Email</label>
	</div>
	<div class="form-floating mb-3">
		<input type="password" class="form-control" id="password" name="password"
			placeholder="Introduce tu contraseña">
		<label for="password">Contraseña</label>
	</div>
	<button class="btn btn-primary">Iniciar sesión</button>
	<span class="text-danger">${error}</span>
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>