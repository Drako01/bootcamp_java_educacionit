package com.educacionit.dao;

import java.util.List;

import com.educacionit.dao.model.Especialidad;

public interface EspecialidadDAO {
	
	public Especialidad buscarPorId(Integer id);
	public List<Especialidad> buscarTodos();

	public Integer alta(Especialidad especialidad);
	public void baja(Integer id);
	public void modificacion(Especialidad especialidad);

}
