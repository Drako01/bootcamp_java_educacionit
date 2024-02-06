package com.educacionit.polimorfismo;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		Empleado unEmpleado = new Empleado("Alejandro", 1000d);
		Gerente unGerente = new Gerente("Daniel", 10000d, "Compras");
		EmpleadoNormal unEmpleadoNormal = new EmpleadoNormal("marcelo", 10000d, "CAT 01");
		
		List<Empleado> listaEmpleados = new ArrayList<>();
		listaEmpleados.add(unEmpleado);
		listaEmpleados.add(unGerente);
		listaEmpleados.add(unEmpleadoNormal);
		
		ManejadorEmpleados.imprimirDetalleEmpleado(listaEmpleados);
		ManejadorEmpleados.imprimirDetalleGerente(listaEmpleados);
	}

}
