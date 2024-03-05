package com.educacionit.enums;

public enum DiasSemanaSobrecargado {
	LUNES(1, "Arranca la semana"), 
	MARTES(2, "Continuamos con ganas"), 
	MIERCOLES(3, "Pensamos en el Finde"), 
	JUEVES(4, "Vamos terminando"), 
	VIERNES(5, "Ultimo diaaaa"), 
	SABADO(6, "Descansamos"), 
	DOMINGO(7, "Hoy Pasta.!");
	
	private Integer orden;
	private String descripcion;
	private DiasSemanaSobrecargado(Integer orden, String descripcion) {
		this.orden = orden;
		this.descripcion = descripcion;
	}
	public Integer getOrden() {
		return orden;
	}
	public String getDescripcion() {
		return descripcion;
	}
	
	
}
