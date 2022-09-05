package com.example.tienda.tiendaapp.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.tienda.tiendaapp.entidades.Producto;
import com.example.tienda.tiendaapp.servicios.*;

@Controller
@RequestMapping("/admin/productos")
public class ProductoController {

	
	@Autowired
	private ProductoService servicio;
	
	@Autowired
	private CategoriaService servicioCategoria;
	
	@GetMapping
	public String mostrarProductos(Model modelo) {
		modelo.addAttribute("productos", servicio.listar());
		return "productos";
	}
	
	@GetMapping("/insertar")
	public String mostrarFormulario(Producto producto, Model modelo) {
		modelo.addAttribute("categorias",servicioCategoria.listar());
		return "producto";
	}
	
	@PostMapping("/insertar")
	public String insertarProducto(@Valid Producto producto, BindingResult bindingResult,Model modelo) {
		
		if(bindingResult.hasErrors()) {

			modelo.addAttribute("categorias",servicioCategoria.listar());
			return "producto";
		}
		servicio.insertar(producto);
		return "redirect:/admin/productos";
	}
	
	@GetMapping("/borrar/{id}")
	public String borrarProducto(@PathVariable Long id) {
		
		servicio.borrar(id);
		return "redirect:/admin/productos";
		
	}
}
