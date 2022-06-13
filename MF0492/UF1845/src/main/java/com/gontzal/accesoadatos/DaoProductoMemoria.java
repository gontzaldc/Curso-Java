package com.gontzal.accesoadatos;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.TreeMap;

import com.gontzal.servlets.modelos.Producto;

public class DaoProductoMemoria implements DaoProducto {

	private static final TreeMap<Long, Producto> productos = new TreeMap<>();

	static {
		productos.put(1L, new Producto(1L, "Crema de Cacahuete", new BigInteger("12"), "adsfgh dassADSF",false));
		productos.put(2L, new Producto(2L, "Crema de Verdura", new BigInteger("12"), "adsfgh dassADSF",true));
		productos.put(3L, new Producto(3L, "Chocolate", new BigInteger("12"), "adsfgh dassADSF",true));
	}

	// SINGLETON
	private DaoProductoMemoria() {
	}

	private static final DaoProductoMemoria INSTANCIA = new DaoProductoMemoria();

	public static DaoProductoMemoria getInstancia() {
		return INSTANCIA;
	}
	// FIN SENGLETON

	@Override
	public Iterable<Producto> obtenerTodos() {
		return productos.values();
	}

	@Override
	public Producto obtenerPorId(Long id) {
		return productos.get(id);
	}

	@Override
	public void insertar(Producto producto) {

		Long id;
		if (productos.size() > 0) {
			id = productos.lastKey() + 1;
		} else {
			id = 1L;
		}
		producto.setId(id);

		productos.put(producto.getId(), producto);

	}

	@Override
	public void modificar(Producto producto) {
		productos.put(producto.getId(), producto);

	}

	@Override
	public void borrar(Long id) {
		productos.remove(id);

	}

	@Override
	public Iterable<Producto> obtenerPorNombre(String nombre) {
		ArrayList<Producto> ArrP = new ArrayList<>();
		for (Producto p : productos.values()) {
			if (p.getNombre().toLowerCase().matches(".*" + nombre.toLowerCase() + ".*")) {
				ArrP.add(p);
			}
		}

		return ArrP;
	}

	

}
