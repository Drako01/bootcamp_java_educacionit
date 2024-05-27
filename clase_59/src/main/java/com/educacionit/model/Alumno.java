package com.educacionit.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Alumno {

	private String nombre;
	private String apellido;
	// Comprendidos entre los valores 1000 y 3000
	private Integer legajo;
	
	private Sexo sexo;
	private Pais pais;
	
	// Numerico y Mayor de 18 años
	private Integer edad;
	
	private List<Materia> materias;
	
	private String avatar;	
	
}
