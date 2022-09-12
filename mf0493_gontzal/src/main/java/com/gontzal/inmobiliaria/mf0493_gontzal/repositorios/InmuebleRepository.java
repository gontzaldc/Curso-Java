package com.gontzal.inmobiliaria.mf0493_gontzal.repositorios;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.gontzal.inmobiliaria.mf0493_gontzal.entidades.Inmueble;

public interface InmuebleRepository extends PagingAndSortingRepository<Inmueble, Long>{

	//Iterable<Inmueble> findByNombreDireccion(String nombre, String direccion);
	Iterable<Inmueble> findByTipoId(Long tipoId);
	Iterable<Inmueble> findByPrecioBetweenOrderByPrecio(BigDecimal minimo, BigDecimal maximo);
	
	@Query("select i from Inmueble i where i.nombre like %:busqueda% OR i.direccion like %:busqueda%")
	Iterable<Inmueble> findByPrecioAndDireccion(String busqueda);
}
