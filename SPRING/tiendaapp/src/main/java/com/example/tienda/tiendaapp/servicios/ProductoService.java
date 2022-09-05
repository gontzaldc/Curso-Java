package com.example.tienda.tiendaapp.servicios;

import com.example.tienda.tiendaapp.entidades.Producto;

public interface ProductoService {

	Iterable<Producto> listar();
	
	Producto insertar(Producto producto);
	
	void borrar(Long id);
}
