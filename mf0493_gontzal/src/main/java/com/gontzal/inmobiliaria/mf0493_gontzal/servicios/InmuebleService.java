package com.gontzal.inmobiliaria.mf0493_gontzal.servicios;

import java.math.BigDecimal;

import com.gontzal.inmobiliaria.mf0493_gontzal.entidades.Inmueble;

public interface InmuebleService {

	Iterable<Inmueble> listar();
	Inmueble crear(Inmueble inmueble);
	Inmueble buscarPorId(Long id);
	Iterable<Inmueble> listarPorNombreDireccion(String busqueda);
	Iterable<Inmueble> listarPorTipo(Long id);
	Iterable<Inmueble> listarPorRangoPrecio(BigDecimal min, BigDecimal max);
}
