<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>







<section style="background-color: #eee;">
	<div class="text-center container py-5">
		<h4 class="mt-4 mb-5">
			<strong>Productos</strong>
		</h4>

		<div class="row">

			<c:forEach items="${productos}" var="p">

				<div class="col-lg-4 col-md-12 mb-4">
					<div class="card">
						<c:if test="${p.descuento!=null}">
							<span
								class="position-absolute top-0 start-100 translate-middle badge  bg-danger">
								${p.descuento}% </span>
						</c:if>
						<div class="bg-image hover-zoom ripple"
							data-mdb-ripple-color="light">
							<img
								src="imgs/ordenador.jpg"
								class="w-100" />
						</div>
						<div class="card-body">
							<a href="" class="text-reset">
								<h5 class="card-title mb-3">${p.nombre}</h5>
							</a> <a href="" class="text-reset">
								<p>${p.categoria}</p>
							</a>

							<c:choose>

								<c:when test="${p.descuento!=null}">
									<s>${p.precio}</s>
									<strong class="ms-2 text-danger">${p.precio-((p.precio*p.descuento)/100)}€</strong>
								</c:when>
								<c:otherwise>

									<h6 class="mb-3">${p.precio}€</h6>
								</c:otherwise>
							</c:choose>

						</div>
					</div>
				</div>


			</c:forEach>

		</div>
	</div>
</section>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>