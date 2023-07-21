package com.example.demo.controller;

import java.net.http.HttpHeaders;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	@GetMapping(path = "/{cedula}")
	// envolver objeto wrapper

	public ResponseEntity<Estudiante> consultarPorCedula(@PathVariable String cedula) {
		return ResponseEntity.status(227).body(this.estudianteService.consultarPorCedula(cedula));
	}

	@GetMapping
	public ResponseEntity<List<Estudiante>> consultarTodos(@RequestParam String provincia) {
		// buscarTodos?provincia=pichincha

//		HttpHeaders cabeceras = new HttpHeaders();
		List<Estudiante> lista = null;
		org.springframework.http.HttpHeaders cabeceras = new org.springframework.http.HttpHeaders();
		cabeceras.add("detalle mensaje", "Ciudadanos consultados exitosamente");
		cabeceras.add("valor api", "valor incalculabe");
		return new ResponseEntity<>(this.estudianteService.buscarTodos(provincia), 228);

	}

	@PostMapping
	public void guardar(@RequestBody Estudiante estudiante) {
		this.estudianteService.guardar(estudiante);
	}

	@PutMapping(path = "/{identificador}")
	public void actualizar(@RequestBody Estudiante estudiante, @PathVariable Integer identificador) {
		estudiante.setId(identificador);
		this.estudianteService.actualizar(estudiante);
	}

	@PatchMapping(path = "/{identificador}")
	public void actualizarParcial(@RequestBody Estudiante estudiante, @PathVariable Integer identificador) {
		estudiante.setId(identificador);
		String cedula = "789";
		Estudiante estu1 = this.estudianteService.consultarPorCedula(cedula);
		estu1.setCedula(estudiante.getCedula());

		this.estudianteService.actualizar(estu1);
	}

	@DeleteMapping(path = "/{id}")
	public void borrar(@PathVariable Integer id) {
		this.estudianteService.eliminar(id);
	}

}
