package com.example.tienda.tiendaapp.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.tienda.tiendaapp.repositorios.ProductoRepositorio;

@Controller
@RequestMapping("/admin/productos")
public class ProductoController {

	
	@Autowired
	private ProductoRepositorio repo;
	
	@GetMapping
	public String mostrarProductos(Model modelo) {
		modelo.addAttribute("productos", repo.findAll());
		return "productos";
	}
}
