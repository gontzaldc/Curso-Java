<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

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
				placeholder="Introduce tu email" value="${usuario.email}"> <label for="email">Email</label>
		</div>
		<div class="form-floating mb-3">
			<input type="password" class="form-control" id="contra" name="contra"
				placeholder="Introduce tu contraseña" value="${usuario.contrasena}"> <label for="contra">Contraseña</label>
		</div>
		<button class="btn btn-info">Enviar formulario</button>
	</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>