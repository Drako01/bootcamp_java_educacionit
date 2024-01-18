package ar.educacionit.switchcase;

public class Ejercicio_02 {

	public static void main(String[] args) {
		int unValor = 10;
		
		switch (unValor ) {
		case 1:
		case 2:
		case 3:
		case 4:
			System.out.println("Menor que Cinco, o menor o igual que cuatro");
			break;
		case 5:
			System.out.println("Igual a Cinco");
			break;
		case 6:
		case 7:
		case 8:
		case 9:
			System.out.println("Es mayor que cinco y menor que diez");
			break;
		default :
			System.out.println("Es mayor o igual a 10");
		}
		System.out.println("Fin Main");
	}

}
