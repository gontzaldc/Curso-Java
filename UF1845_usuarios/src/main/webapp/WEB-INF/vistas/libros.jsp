<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<table class="table">
	<thead>
		<tr>
			<th scope="col">ID</th>
			<th scope="col">Nombre</th>
			<th scope="col">Categoria</th>
			<th scope="col">Opciones</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${libros}" var="l">


			<tr>
				<th scope="row">${l.id}</th>
				<td>${l.nombre}</td>
				<td>${l.categoria}</td>
				<c:if test="${sessionScope.usuario!=null}">
				<td><a class="btn btn-info btn-sm"href="libros/hacer-reserva?idLibro=${l.id}&idUsuario=1">Reservar</a></td>
				</c:if>
			</tr>
			
		</c:forEach>

	</tbody>
</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>