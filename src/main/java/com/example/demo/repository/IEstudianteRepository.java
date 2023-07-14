package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;

public interface IEstudianteRepository {

	public Estudiante seleccionarPorCedula(String cedula);

	// capacidad guardar
	public void insertar(Estudiante estudiante);

	// actualizar
	public void actualizar(Estudiante estudiante);

	// actualizar parcial
	public void actualizar(String cedulaActual, String cedulaNueva);

	public void borrar(Integer id);

	public Estudiante buscarPorId(Integer id);

	//buscar todos
	public List<Estudiante> seleccionarTodos();
}
