package com.educacionit.polimorfismo;

import java.util.List;

public class ManejadorEmpleados {

	public static <T extends Empleado> void imprimirDetalleEmpleado(List<T> listaEmpleados) {

		for (T unEmplado : listaEmpleados) {
			System.out.println("Nombre: " + unEmplado.getNombre());
			System.out.println("Nombre: " + unEmplado.getSalario());
			System.out.println();
		}

	}
	
	public static <T extends Empleado> void imprimirDetalleGerente(List<T> listaEmpleados) {

		for (T unEmplado : listaEmpleados) {
			if(unEmplado instanceof Gerente) {
				
				Gerente unGerente = (Gerente)unEmplado;
				unGerente.getDepartamento();
			}
			
		}

	}
}
