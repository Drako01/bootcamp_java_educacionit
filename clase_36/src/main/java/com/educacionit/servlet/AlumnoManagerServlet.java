package com.educacionit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.educacionit.model.Alumno;
import com.google.gson.Gson;

public class AlumnoManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String legajo = request.getParameter("legajo");
		Gson gson = new Gson();
		
		Alumno unAlumno = new Alumno(Integer.valueOf(legajo), "Alumno de Siempre", 30);
		String alumnoJson = gson.toJson(unAlumno);
		
		response.setContentType("application/json");
		response.getWriter().write(alumnoJson);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
