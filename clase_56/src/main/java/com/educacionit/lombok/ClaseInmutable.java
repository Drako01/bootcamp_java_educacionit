package com.educacionit.lombok;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value //Convierte la Clase en Inmutable, no se puede setear
@AllArgsConstructor
public class ClaseInmutable {

	private Integer id;
	private String apellido;
}
