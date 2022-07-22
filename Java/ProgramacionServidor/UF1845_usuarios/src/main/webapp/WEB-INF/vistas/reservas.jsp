<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<table class="table">
	<thead>
		<tr>
			<th scope="col">ID</th>
			<th scope="col">Libro</th>
			<th scope="col">Usuario</th>
			<th scope="col">Fecha Reservado</th>
			<th scope="col">Opciones</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${reservas}" var="r">


			<tr>
				<th scope="row">${r.id}</th>
				<td>${r.libro.nombre}</td>
				<td>${r.email}</td>
				<td>${r.fecha}</td>
				<td><a class="btn btn-sm btn-primary" href="libros/devolver?id=${r.id}&idL=${r.libro.id}">Devolver</a></td>


			</tr>

		</c:forEach>

	</tbody>
</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>