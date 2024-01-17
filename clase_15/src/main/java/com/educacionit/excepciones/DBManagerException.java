package com.educacionit.excepciones;

public class DBManagerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer codigo;
	public DBManagerException(Integer codigo) {
		super();
		this.codigo = codigo;
	}

	public DBManagerException(String message) {
		super(message);
	}
	
	public DBManagerException(Throwable cause) {
		super(cause);
	}

	public DBManagerException(String message, Throwable cause) {
		super(message, cause);
		
	}	

	@Override
	public String getMessage() {
		switch (codigo) {
		case 1:
			return "La conexión a la Base de datos Falló";
		case 2:
			return "La Base de datos tiene otro Nombre";			
		case 3:
			return "La tabla no existe en la Base de datos";			
		default:
			return super.getMessage();
		}
	}
}
