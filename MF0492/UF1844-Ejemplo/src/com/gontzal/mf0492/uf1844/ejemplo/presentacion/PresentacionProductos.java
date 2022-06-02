package com.gontzal.mf0492.uf1844.ejemplo.presentacion;

import static com.gontzal.mf0492.uf1844.ejemplo.bibliotecas.Consola.*;

import com.gontzal.mf0492.uf1844.ejemplo.accesoadatos.DaoProducto;
import com.gontzal.mf0492.uf1844.ejemplo.accesoadatos.DaoProductoMemoria;
import com.gontzal.mf0492.uf1844.ejemplo.entidades.Producto;

public class PresentacionProductos {

	private static final DaoProducto DAOP = DaoProductoMemoria.getInstancia();

	public static void main(String[] args) {
		int opcion;

		do {
			mostrarMenu();
			opcion = pedirOpcion();
			ejecutarOpcion(opcion);

		} while (opcion != 0);

		verTodos();

		buscarPorNombre();
	}

	private static void ejecutarOpcion(int opcion) {

		switch (opcion) {
		case 1:
			verTodos();
			break;

		case 2:
			buscarPorNombre();
			break;

		default:
			pl("Introduce un valor valido");
		}

	}

	private static int pedirOpcion() {
		return pedirInt("Introduce la opcion que seseas ejecutar");
	}

	private static void mostrarMenu() {
		pl("**** Menú Productos ****");
		pl("1-. Ver todos los productos");
		pl("2-. Buscar por nombre");
		pl("0-. Salir");
	}

	private static void buscarPorNombre() {
		String nombre = pedirString("introduce nombre del producto para buscarlo");

		for (Producto p : DAOP.obtenerPorNombre(nombre)) {
			pl(p);
		}
	}

	private static void verTodos() {
		for (Producto p : DAOP.obtenerTodos()) {
			pl(p);
		}
	}

}
