package ar.educacionit.ifelse;

public class Ejercicio_03 {

	public static void main(String[] args) {
		float nota1, nota2, nota3;
		int cantidadDeNotasMayoresQue4 = 0;
		int cantidadDeNotasMenoresQue4 = 0;
		
		float promedio;
		
		nota1 = 7.2F;
		nota2 = 2.49F;
		nota3 = 5.6F;
		
		promedio = (nota1 + nota2 + nota3) / 3;
		
		if (promedio >= 6.59) {
			System.out.println("El Promedio supera los 6.59 puntos");
		} else {
			System.out.println("El promedio no supera los 6.59 puntos");			
		}
		
		if(nota1 > 4) {
			cantidadDeNotasMayoresQue4 ++;
		} else {
			cantidadDeNotasMenoresQue4 ++;
		}
		if(nota2 > 4) {
			cantidadDeNotasMayoresQue4 ++;
		} else {
			cantidadDeNotasMenoresQue4 ++;
		}
		if(nota3 > 4) {
			cantidadDeNotasMayoresQue4 ++;
		} else {
			cantidadDeNotasMenoresQue4 ++;
		}
		
		System.out.println("Cantidad De Notas Mayores Que 4 " + cantidadDeNotasMayoresQue4);
		System.out.println("Cantidad De Notas Menores Que 4 " + cantidadDeNotasMenoresQue4);
	}

}
