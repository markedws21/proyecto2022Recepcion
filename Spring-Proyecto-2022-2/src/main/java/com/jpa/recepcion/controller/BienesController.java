package com.jpa.recepcion.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jpa.recepcion.entity.Bienes;
import com.jpa.recepcion.entity.Proveedor;
import com.jpa.recepcion.service.BienesService;
import com.jpa.recepcion.service.ProveedorService;

@Controller
@RequestMapping("/bienes")
public class BienesController {
	
	@Autowired
	private BienesService servicioBien;
	
	@Autowired
	private ProveedorService servicioProvee;
	
	@RequestMapping("/lista")
	public String inicio(Model model) {
		List<Bienes> lista=servicioBien.listarTodos();
		
		List<Proveedor> listaProve= servicioProvee.listarTodos();
		
		model.addAttribute("Bienes", lista);
		model.addAttribute("listaProveedores", listaProve);
		
		return "bienes";
	}
	
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("codigo")int cod,@RequestParam("proveedor")int prove,
			@RequestParam("descripcion")String descri,
			@RequestParam("precio")double pre,@RequestParam("fechaEntrada")String fecha,
			RedirectAttributes redirect) {
		try {
			Bienes bien = new Bienes();
			bien.setCodigo(cod);
			Proveedor pro = new Proveedor();
			pro.setCodigo(prove);
			bien.setProveedor(pro);
			bien.setDescripcion(descri);
			bien.setPrecio(pre);
			bien.setFechaEntrada(LocalDate.parse(fecha));
			servicioBien.guardar(bien);
			if(cod==0)
				redirect.addFlashAttribute("MENSAJE","Bien registrado");
			else
				redirect.addFlashAttribute("MENSAJE","Bien actualizado");
		}catch(Exception e){
			redirect.addFlashAttribute("MENSAJE","ERROR AL GUARDAR");
			e.printStackTrace();
		}
		return "redirect:/bienes/lista";
   }
	
	@RequestMapping("/buscar")
	@ResponseBody
	public Bienes finById(@RequestParam("codigo")int cod) {
		Bienes bien=servicioBien.buscar(cod);
		
		return bien;
	}
	
	@RequestMapping("/eliminar")
	public String deleteByID(@RequestParam("codigo") int cod,RedirectAttributes redirect) {
		try {
			servicioBien.eliminar(cod);
			redirect.addFlashAttribute("MENSAJE","Bien eliminado");
			
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en la eliminación");
			e.printStackTrace();
		}
		return "redirect:/bienes/lista";
	}
}
