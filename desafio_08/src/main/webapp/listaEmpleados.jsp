<!DOCTYPE html>
<html lang="es-AR">
<head>
<meta charset="UTF-8" />
<meta http-equiv="expires" content="0">
<meta http-equiv="Cache-Control">
<meta http-equiv="Pragma" content="no-cache">

<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Desafio 08 | Educación IT</title>
<link rel="stylesheet" type="text/css" href="static/css/style.css">

</head>
<body>
	<header>
		<%
		if (session.getAttribute("email") != null) {
		%>
		<p>
			Bienvenido,
			<%=session.getAttribute("email")%>!
		</p>
		<%
		} else {
		%>
		<p>No has iniciado sesión aún.</p>
		<%
		}
		%>
	</header>
	<main>
		<section class="d-flex column center bienvenido">
			<h1>Formulario Empleados</h1>

		</section>
		<section class="d-flex column center bienvenido">
			<table class="table ">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nombre y Apellido</th>
						<th>Sector</th>
					</tr>
				</thead>
				<tbody id="tablaEmpleados">
				</tbody>
			</table>
			<br>
			<h2 class="session-id">
				ID de sesión:
				<%=session.getId()%>
			</h2>
			<form action="LogoutServlet" method="post"
				class="d-flex column center logout-form">
				<input type="submit" value="Cerrar Sesión" class="btn">
			</form>
		</section>
	</main>
	<footer class="footer center">
		<p>Educación IT | &copy;</p>
		<p id="hora"></p>
	</footer>


	<script type="text/javascript" src="static/js/index.js"></script>
	<script type="text/javascript" src="static/js/reloj.js"></script>

</body>
</html>
