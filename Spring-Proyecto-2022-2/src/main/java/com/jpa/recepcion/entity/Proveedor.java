package com.jpa.recepcion.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tb_proveedor")
public class Proveedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_provee")
	private Integer codigo;
	
	@Column(name="ruc_provee")
	private String ruc;
	
	@Column(name="nom_provee")
	private String nombre;
	
	@Column(name="distrito_provee")
	private String distrito;
	
	@Column(name="reprensen_provee")
	private String representante;
	
	@Column(name="fono_provee")
	private String fono;
	
	@Column(name="correo_provee")
	private String correo;
	
	@Column(name="razonsoci_provee")
	private String razonSoc;
	
	@JsonIgnore
	@OneToMany(mappedBy = "proveedor")
	private List<Bienes> listaBienes;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getRepresentante() {
		return representante;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
	}

	public String getFono() {
		return fono;
	}

	public void setFono(String fono) {
		this.fono = fono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getRazonSoc() {
		return razonSoc;
	}

	public void setRazonSoc(String razonSoc) {
		this.razonSoc = razonSoc;
	}

	public List<Bienes> getListaBienes() {
		return listaBienes;
	}

	public void setListaBienes(List<Bienes> listaBienes) {
		this.listaBienes = listaBienes;
	}

}
