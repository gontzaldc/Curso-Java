package com.example.tienda.tiendaapp.repositorios;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.tienda.tiendaapp.entidades.Producto;

@RepositoryRestResource(path = "productos", collectionResourceRel = "productos")
public interface ProductoRepositorio extends CrudRepository<Producto, Long>{

	@Query("select p from Producto p left join fetch p.categoria")
	Set<Producto> obtenerTodos();

}
