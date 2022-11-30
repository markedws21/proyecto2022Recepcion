package com.jpa.recepcion.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jpa.recepcion.entity.Usuario;
import com.jpa.recepcion.service.UsuarioService;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	private UsuarioService servicio;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails obj=null;
		Usuario u=servicio.loginUsuario(username);
		
		Set<GrantedAuthority> rol=new HashSet<GrantedAuthority>();
		rol.add(new SimpleGrantedAuthority(u.getRol().getDescripcion()));
		
		obj=new User(username,u.getClave(),rol);
		
		return obj;
	}

}
