
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.gontzal.servlets.modelos.Producto,java.util.TreeMap"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<title>Productos</title>
</head>
<body>

	<%
	Iterable<Producto> productos = (Iterable<Producto>) request.getAttribute("productos");
	%>

	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Nombre</th>
				<th scope="col">Descripcion</th>
				<th scope="col">Stock</th>
				<th scope="col">Opciones</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Producto p : productos) {
			%>
			<tr>

				<th scope="row"><%=p.getId()%></th>
				<td><%=p.getNombre()%></td>
				<td><%=p.getDescripcion()%></td>
				<td><%=p.getStock()%></td>
				<td><a href="borrar?id=<%=p.getId()%>" class="btn btn-danger btn-sm">Borrar</a><a class="btn btn-info btn-sm">Modificar</a></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<ul>


	</ul>

</body>
</html>