<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>


<table class="table table-striped table-hover">
	<thead>
		<tr>
			<th>ID</th>
			<th>Nombre</th>
			<th>Descripcion</th>
			<th>Stock</th>
		</tr>
	</thead>
	<tbody>

		<c:forEach items="${productos}" var="producto">

			<tr>
				<th>${producto.id}</th>
				<td>${producto.nombre}</td>
				<td>${producto.descripcion}</td>
				<td>${producto.stock}</td>

			</tr>

		</c:forEach>
	</tbody>


</table>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>