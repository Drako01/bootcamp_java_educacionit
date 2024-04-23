package com.educacionit.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, String> usuarios = new HashMap<>();

	public LoginServlet() {
		usuarios.put("admin@educacionit.com", "admin123");
		usuarios.put("alejandro@educacionit.com", "admin123");
		usuarios.put("profe@educacionit.com", "admin123");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if (usuarios.containsKey(email) && usuarios.get(email).equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			response.setStatus(HttpServletResponse.SC_OK);
			response.sendRedirect("listaEmpleados.jsp");
		} else {
			response.sendError(HttpServletResponse.SC_FORBIDDEN, "Credenciales incorrectas");
			response.sendRedirect("index.jsp?error=true");
		}
	}
}
