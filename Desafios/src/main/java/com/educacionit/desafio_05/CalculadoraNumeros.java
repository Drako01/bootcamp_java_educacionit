package com.educacionit.desafio_05;
//Ejercicio_01

public class CalculadoraNumeros {
    private int suma;
    private int numeroMayor;
    private int numeroMenor;
    private boolean primerNumeroIngresado;

    // Constructor
    public CalculadoraNumeros() {
        this.suma = 0;
        this.numeroMayor = 0;
        this.numeroMenor = 0;
        this.primerNumeroIngresado = false;
    }

    public void procesarNumero(int numero) {
        suma += numero;

        if (!primerNumeroIngresado || numero > numeroMayor) {
            numeroMayor = numero;
        }

        if (!primerNumeroIngresado || numero < numeroMenor) {
            numeroMenor = numero;
        }

        primerNumeroIngresado = true;
    }

    public int obtenerSuma() {
        return suma;
    }

    public int obtenerNumeroMayor() {
        return numeroMayor;
    }

    public int obtenerNumeroMenor() {
        return numeroMenor;
    }
}