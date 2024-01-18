package com.educacionit.excepciones;

public class DBManagerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 
	 * Error 1: conectar
	 * Error 2: mostrarAlumnos
	 * Error 3: obtenerAlumnos
	 * Error 4: obtenerAlumno
	 * Error 5: insertarAlumno
	 * Error 6: modificarAlumno
	 * Error 7: eliminarAlumno
	 * Error 8: cerrarConexion 
	 */
	private Integer error;
	public static final int ERROR_1 = 1;
	public static final int ERROR_2 = 2;
	public static final int ERROR_3 = 3;
	public static final int ERROR_4 = 4;
	public static final int ERROR_5 = 5;
	public static final int ERROR_6 = 6;
	public static final int ERROR_7 = 7;
	public static final int ERROR_8 = 8;
	
	
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

	@Override
	public String getMessage() {
		switch (error) {
		case ERROR_1:
			return "La conexión a la Base de datos Falló. Error: " + super.getMessage();
		case ERROR_2:
			return "La conexión a la Base de datos Falló" + super.getMessage();
		case ERROR_3:
			return "La conexión a la Base de datos Falló" + super.getMessage();
		case ERROR_4:
			return "La conexión a la Base de datos Falló" + super.getMessage();
		case ERROR_5:
			return "La conexión a la Base de datos Falló" + super.getMessage();
		case ERROR_6:
			return "La conexión a la Base de datos Falló" + super.getMessage();
		case ERROR_7:
			return "La conexión a la Base de datos Falló" + super.getMessage();
		case ERROR_8:
			return "La conexión a la Base de datos Falló" + super.getMessage();
		default:
			return super.getMessage();
		}
	}
}
