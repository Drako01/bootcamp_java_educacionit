package com.educacionitBD;

import java.sql.SQLException;
import java.util.Scanner;

public class TestDBManager {

    public static void main(String[] args) throws SQLException {

        DBManager dbManager = new DBManager();
        Scanner scanner = new Scanner(System.in);

        try {
            dbManager.conectar();
            dbManager.verificarYCrearTabla();

            System.out.println("Mostrando Alumnos:");
            dbManager.mostrarAlumnos();

            System.out.println("Ingrese los datos del nuevo alumno:");
            System.out.print("Legajo: ");
            int legajo = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Edad: ");
            int edad = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Especialidad: ");
            String especialidad = scanner.nextLine();

            Alumno nuevoAlumno = new Alumno(legajo, nombre, edad, especialidad);
            dbManager.insertarAlumno(nuevoAlumno);

            System.out.println("Mostrando Alumnos después de la inserción:");
            dbManager.mostrarAlumnos();

            System.out.println("Modificando el alumno con legajo " + legajo + ":");
            System.out.print("Nuevo nombre: ");
            String nuevoNombre = scanner.nextLine();

            System.out.print("Nueva edad: ");
            int nuevaEdad = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Nueva especialidad: ");
            String nuevaEspecialidad = scanner.nextLine();

            nuevoAlumno.setNombre(nuevoNombre);
            nuevoAlumno.setEdad(nuevaEdad);
            nuevoAlumno.setEspecialidad(nuevaEspecialidad);
            dbManager.modificarAlumno(nuevoAlumno);

            System.out.println("Mostrando Alumnos después de la modificación:");
            dbManager.mostrarAlumnos();

            System.out.print("Ingrese el legajo del alumno a eliminar: ");
            int legajoEliminar = scanner.nextInt();
            dbManager.eliminarAlumno(legajoEliminar);

            System.out.println("Mostrando Alumnos después de la eliminación:");
            dbManager.mostrarAlumnos();
        } finally {
            scanner.close();
            dbManager.closeConnection();
        }
    }
}
