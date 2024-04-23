package com.educacionit.constructor;

public class ArticuloCientifico {
	private String titulo;
	private String autor;
	private String nombre;
	private String palabrasClaves;
	private int anioPublicacion;
	private String resume;

	public ArticuloCientifico() { // Constructor Default
	}

	public ArticuloCientifico(String titulo, String autor) {
		this.titulo = titulo;
		this.autor = autor;

	}

	public ArticuloCientifico(String titulo, String autor, String nombre, String palabrasClaves, int anioPublicacion,
			String resume) {
		this(titulo, autor);
		this.autor = nombre;
		this.palabrasClaves = palabrasClaves;
		this.anioPublicacion = anioPublicacion;
		this.resume = resume;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPalabrasClaves() {
		return palabrasClaves;
	}

	public int getAnioPublicacion() {
		return anioPublicacion;
	}

	public String getResume() {
		return resume;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
