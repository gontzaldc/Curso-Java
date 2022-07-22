<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>




<ul class="nav nav-tabs card-header-tabs" data-bs-tabs="tabs">
	<li class="nav-item"><a class="nav-link active"
		aria-current="true" data-bs-toggle="tab" href="admin#tabUsuarios">Usuarios</a></li>
	<li class="nav-item"><a class="nav-link" data-bs-toggle="tab"
		href="admin#tabLibros">Libros</a></li>
</ul>

<div class="card-body tab-content">
	<div class="tab-pane active" id="tabUsuarios">

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
					<tr onclick="window.location.href='admin/usuario?id=${usuario.id}">

						<th>${usuario.id}</th>
						<td>${usuario.nombre}</td>
						<td>${usuario.email}</td>
						<td>${usuario.contrasena}</td>
						<td><a class="btn btn-info btn-sm"
							href="admin/usuario?id=${usuario.id}">Modificar</a> <a
							class="btn btn-danger btn-sm"
							href="admin/borrar?id=${usuario.id}">Borrar</a></td>

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

	</div>
	<div class="tab-pane" id="tabLibros">

		<table id="tablaLibros" class="display table table-striped"
			style="width: 100%">
			<thead>
				<tr>
					<th>Id</th>
					<th>Titulo</th>
					<th>Categoria</th>
					<th>Disponibilidad</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${libros}" var="l">
					<tr>
						<td>${l.id}</td>
						<td>${l.nombre}</td>
						<td>${l.categoria}</td>
						<td>${l.disponible}</td>
					</tr>
				</c:forEach>

			</tbody>
			<tfoot>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td><a class="btn btn-primary btn-sm" href="libros/insertar">Añadir</a></td>
				</tr>
			</tfoot>
		</table>

	</div>

</div>


<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>