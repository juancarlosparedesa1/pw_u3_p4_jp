package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;

public interface IEstudianteService {

	public Estudiante consultarPorCedula(String cedula);

	// capacidad guardar
	public void guardar(Estudiante estudiante);

	// actualizar
	public void actualizar(Estudiante estudiante);

	// actualizar parcial
	public void actualizar(String cedulaActual, String cedulaNueva);

	public void borrar(Integer id);

//	buscar todos
	public List<Estudiante> buscarTodos();
}
