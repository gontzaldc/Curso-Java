package com.gontzal.dal;

import java.util.TreeMap;

import com.gontzal.modelos.Producto;

class DaoProductoMemoria implements DaoProducto {

	private static final TreeMap<Long, Producto> productos = new TreeMap<>();

	static {
		productos.put(1L, new Producto(1L, "ordenador", "ordenador de sobremesa", 24));
		productos.put(2L, new Producto(2L, "portatil", "ordenador portatil", 14));
	}

	// SINGLETON
	private DaoProductoMemoria() {

	}

	private static final DaoProductoMemoria INSTANCIA = new DaoProductoMemoria();

	public static DaoProductoMemoria getInstantia() {
		return INSTANCIA;
	}
	// FIN SINGLETON

	@Override
	public Iterable<Producto> obtenerTodos() {
		return productos.values();
	}

}
