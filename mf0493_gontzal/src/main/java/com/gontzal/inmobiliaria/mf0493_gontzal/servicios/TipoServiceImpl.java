package com.gontzal.inmobiliaria.mf0493_gontzal.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gontzal.inmobiliaria.mf0493_gontzal.entidades.Tipo;
import com.gontzal.inmobiliaria.mf0493_gontzal.repositorios.TipoRepository;

import lombok.extern.java.Log;

@Log
@Service
public class TipoServiceImpl implements TipoService {

	@Autowired
	private TipoRepository repo;

	@Override
	public Iterable<Tipo> listar() {
		log.info("Se ha pedido un listado de tipos");
		return repo.findAll();
	}

}
