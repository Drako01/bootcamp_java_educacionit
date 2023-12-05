package ar.educacionit.ifelse;

public class Ejercicio_02 {

	public static void main(String[] args) {
		char unCaracter = '1';
		
		if (unCaracter >= 65 && unCaracter <= 90) {
			System.out.print(unCaracter + " Es mayuscula");
			
		} else if (unCaracter >= 97 && unCaracter <= 122) {
			System.out.print(unCaracter + " Es minuscula");
		}
		else {
			System.out.print(unCaracter + " No es una Letra");
		}
	}

}
