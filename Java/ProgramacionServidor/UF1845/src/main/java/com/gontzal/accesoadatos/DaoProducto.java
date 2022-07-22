package com.gontzal.accesoadatos;

import com.gontzal.servlets.modelos.Producto;

public interface DaoProducto extends Dao<Producto>{

	Iterable<Producto> obtenerPorNombre(String nombre);
	
}
