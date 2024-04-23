package com.educacionit.exception;

public class DBManagerObtenerAlumnoException extends DBManagerException {

	private static final long serialVersionUID = 1L;
	
	public DBManagerObtenerAlumnoException(Integer error, String message, Throwable cause) {
		super(error, message, cause);
	}
	public DBManagerObtenerAlumnoException(Integer error, String message) {
		super(error, message);
	}

}
