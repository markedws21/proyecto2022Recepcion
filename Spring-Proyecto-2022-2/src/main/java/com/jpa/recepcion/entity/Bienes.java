package com.jpa.recepcion.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_bienes")
public class Bienes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_bien")
	private Integer codigo;
	
	@Column(name="des_bien")
	private String descripcion;
	
	@Column(name="pre_bien")
	private double precio;
	
	@Column(name="fechaentrada_bien")
	private LocalDate fechaEntrada;

}
