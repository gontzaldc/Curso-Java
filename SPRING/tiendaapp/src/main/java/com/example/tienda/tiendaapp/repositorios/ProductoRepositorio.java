package com.example.tienda.tiendaapp.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.example.tienda.tiendaapp.entidades.Producto;

public interface ProductoRepositorio extends CrudRepository<Producto, Long>{

}
