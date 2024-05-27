package com.educacionit.entity3;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "empleado")
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;

	@ManyToMany(mappedBy = "empleados")	
	private List<Proyecto> proyectos;
	
}
