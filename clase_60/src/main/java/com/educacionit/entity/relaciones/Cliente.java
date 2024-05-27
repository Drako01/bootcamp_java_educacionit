package com.educacionit.entity.relaciones;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
//@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private String apellido;
	private LocalDate fechaDeRegistro;
	private Boolean activo;
	
	@Enumerated(EnumType.STRING)
	private TipoCliente tipoCliente;
	
}
