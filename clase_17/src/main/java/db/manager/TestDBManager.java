package db.manager;

import java.util.Scanner;

import db.excepciones.DBConexionException;
import db.excepciones.DBManagerException;

public class TestDBManager {

    public static void main(String[] args) {
        try ( 
        		DBManager dbManager = new DBManager();
        		Scanner scanner = new Scanner(System.in)
        	) {

            dbManager.conectar();
            try {
                dbManager.verificarYCrearTabla();
            } catch (DBManagerException e) {
                throw new DBManagerException(DBConexionException.ERROR_3,
                    "Error al verificar y crear la tabla " + e.getMessage(), e);
            }

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

        } catch (DBManagerException e) {
            System.err.println("Error en DBManager: " + e.getMessage());
            Throwable causaOriginal = e.getCause();
            if (causaOriginal != null) causaOriginal.getMessage();            
            
        } catch (Exception e) {
            System.err.println("Error general: " + e.getMessage());
        } finally {
        	System.out.println("Gracias por usar nuestro Servicio.!");
        }
    }
}
