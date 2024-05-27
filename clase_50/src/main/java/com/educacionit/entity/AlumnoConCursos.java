package com.educacionit.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="alumnos")
public class AlumnoConCursos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombre", nullable = false, length = 255)
	private String nombre;
	
	@Column(name = "legajo", nullable = false)
	private Integer legajo;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name="inscripciones",
		joinColumns = @JoinColumn(name="id_alumno"),
		inverseJoinColumns = @JoinColumn(name="id_curso"))
	List<Curso> cursos;

	public AlumnoConCursos() {
		super();
	}

	public AlumnoConCursos(String nombre, Integer legajo) {
		super();
		this.nombre = nombre;
		this.legajo = legajo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getLegajo() {
		return legajo;
	}

	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
}
