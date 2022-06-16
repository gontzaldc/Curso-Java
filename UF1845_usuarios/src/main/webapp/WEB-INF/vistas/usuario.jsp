<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>

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

	<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>