package com.educacionit.lombok;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClaseInmutableMain {

	public static void main(String[] args) {
		ClaseInmutable claseInmutable = new ClaseInmutable(10, "Apellido");
		
		claseInmutable.getApellido();
		claseInmutable.getId();
		
		log.info("ClaseInmutable {}", claseInmutable.getApellido());
		log.info("ClaseInmutable {}", claseInmutable);
	}

}
