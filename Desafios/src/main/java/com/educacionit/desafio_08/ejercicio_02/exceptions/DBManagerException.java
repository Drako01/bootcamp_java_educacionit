package com.educacionit.desafio_08.ejercicio_02.exceptions;

public class DBManagerException extends Exception {

	private static final long serialVersionUID = 1L;

	private Integer error;
	public static final int ERROR_1 = 1;
	public static final int ERROR_2 = 2;
	public static final int ERROR_3 = 3;
	public static final int ERROR_4 = 4;

	public DBManagerException(Integer error) {
		super();
		this.error = error;
	}

	public DBManagerException(Integer error, String message) {
		super(message);
		this.error = error;
	}

	public DBManagerException(Integer error, Throwable cause) {
		super(cause);
		this.error = error;
	}

	public DBManagerException(Integer error, String message, Throwable cause) {
		super(message, cause);
		this.error = error;

	}

	public Integer getErrorCode() {
		return error;
	}

	@Override
	public String getMessage() {
		switch (error) {
		case ERROR_1:
			return "Error al mostrar a las provincias. \nError: " + super.getMessage();
		case ERROR_2:
			return "Error al obtener las provincias. \nError: " + super.getMessage();
		case ERROR_3:
			return "Error al mostrar la provincia. \nError: " + super.getMessage();
		case ERROR_4:
			return "Error al insertar la provincia. \nError: " + super.getMessage();
		default:
			return super.getMessage();
		}
	}
}
