package com.educacionit.entity3;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "proyecto")
public class Proyecto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;

	@OneToMany(mappedBy = "proyecto")
	private List<Tarea> tareas;
	
	@ManyToMany
	@JoinTable(
				name = "proyecto_empleado",
				joinColumns = @JoinColumn(name = "proyecto_id"),
				inverseJoinColumns = @JoinColumn(name = "empleado_id")
			)
	private List<Empleado> empleados;
	
}
