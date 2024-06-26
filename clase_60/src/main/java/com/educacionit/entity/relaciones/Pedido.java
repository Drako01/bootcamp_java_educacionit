package com.educacionit.entity.relaciones;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
//@Entity
@Table(name = "pedidos")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Double total;
	
	@ManyToOne
	@JoinColumn(name="cliente_id")	
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="descuento_id")	
	private Descuento descuento;
	
}
