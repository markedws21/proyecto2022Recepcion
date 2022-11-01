package com.jpa.recepcion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.recepcion.entity.Bienes;
import com.jpa.recepcion.repository.BienesRepository;

@Service
public class BienesService {

	@Autowired
	private BienesRepository repo;
	
	public void guardar(Bienes bean) {
		repo.save(bean);
	}
	public void eliminar(Integer cod) {
		repo.deleteById(cod);
	}
	public Bienes buscar(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	public List<Bienes> listarTodos(){
		return repo.findAll();
	}

}
