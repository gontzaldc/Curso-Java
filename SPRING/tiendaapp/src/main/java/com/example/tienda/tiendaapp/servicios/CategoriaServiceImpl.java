package com.example.tienda.tiendaapp.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tienda.tiendaapp.entidades.Categoria;
import com.example.tienda.tiendaapp.repositorios.*;

@Service
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
	private CategoriaRepository repo;
	
	@Override
	public Iterable<Categoria> listar() {
		return repo.findAll();
	}

}
