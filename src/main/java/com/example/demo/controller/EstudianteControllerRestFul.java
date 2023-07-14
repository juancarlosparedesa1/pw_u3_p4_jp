package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteControllerRestFul {

	@Autowired
	private IEstudianteService estudianteService;

	// GET
	@GetMapping(path = "/buscar/{cedula}")
	public Estudiante consultarPorCedula(@PathVariable String cedula) {
//		String cedula = "1234";
		return this.estudianteService.consultarPorCedula(cedula);
	}

	@PostMapping(path = "/guardar")
	public void ingresar(@RequestBody Estudiante estudiante) {// recibo un estudiante pero no es suficiente
		// necesito una anotacion que me indique que ese dato tiene que venir en el
		// request
//		requestbody:que el estudinte debe venirme en el cuerpo del request
//		es un estudiante nuevo
		this.estudianteService.guardar(estudiante);

	}

	@PutMapping(path = "/actualizar/{identificador}")
	public void actualizar(@RequestBody Estudiante estudiante, @PathVariable Integer identificador) {
//		Integer identificador = 1;
		estudiante.setId(identificador);
		this.estudianteService.actualizar(estudiante);
	}

	@PatchMapping(path = "/actualizarParcial")
	public void actualizarParcial(@RequestBody Estudiante estudiante) {

		Integer identificador = 13;
		estudiante.setId(identificador);
		String cedula = "1234";
		Estudiante estu1 = this.estudianteService.consultarPorCedula(cedula);
		estu1.setCedula(estudiante.getCedula());
		this.estudianteService.actualizar(estu1);
	}

	@DeleteMapping(path = "/borrar/{id}")
	public void borrar(@PathVariable Integer id) {
		this.estudianteService.borrar(id);
	}

	// GET
	@GetMapping(path = "/buscarTodos")
	public List<Estudiante> consultarTodos() {
//			String cedula = "1234";
		return this.estudianteService.buscarTodos();
	}

	// request param
	// GET
	@GetMapping(path = "/buscarTodosProvincia")
	public List<Estudiante> consultarTodos(@RequestParam String provincia) {

		return this.estudianteService.buscarTodos();
	}

}
