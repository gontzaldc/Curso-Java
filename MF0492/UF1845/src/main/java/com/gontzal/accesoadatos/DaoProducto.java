package com.gontzal.accesoadatos;

import com.gontzal.entidades.Producto;

public interface DaoProducto extends Dao<Producto>{

	Iterable<Producto> obtenerPorNombre(String nombre);
	
}
