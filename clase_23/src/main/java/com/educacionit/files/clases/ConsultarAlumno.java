package com.educacionit.files.clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ConsultarAlumno {

	HashMap<Integer, Alumno> mapaAlumnos = new HashMap<>();

	public ConsultarAlumno(String file) {
		super();
		preprocesamiento(file);
	}

	public Alumno consultar(Integer legajo) throws Exception {

		if (!mapaAlumnos.containsKey(legajo)) {
			throw new Exception("El Alumno con legajo: " + legajo + " no existe!");
		}
		Alumno alumnoConsultado = mapaAlumnos.get(legajo);

		return alumnoConsultado;
	}

	private void preprocesamiento(String file) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));

			String str;

			while ((str = reader.readLine()) != null) {
				System.out.println(str);

				String[] campos = str.split(",");

				Alumno unAlumno = new Alumno();

				unAlumno.setLegajo(Integer.valueOf(campos[0]));
				unAlumno.setNombre(campos[1]);
				unAlumno.setApellido(campos[2]);
				unAlumno.setEdad(Integer.valueOf(campos[3]));

				System.out.println(unAlumno);
				mapaAlumnos.put(unAlumno.getLegajo(), unAlumno);
			}
			;

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
