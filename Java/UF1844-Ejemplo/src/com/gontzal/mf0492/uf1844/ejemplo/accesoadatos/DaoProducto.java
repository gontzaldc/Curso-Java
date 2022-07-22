package com.gontzal.mf0492.uf1844.ejemplo.accesoadatos;

import com.gontzal.mf0492.uf1844.ejemplo.entidades.Producto;

public interface DaoProducto extends Dao<Producto>{

	Iterable<Producto> obtenerPorNombre(String nombre);
	
}
