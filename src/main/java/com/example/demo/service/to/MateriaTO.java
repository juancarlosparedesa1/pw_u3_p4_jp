package com.example.demo.service.to;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

public class MateriaTO extends RepresentationModel<MateriaTO> implements Serializable {
	private static final long serialversionUID = 1L;
//	@Column(name = "mate_id")
	private Integer id;
//	@Column(name = "mate_nombre")
	private String nombre;
//	@Column(name = "mate_numero_creditos")
	private Integer numeroCreditos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNumeroCreditos() {
		return numeroCreditos;
	}

	public void setNumeroCreditos(Integer numeroCreditos) {
		this.numeroCreditos = numeroCreditos;
	}

}
