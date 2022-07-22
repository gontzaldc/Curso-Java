package com.gontzal.dal;

import java.math.BigDecimal;
import java.util.TreeMap;

import com.gontzal.modelos.Producto;

class DaoProductoMemoria implements DaoProducto {

	private static final TreeMap<Long, Producto> productos = new TreeMap<>();

	static {
		productos.put(1L, new Producto(1L, "ordenador", "ordenador de sobremesa", 24,"informatica",null,new BigDecimal(695)));
		productos.put(2L, new Producto(2L, "portatil", "ordenador portatil", 14,"informatica",20,new BigDecimal(450)));
		productos.put(3L, new Producto(2L, "portatil", "ordenador portatil", 14,"informatica",10,new BigDecimal(450)));
		productos.put(4L, new Producto(2L, "portatil", "ordenador portatil", 14,"informatica",null,new BigDecimal(450)));
		productos.put(5L, new Producto(2L, "portatil", "ordenador portatil", 14,"informatica",50,new BigDecimal(450)));
	}



	@Override
	public Iterable<Producto> obtenerTodos() {
		return productos.values();
	}

}
