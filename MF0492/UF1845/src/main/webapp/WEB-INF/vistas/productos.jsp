
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.gontzal.servlets.modelos.Producto,java.util.TreeMap"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<body class="row">



	<c:forEach items="${productos}" var="producto">
		<div class="card" style="width: 18rem;">
			<img src="https://via.placeholder.com/150" class="card-img-top"
				alt="...">
			<div class="card-body">
				<h5 class="card-title">${producto.nombre}</h5>
				<p class="card-text">Quedan ${producto.stock} unidades</p>
				<p class="card-text">${producto.descripcion}</p>
				<a href="producto?id=${producto.id}" class="btn btn-primary">Ver
					producto</a>
			</div>
		</div>

	</c:forEach>


</body>
</html>