package com.gontzal.inmobiliaria.mf0493_gontzal.servicios;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gontzal.inmobiliaria.mf0493_gontzal.entidades.Inmueble;
import com.gontzal.inmobiliaria.mf0493_gontzal.repositorios.*;

import lombok.extern.java.Log;

@Log
@Service
public class InmuebleServiceImpl implements InmuebleService {

	@Autowired
	private InmuebleRepository repo;


	@Override
	public Iterable<Inmueble> listar() {
		log.info("Se ha pedido un listado de inmuebles");
		return repo.findAll();
	}

	@Override
	public Inmueble crear(Inmueble inmueble) {
		
		return repo.save(inmueble);
	}



	@Override
	public Inmueble buscarPorId(Long id) {
		log.info("Se ha pedido un inmueble por id");
		return repo.findById(id).orElse(null);
	}

	@Override
	public Iterable<Inmueble> listarPorTipo(Long id) {
		
		return repo.findByTipoId(id);
	}

	@Override
	public Iterable<Inmueble> listarPorRangoPrecio(BigDecimal min, BigDecimal max) {

		return repo.findByPrecioBetweenOrderByPrecio(min, max);
	}

	@Override
	public Iterable<Inmueble> listarPorNombreDireccion(String busqueda) {
		
		return repo.findByPrecioAndDireccion(busqueda);
	}

}
