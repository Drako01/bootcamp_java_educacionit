package com.educacionit.lombok;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class BuilderDTO {
	
	private final Integer id;
	private final String apellido;
	
}
