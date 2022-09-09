package com.example.tienda.tiendaapp.controladoresrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.tienda.tiendaapp.entidades.Producto;
import com.example.tienda.tiendaapp.repositorios.ProductoRepositorio;

@RestController
@RequestMapping("/api/productos")
public class ProductoRestController {

	
	@Autowired
	private ProductoRepositorio repo;
	
	@GetMapping
	public Iterable<Producto> get(){
		return repo.obtenerTodos();
	}
	
	@GetMapping("{id}")
	public Producto get(@PathVariable Long id){
		return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
}
