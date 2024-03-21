package com.educacionit.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.educacionit.model.Alumno;

public class GuardarAlumnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String legajo = request.getParameter("legajo");
			String nombre = request.getParameter("nombre");
			String edad = request.getParameter("edad");

			HttpSession session = request.getSession();

			Alumno unAlumno = new Alumno(Integer.valueOf(legajo), nombre, Integer.valueOf(edad));

			Map<String, Alumno> alumnos = (Map<String, Alumno>) session.getAttribute("listaAlumnos");

			if (alumnos == null) {
				alumnos = new HashMap<String, Alumno>();
				session.setAttribute("listaAlumnos", alumnos);
			}

			alumnos.put(legajo, unAlumno);

			response.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}

}
