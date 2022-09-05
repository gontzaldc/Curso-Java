package com.example.tienda.tiendaapp.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tienda.tiendaapp.entidades.Producto;
import com.example.tienda.tiendaapp.repositorios.ProductoRepositorio;

@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	private ProductoRepositorio repo;
	
	@Override
	public Iterable<Producto> listar() {
		return repo.findAll();
	}

	@Override
	public Producto insertar(Producto producto) {
		
		return repo.save(producto);
	}

	@Override
	public void borrar(Long id) {
		repo.deleteById(id);
	}

}
