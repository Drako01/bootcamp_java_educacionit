package com.educacionit.dao;

import java.util.List;

import com.educacionit.dao.model.Profesor;

public interface ProfesorDAO {
	
	public Profesor buscarPorId(Integer id);
	public List<Profesor> buscarTodos();

	public Integer alta(Profesor profesor);
	public void baja(Integer id);
	public void modificacion(Profesor profesor);

}
