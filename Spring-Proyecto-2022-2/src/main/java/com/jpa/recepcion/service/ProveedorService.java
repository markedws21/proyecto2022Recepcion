package com.jpa.recepcion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.recepcion.entity.Proveedor;
import com.jpa.recepcion.repository.ProveedorRepository;

@Service
public class ProveedorService {
	@Autowired
	private ProveedorRepository repo;
	
	public void guardar(Proveedor bean) {
		repo.save(bean);
	}
	public void eliminar(Integer cod) {
		repo.deleteById(cod);
	}
	public Proveedor buscar(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	public List<Proveedor> listarTodos(){
		return repo.findAll();
	}
}
