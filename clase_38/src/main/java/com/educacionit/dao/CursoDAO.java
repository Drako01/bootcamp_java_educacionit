package com.educacionit.dao;

import java.util.List;

import com.educacionit.dao.model.Curso;

public interface CursoDAO {
	
	public Curso buscarPorId(Integer id);
	public List<Curso> buscarTodos();

	public Integer alta(Curso curso);
	public void baja(Integer id);
	public void modificacion(Curso curso);

}
