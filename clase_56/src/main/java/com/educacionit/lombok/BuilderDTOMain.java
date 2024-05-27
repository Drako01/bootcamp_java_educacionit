package com.educacionit.lombok;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BuilderDTOMain {

	public static void main(String[] args) {
		BuilderDTO builderDTO = BuilderDTO
					.builder()
					.apellido("Apellido")
					.id(1)
					.build();
		

		log.info("Usando Builder {}", builderDTO);
	}

}
