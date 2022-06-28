<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

 <section class="container-fluid" >

<h3>Insertar Libro</h3>
<form action="libros/insertar" method="post">
	<div class="form-floating mb-3">
		<input type="text" class="form-control" name="titulo" value="${libro.nombre}"> <label for="floatingInput">Titulo</label>
		<span class="text-danger">${libro.errores.nombre}</span>
	</div>
	<div class="form-floating">
		<input type="text" class="form-control" name="categoria"> <label for="floatingPassword">Categoria</label>
	</div>
	<button class="btn btn-primary">Añadir</button>
</form>

</section>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>