package com.gontzal.dal;

import java.util.TreeMap;

import com.gontzal.modelos.Libro;

public class DaoLibroMemoria implements DaoLibro{
	
	private final static TreeMap<Long,Libro> libros= new TreeMap<>();
	
	static {
		libros.put(1L, new Libro(1L,"Libro 1","drama",true));
		libros.put(2L, new Libro(2L,"Libro 2","aventura",true));
	}

	@Override
	public Libro modificar(Libro libro) {
		return libros.put(libro.getId(), libro);
	}

	@Override
	public Iterable<Libro> obtenerTodos() {
		return libros.values();
	}

	@Override
	public Libro buscarPorId(Long id) {
		return libros.get(id);
	}
	
	

}
