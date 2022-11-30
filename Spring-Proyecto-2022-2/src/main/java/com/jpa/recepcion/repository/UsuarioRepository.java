package com.jpa.recepcion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jpa.recepcion.entity.Enlace;
import com.jpa.recepcion.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	@Query("select u from Usuario u where u.login=?1")
	public Usuario iniciarSesion(String nomUsuario);
	
	@Query("select e from RolEnlace re join re.enlace e where re.rol.idrol=?1")
	public List<Enlace> traerEnlaces(int codRol);
	
}
