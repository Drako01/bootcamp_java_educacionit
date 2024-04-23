package com.educacionit;

import java.io.IOException;
import java.util.ArrayList;

import com.educacionit.dao.model.Alumno;
import com.educacionit.exception.DBManagerException;

public interface IDBManager {

	void conectar() throws DBManagerException;

	void mostrarAlumnos() throws DBManagerException;

	ArrayList<Alumno> obtenerAlumnos() throws DBManagerException;

	Alumno obtenerAlumno(Integer legajo) throws DBManagerException;

	void insertarAlumno(Alumno alumno) throws DBManagerException;

	void modificarAlumno(Alumno alumno) throws DBManagerException;

	void eliminarAlumno(Integer legajo) throws DBManagerException;

	void close() throws IOException;

}