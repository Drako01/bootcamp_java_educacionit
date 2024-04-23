<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Baja de Alumno</title>
</head>
<body>
    <h2>
        Session ID:
        <%=request.getSession().getId()%>
    </h2>
    <h2>Baja Alumno</h2>
    <form action="BorrarAlumnoServlet" method="post">

        <select name="legajo">
            <c:forEach items="${listaAlumnos}" var="alumno">
                <option value="${alumno.legajo}">${alumno.legajo} - ${alumno.nombre}</option>
            </c:forEach>
        </select> 
        <input type="submit" value="Borrar Alumno">

    </form>

    <c:if test="${not empty mensaje}">
		<h3>${mensaje}</h3>
	</c:if>
	
    <a href="index.jsp">Home</a>
</body>
</html>