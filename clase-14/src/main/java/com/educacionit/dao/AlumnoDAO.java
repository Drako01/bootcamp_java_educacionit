package com.educacionit.dao;

import java.util.ArrayList;

import com.educacionit.dao.model.Alumno;
import com.educacionit.exception.DBManagerException;

public interface AlumnoDAO {

	ArrayList<Alumno> obtenerTodos() throws DBManagerException;

	Alumno obtenerUno(Integer legajo) throws DBManagerException;

	void insertar(Alumno alumno) throws DBManagerException;

	void modificar(Alumno alumno) throws DBManagerException;

	void eliminar(Integer legajo) throws DBManagerException;

}
