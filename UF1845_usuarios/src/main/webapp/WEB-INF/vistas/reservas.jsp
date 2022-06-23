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
			<th scope="col">Fecha Devolución</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${reservas}" var="r">


			<tr>
				<th scope="row">${r.id}</th>
				<td>${r.libro.nombre}</td>
				<td></td>
				<td>${r.fecha}</td>


			</tr>

		</c:forEach>

	</tbody>
</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>