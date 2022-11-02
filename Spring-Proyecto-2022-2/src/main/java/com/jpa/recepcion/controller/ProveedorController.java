package com.jpa.recepcion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jpa.recepcion.entity.Proveedor;
import com.jpa.recepcion.service.ProveedorService;

@Controller
@RequestMapping("/proveedor")
public class ProveedorController {
	
	@Autowired
	private ProveedorService servicioProve;
	
	@RequestMapping("/lista")
	public String inicio(Model model) {
		List<Proveedor> lista=servicioProve.listarTodos();
		
		model.addAttribute("proveedores", lista);
		
		return "proveedor";
	}
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("codigo")int cod,@RequestParam("ruc")String ruc,
			@RequestParam("nombre")String nom,@RequestParam("distrito") String dis,
			@RequestParam("representante") String repre,@RequestParam("fono")String fono,
			@RequestParam("correo") String correo,@RequestParam("razonSoc") String raz,
			RedirectAttributes redirect) {
		try {
			Proveedor pro= new Proveedor();
			pro.setCodigo(cod);
			pro.setRuc(ruc);
			pro.setNombre(nom);
			pro.setDistrito(dis);
			pro.setRepresentante(repre);
			pro.setFono(fono);
			pro.setCorreo(correo);
			pro.setRazonSoc(raz);
			servicioProve.guardar(pro);
			if(cod==0)
				redirect.addFlashAttribute("MENSAJE","Proveedor registrado");
			else
				redirect.addFlashAttribute("MENSAJE","Proveedor actualizado");
		}catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","ERROR AL GUARDAR");
			e.printStackTrace();
		}
		return "redirect:/proveedor/lista";
	}
	@RequestMapping("/buscar")
	@ResponseBody
	public Proveedor finById(@RequestParam("codigo")int cod) {
		Proveedor pro=servicioProve.buscar(cod);
		return pro;
	}
	
	@RequestMapping("/eliminar")
	public String deleteByID(@RequestParam("codigo") int cod,RedirectAttributes redirect) {
		try {
			servicioProve.eliminar(cod);
			redirect.addFlashAttribute("MENSAJE","Proveedor eliminado");
			
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en la eliminación");
			e.printStackTrace();
		}
		return "redirect:/proveedor/lista";
	}
	
}
