<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

	<table class="table table-striped table-hover">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Email</th>
				<th>Contraseña</th>
				<th>Opciones</th>
			</tr>
		</thead>
		<tbody>
			
			<c:forEach items="${usuarios}" var="usuario">
				<a><tr onclick="window.location.href='admin/usuario?id=${usuario.id}&ver=True';">
				
				<th >${usuario.id}</th>
				<td>${usuario.nombre}</td>
				<td>${usuario.email}</td>
				<td>${usuario.contrasena}</td>
				<td><a class="btn btn-info btn-sm" href="admin/usuario?id=${usuario.id}">Modificar</a>
				<a class="btn btn-danger btn-sm" href="admin/borrar?id=${usuario.id}">Borrar</a>
				</td>
				
				</tr>
			
			</c:forEach>
		</tbody>
		
		<tfoot>
		<tr>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td><a class="btn btn-success btn-sm" href="admin/usuario">Añadir</a></td>
		</tr>
		</tfoot>
	</table>

<p>asdasdsa</p>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>