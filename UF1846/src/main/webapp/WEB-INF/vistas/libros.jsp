<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<table class="table">
	<thead>
		<tr>
			<th scope="col">ID</th>
			<th scope="col">Nombre</th>
			<th scope="col">Categoria</th>
			<th scope="col">Disponibilidad</th>
			<c:if test="${sessionScope.usuario!=null}">
				<th scope="col">Opciones</th>
			</c:if>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${libros}" var="l">


			<tr>
				<th scope="row">${l.id}</th>
				<td>${l.nombre}</td>
				<td>${l.categoria}</td>
				<c:choose>
					<c:when test="${l.disponible}">
						<td><i class="fa-solid fa-check"></i></td>
						<c:if test="${sessionScope.usuario!=null}">
							<td><a class="btn btn-info btn-sm"
								href="libros/hacer-reserva?idLibro=${l.id}&email=${sessionScope.usuario.email}">Reservar</a></td>
						</c:if>
					</c:when>
					<c:otherwise>
						<td><i class="fa-solid fa-xmark"></i></td>
						<td><a href="#" class="btn secondary btn-sm disabled" role="button" aria-disabled="true">Reservar</a></td>
					</c:otherwise>
				</c:choose>

			</tr>

		</c:forEach>

	</tbody>
</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>