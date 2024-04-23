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
			<h1>Desafio #08 | Educación IT</h1>

		</section>
		<section class=" bienvenido">
			<h2>Iniciar Sesión</h2>

			<form action="LoginServlet" method="post"
				class="d-flex column center">

				<input type="email" id="email" name="email" required
					placeholder="Ingrese su Email"> <input type="password"
					id="password" name="password" required
					placeholder="Ingrese su Password"><br> <br> <input
					type="submit" value="Iniciar Sesión" class="btn">
			</form>
			<section class="d-flex column center bienvenido mensaje">
				<%
				String error = request.getParameter("error");
				if (error != null && error.equals("true")) {
				%>
				<h3 style="color: red;">Credenciales incorrectas</h3>
				<%
				}
				%>
				<%
				String logout = request.getParameter("logout");
				if (logout != null && logout.equals("true")) {
					out.println("<h3 style='color: green;'>Sesión cerrada correctamente</h3>");
				}
				%>

			</section>
		</section>
	</main>
	<footer class="footer center">
		<p>Educación IT | &copy;</p>
		<p id="hora"></p>
	</footer>
	<script type="text/javascript" src="static/js/reloj.js"></script>

</body>
</html>
