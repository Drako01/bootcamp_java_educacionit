package com.educacionit.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Persona {

	private String nombre;	
	private Integer edad;
	private String sexo;
}
