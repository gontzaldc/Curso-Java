package com.gontzal.mf0492.uf1844.ejemplo.presentacion;

import static com.gontzal.mf0492.uf1844.ejemplo.bibliotecas.Consola.*;

import java.math.BigInteger;

import com.gontzal.mf0492.uf1844.ejemplo.accesoadatos.DaoProducto;
import com.gontzal.mf0492.uf1844.ejemplo.accesoadatos.DaoProductoMemoria;
import com.gontzal.mf0492.uf1844.ejemplo.entidades.EntidadesException;
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

	}

	private static void mostrarMenu() {
		pl("**** Menú Productos ****");
		pl("1-. Ver todos los productos");
		pl("2-. Buscar por nombre");
		pl("3-. Comprar");
		pl("4-. Insertar Producto");
		pl("0-. Salir");
	}

	private static int pedirOpcion() {
		return pedirInt("Introduce la opcion que seseas ejecutar");
	}

	private static void ejecutarOpcion(int opcion) {

		switch (opcion) {
		case 1:
			verTodos();
			break;

		case 2:
			buscarPorNombre();
			break;

		case 4:
			insertarProductos();
			break;

		default:
			pl("Introduce un valor valido");
		}

	}

	private static void verTodos() {
		cabeceraProductos();
		for (Producto p : DAOP.obtenerTodos()) {
			mostrarProductos(p);
		}
		pieProductos();
	}

	private static void cabeceraProductos() {
		pieProductos();
		System.out.printf("| %3s | %-20s | %-5s | %-30s |", "ID", "NOMBRE", "STOCK", "DESCRIPCION");
		System.out.println();
		pieProductos();
	}

	private static void mostrarProductos(Producto p) {
		System.out.format("| %3s | %-20s | %-5s | %-30s |", p.getId(), p.getNombre(), p.getStock(), p.getDescripcion());
		System.out.println();
	}

	private static void pieProductos() {
		System.out.println("+---------------------------------------------------------------------+");
	}

	private static void buscarPorNombre() {
		String nombre = pedirString("introduce nombre del producto para buscarlo");

		
		cabeceraProductos();
		for (Producto p : DAOP.obtenerPorNombre(nombre)) {

			mostrarProductos(p);
		}
		pieProductos();
	}

	private static void validarPeticion(Runnable pd) {
		boolean repetir = true;

		do {
			try {
				pd.run();
				repetir = false;
			} catch (EntidadesException e) {
				pl(e.getMessage());
			}
		} while (repetir);
	}

	private static void insertarProductos() {

		Producto producto = new Producto();

		pl("introduciendo producto...");
		validarPeticion(() -> producto.setNombre(pedirString("Introduce el nombre")));
		validarPeticion(() -> producto.setStock(BigInteger.valueOf(pedirInt("Introduce el stock"))));
		validarPeticion(() -> producto.setDescripcion(pedirString("Introduce una descripción corta")));

		DAOP.insertar(producto);

	}

}
