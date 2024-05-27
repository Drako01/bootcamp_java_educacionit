package com.educacionit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "imagen")
public class Imagen {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	
	/*@Lob
	//@Column(name="imagen_cargada", columnDefinition = "LONGBLOB")
	private byte [] imagenCargada;*/
	
	
	@Lob
	//@Column(name="url_imagen", columnDefinition = "TEXT")
	private String urlImagen;

}
