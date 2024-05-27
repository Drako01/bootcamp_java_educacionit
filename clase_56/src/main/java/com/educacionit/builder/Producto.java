package com.educacionit.builder;

import com.educacionit.builder.exception.ProductoBuilderException;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Producto {

	private String nombre;
	private String tipo;
	private Double precio;
	private Integer stock;

	public static Builder builder() {
		return new Builder();
	}
	
	private Producto() {
		super();
	}



	static class Builder {
		private String _nombre;
		private String _tipo;
		private Double _precio;
		private Integer _stock;

			
		private Builder() {
			super();
		}

		public Builder nombre(String nombre) {
			if(nombre == null || nombre.isEmpty()) {
				throw new ProductoBuilderException("El Nombre no puede estar Vacio" 
													+ nombre);
			}
			this._nombre = nombre;
			return this;
		}

		public Builder tipo(String tipo) {
			this._tipo = tipo;
			return this;
		}

		public Builder precio(Double precio) {
			if(precio == null || precio <= 0) {
				throw new ProductoBuilderException("El Precio no debe ser Nulo ni menor que 0" 
													+ precio);
			}
			this._precio = precio;
			return this;
		}

		public Builder stock(Integer stock) {
			if(stock == null || stock <= 0) {
				throw new ProductoBuilderException("El Stock no debe ser Nulo ni menor que 0" 
													+ stock);
			}
			this._stock = stock;
			return this;
		}
		
		public Producto build() {
			Producto producto = new Producto();
			if(_nombre == null || _nombre.isEmpty()) {
				throw new ProductoBuilderException("El Nombre no puede estar Vacio" 
													+ _nombre);
			}
			if(_precio == null || _precio <= 0) {
				throw new ProductoBuilderException("El Precio no debe ser Nulo ni menor que 0" 
													+ _precio);
			}
			if(_stock == null || _stock <= 0) {
				throw new ProductoBuilderException("El Stock no debe ser Nulo ni menor que 0" 
													+ _stock);
			}
			producto.nombre = this._nombre;
			producto.tipo = this._tipo;
			producto.precio = this._precio;
			producto.stock = this._stock;
			
			return producto;		
		}
	}
}
