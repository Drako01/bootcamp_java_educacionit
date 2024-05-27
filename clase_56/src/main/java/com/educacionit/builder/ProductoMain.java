package com.educacionit.builder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductoMain {

	public static void main(String[] args) {
		Producto p = Producto
				.builder()
				.nombre("Azucar")
				.tipo("Almacen")
				.stock(10)
				.precio(1080.50)
				.build();

		log.info("{} {}", "\n" + p, "\n" + p.getNombre());

	}

}
