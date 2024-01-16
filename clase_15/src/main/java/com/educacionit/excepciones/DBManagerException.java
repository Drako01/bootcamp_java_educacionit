package com.educacionit.excepciones;

public class DBManagerException extends Exception {

	public DBManagerException(String message) {
		super(message);
	}

	public DBManagerException(Throwable cause) {
		super(cause);
	}

	public DBManagerException(String message, Throwable cause) {
		super(message, cause);
		
	}	

}
