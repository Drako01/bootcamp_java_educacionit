package com.educacionit.exception;

public class DBManagerException extends Exception {

	private static final long serialVersionUID = 1L;
	public static final int ERROR_1 = 1;
	public static final int ERROR_2 = 2;
	public static final int ERROR_3 = 3;
	public static final int ERROR_4 = 4;
	public static final int ERROR_5 = 5;
	public static final int ERROR_6 = 6;
	public static final int ERROR_7 = 7;
	public static final int ERROR_8 = 8;

	private Integer error;

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
	
	/*
	 * Error 1: conectar 
	 * Error 2: mostrar alumnos 
	 * Error 3: obtener alumnos 
	 * Error 4: obtener alumno 
	 * Error 5: insertar 
	 * Error 6: modificar 
	 * Error 7: eliminar alumno
	 * Error 8: cerrar conexion a la db
	 */
	
	public Integer getErroCode() {
		return error;
	}
	

	@Override
	public String getMessage() {
		switch (error) {
		case ERROR_1:
			return "Se produjo un error conectando a la DB. Error: " + super.getMessage();
		case ERROR_2:
			return "Se produjo un error mostrando alumnos. Error: " + super.getMessage();
		case ERROR_3:
			return "Se produjo un error abteniendo alumnos. Error: " + super.getMessage();
		case ERROR_4:
			return "Se produjo un error obteniendo un alumno. Error: " + super.getMessage();
		case ERROR_5:
			return "Se produjo un error insertando un alumno. Error: " + super.getMessage();
		case ERROR_6:
			return "Se produjo un error modificando un alumno. Error: " + super.getMessage();
		case ERROR_7:
			return "Se produjo un error eliminando un alumno. Error: " + super.getMessage();
		case ERROR_8:
			return "Se produjo un error cerrando la coneccion con la DB. Error: " + super.getMessage();
		default:
			return super.getMessage();
		}
	}

}
