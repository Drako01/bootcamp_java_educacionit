package com.educacionit.desafio_07.desafiojava3;

import com.educacionit.desafio_07.desafiojava3.clase.CollectionCustom;
import com.educacionit.desafio_07.desafiojava3.excepcion.NoCapacityException;

public class Main {
    public static void main(String[] args) {
        try {
            CollectionCustom<Integer> coleccion = new CollectionCustom<>();

            System.out.println("isEmpty: " + coleccion.empty());

            coleccion.addFirst(1);
            coleccion.add(2);
            coleccion.add(3);
            coleccion.add(4);
            //coleccion.add(4); // Agregar esta linea para enviar la Exception
            coleccion.remove(1);
            coleccion.addLast(3);

            System.out.println("Coleccion: " + coleccion);
            
            coleccion.removeAllWhithDate(3);
            System.out.println("Coleccion: " + coleccion);
            coleccion.add(2);
            System.out.println("Coleccion: " + coleccion);
            coleccion.remove(2);
            System.out.println("Coleccion: " + coleccion);
            System.out.println("isEmpty: " + coleccion.empty());

            CollectionCustom<String> coleccionString = new CollectionCustom<>();

            System.out.println("isEmpty: " + coleccionString.empty());

            coleccionString.addFirst("Hola");
            coleccionString.add("como");
            coleccionString.add("estan");
            coleccionString.add("todos");
            
            System.out.println("Coleccion: " + coleccionString);
            coleccionString.remove("todos");
            coleccionString.addLast("ustedes");

            System.out.println("Coleccion: " + coleccionString);
            System.out.println("isEmpty: " + coleccionString.empty());
            coleccionString.removeAll();
            System.out.println("Coleccion: " + coleccionString);
            System.out.println("isEmpty: " + coleccionString.empty());
        } catch (NoCapacityException e) {
            System.out.println(e.getMessage());
        } finally {
        	System.out.println("Gracias por probar este Programa.!!");
        }
    }
}
