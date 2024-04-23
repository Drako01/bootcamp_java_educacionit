package com.educacionit.desafio_07.desafiojava3.excepcion;

@SuppressWarnings("serial")
public class NoCapacityException extends RuntimeException {
    public NoCapacityException(String message) {
        super(message);
    }
}
