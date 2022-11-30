package com.jpa.recepcion.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tb_enlace")
public class Enlace {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idenlace;
	private String descripcion;
	private String ruta;
	
	@JsonIgnore
	@OneToMany(mappedBy = "enlace")
	private List<RolEnlace> listaRolEnlace;

	public Integer getIdenlace() {
		return idenlace;
	}

	public void setIdenlace(Integer idenlace) {
		this.idenlace = idenlace;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public List<RolEnlace> getListaRolEnlace() {
		return listaRolEnlace;
	}

	public void setListaRolEnlace(List<RolEnlace> listaRolEnlace) {
		this.listaRolEnlace = listaRolEnlace;
	}
	
	
	
}