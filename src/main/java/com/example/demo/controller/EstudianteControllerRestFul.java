package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteControllerRestFul {

	@Autowired
	private IEstudianteService estudianteService;

	// GET
	@GetMapping(path = "/buscar")
	public Estudiante consultarPorCedula() {
		String cedula = "1234";
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

	@PutMapping(path = "/actualizar")
	public void actualizar() {

	}

	@PatchMapping(path = "/actualizarParcial")
	public void actualizarParcial() {

	}

	@DeleteMapping(path = "/borrar")
	public void borrar() {

	}

}
