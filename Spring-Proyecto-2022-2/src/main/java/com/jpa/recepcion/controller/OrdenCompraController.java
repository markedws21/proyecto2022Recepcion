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

import com.jpa.recepcion.entity.OrdenCompra;
import com.jpa.recepcion.entity.Proveedor;
import com.jpa.recepcion.service.OrdenCompraService;
import com.jpa.recepcion.service.ProveedorService;

@Controller
@RequestMapping("/ordenCompra")
public class OrdenCompraController {

	@Autowired
	private OrdenCompraService serviceCompra;
	@Autowired
	private ProveedorService serviceProveedor;
	
	@RequestMapping("/lista")
	public String inicio(Model model) {
		
		List<OrdenCompra> lista =  serviceCompra.listarTodos();
		List<Proveedor> listaProve = serviceProveedor.listarTodos();
		
		model.addAttribute("Ordenes", lista);
		model.addAttribute("listaProveedores", listaProve);
		
		return "ordenCompra";
	}
	
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("codigo")int cod, @RequestParam("numeroOrden")String num,
			@RequestParam("sede")String sede, @RequestParam("codigoPostal")String codPos,
			@RequestParam("fecha")String fec, @RequestParam("proveedor")int prove, RedirectAttributes redirect) {
		try {
			OrdenCompra ord = new OrdenCompra();
			ord.setCodigo(cod);
			ord.setNumero(num);
			ord.setSede(sede);
			ord.setCodigoPostal(codPos);
			ord.setFecha(LocalDate.parse(fec));
			Proveedor pro = new Proveedor();
			pro.setCodigo(prove);
			
			serviceCompra.guardar(ord);
			if(cod == 0)
				redirect.addFlashAttribute("MENSAJE","Orden de Compra Registrado");
			else
				redirect.addFlashAttribute("MENSAJE","Orden de Compra Actualizada");
			
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","ERROR AL GUARDAR");
			e.printStackTrace();
		}
		return "redirect:/ordenCompra/lista";
	}
	
	@RequestMapping("/buscar")
	@ResponseBody
	public OrdenCompra findById(@RequestParam("codigo")int cod){
		OrdenCompra ord = serviceCompra.buscar(cod);
		
		return ord;
	}
	
	@RequestMapping("/eliminar")
	public String deleteByID(@RequestParam("codigo")int cod, RedirectAttributes redirect) {
		try {
			serviceCompra.eliminar(cod);
			redirect.addFlashAttribute("MENSAJE","Orden de Compra Eliminado");
		}catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en la eliminación");
			e.printStackTrace();
		}
		return "redirect:/ordenCompra/lista";
	}
}









