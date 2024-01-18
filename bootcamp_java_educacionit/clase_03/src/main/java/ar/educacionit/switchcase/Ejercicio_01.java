package ar.educacionit.switchcase;

public class Ejercicio_01 {

	public static void main(String[] args) {
		int diaDeLaSemana = 6;
		switch (diaDeLaSemana) {
		case 1:
			System.out.println("El dia de la semana " + diaDeLaSemana + " es Lunes");
			break;
		case 2:
			System.out.println("El dia de la semana " + diaDeLaSemana + " es Martes");
			break;
		case 3:
			System.out.println("El dia de la semana " + diaDeLaSemana + " es Miercoles");
			break;
		case 4:
			System.out.println("El dia de la semana " + diaDeLaSemana + " es Jueves");
			break;
		case 5:
			System.out.println("El dia de la semana " + diaDeLaSemana + " es Viernes");
			break;
		case 6:
			System.out.println("El dia de la semana " + diaDeLaSemana + " es Sábado");
			break;
		case 7:
			System.out.println("El dia de la semana " + diaDeLaSemana + " es Domingo");
			break;
		default: 
			System.out.println("El valor " + diaDeLaSemana + " se encuentra fuera de Rango");
		}
		System.out.println("Fin del Main");
	}

}
