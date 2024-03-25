package com.educacionit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.educacionit.model.Alumno;

public class BuscarAlumnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String unLegajo = request.getParameter("legajo");
			
			if(unLegajo == null || unLegajo.length() == 0) {
				throw new Exception("El legajo es nulo");
			}
			
			HttpSession session = request.getSession();

			Map<String, Alumno> alumnos = (Map<String, Alumno>) session.getAttribute("listaAlumnos");

			if (alumnos == null) {
				alumnos = new HashMap<String, Alumno>();
				session.setAttribute("listaAlumnos", alumnos);
			}

			Alumno unAlumno = alumnos.get(unLegajo);

			if (unAlumno == null) {
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			} else {
				String respuesta = "{\"Legajo\":\"" + unAlumno.getLegajo() 
									+ "\", \"Nombre\":\"" + unAlumno.getNombre()
									+ "\", \"Edad\": \"" + unAlumno.getEdad() + "\"}";
				PrintWriter writer = response.getWriter();
				writer.print(respuesta);
				response.setStatus(HttpServletResponse.SC_OK);
				writer.flush();
				writer.close();
			}
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}

}
