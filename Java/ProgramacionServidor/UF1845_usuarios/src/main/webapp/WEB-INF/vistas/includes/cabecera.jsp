<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Usuario</title>
<base href="${pageContext.request.contextPath}/">

<link href="CSS/bootstrap.min.css" rel="stylesheet">
<script src="JS/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="CSS/all.min.css">
<link rel="stylesheet" href="CSS/datatables.min.css">
<script src="JS/datatables.min.js"></script>

<script>
	$(function() {
		$('table').DataTable();
	});
</script>
</head>
<body>

	

	<c:if test="${textoAlerta!=null}">
		<div class="alert alert-${nivelAlerta} alert-dismissible fade show"
			role="alert">
			${textoAlerta}
			<button type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close"></button>
		</div>
	</c:if>
	<main>