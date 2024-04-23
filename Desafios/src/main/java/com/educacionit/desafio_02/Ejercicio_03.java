package com.educacionit.desafio_02;

public class Ejercicio_03 {

	public static void main(String[] args) {
		int n1 = 10;
        int n2 = 20;
        int n3 = 30;

        
        int resultadoSuma = n1 + n2 + n3;
        float resultadoPromedio = resultadoSuma / 3;
        int resultadoMultiplicacion = n2 % n1;
        

        
        System.out.println("El Total: " + resultadoSuma);
        System.out.println("El Promedio: " + resultadoPromedio);
        System.out.println("El Resto entre n2 y n1: " + resultadoMultiplicacion);
        

	}

}
