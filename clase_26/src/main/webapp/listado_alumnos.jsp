<%@page session="true"%>
<%@page errorPage="error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Listado de Alumnos</title>
<link rel="stylesheet" href="./css/styles.css">

</head>
<body>

	<h2>
		Session ID:
		<%=request.getSession().getId()%>
	</h2>

	<hr>


	<h2>Listado de Alumnos</h2>

	<table border="1">
		<tr>
			<th>Legajo</th>
			<th>Nombre</th>
			<th>Edad</th>
		</tr>
		<c:forEach items="${listaAlumnos}" var="alumno">
			<tr>
				<td>${alumno.legajo}</td>
				<td>${alumno.nombre}</td>
				<td>${alumno.edad}</td>
			</tr>
		</c:forEach>
	</table>
	<hr>

	<h3>
		<a href="alta_alumno.jsp">Alta Alumno</a>
	</h3>
	<h3>
		<a href="BorrarAlumnoServlet">Baja Alumno</a>
	</h3>
	<br>
	<h3>
		<a href="LimpiarSessionServlet">Limpiar Sesion</a>
	</h3>

</body>
</html>