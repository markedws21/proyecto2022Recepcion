package com.jpa.recepcion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.recepcion.entity.OrdenCompra;
import com.jpa.recepcion.repository.OrdenCompraRepository;

@Service
public class OrdenCompraService {

	@Autowired
	private OrdenCompraRepository repo;
	
	public void guardar(OrdenCompra bean) {
		repo.save(bean);
	}
	public void eliminar(Integer cod){
		repo.deleteById(cod);
	}
	public OrdenCompra buscar(Integer cod){
		return repo.findById(cod).orElse(null);
	}
	public List<OrdenCompra> listarTodos(){
		return repo.findAll();
	}

}
