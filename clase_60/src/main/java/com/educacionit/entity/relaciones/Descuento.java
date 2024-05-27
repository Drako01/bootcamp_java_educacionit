package com.educacionit.entity.relaciones;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
//@Entity
@Table(name = "descuentos")
public class Descuento {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		private String descripcion;
		
		private Double porcentaje;

}
