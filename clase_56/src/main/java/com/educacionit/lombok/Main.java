package com.educacionit.lombok;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

	public static void main(String[] args) {
		MiClase miClase = new MiClase();
	
		miClase.setEdad(10);
		miClase.setNombre("Alejandro");
		
		
		log.info("Clase {}: ", miClase);

	}

}
