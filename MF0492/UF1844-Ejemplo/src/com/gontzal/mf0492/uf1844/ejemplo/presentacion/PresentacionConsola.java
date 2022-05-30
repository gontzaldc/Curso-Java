package com.gontzal.mf0492.uf1844.ejemplo.presentacion;

import static com.gontzal.mf0492.uf1844.ejemplo.bibliotecas.Consola.errorPl;
import static com.gontzal.mf0492.uf1844.ejemplo.bibliotecas.Consola.pedirBigDecimal;
import static com.gontzal.mf0492.uf1844.ejemplo.bibliotecas.Consola.pedirInt;
import static com.gontzal.mf0492.uf1844.ejemplo.bibliotecas.Consola.pedirLong;
import static com.gontzal.mf0492.uf1844.ejemplo.bibliotecas.Consola.pedirString;
import static com.gontzal.mf0492.uf1844.ejemplo.bibliotecas.Consola.pl;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.gontzal.mf0492.uf1844.ejemplo.accesoadatos.DaoEmpleado;
import com.gontzal.mf0492.uf1844.ejemplo.accesoadatos.DaoEmpleadoMemoria;
import com.gontzal.mf0492.uf1844.ejemplo.entidades.Empleado;

public class PresentacionConsola {

	private static final DaoEmpleado DAO = DaoEmpleadoMemoria.getInstancia();

	public static void main(String[] args) {

		int opcion;
		do {

			mostarMenu();
			opcion = preguntarOpcion();
			procesarOpcion(opcion);

		} while (opcion != 0);
	}

	private static int preguntarOpcion() {
		return pedirInt("Selecciona una de las opciones");
	}

	private static void mostarMenu() {

		// pl viene de la biblioteca Consola creada para no escribir
		// 'System.out.println()' todo el rato
		pl("1-. Mostrar todos");
		pl("2-. Mostrar por id");
		pl("3-. Insertar");
		pl("4-. Modificar");
		pl("5-. Borrar");
		pl("0-. Salir");

	}

	private static void procesarOpcion(int opcion) {

		switch (opcion) {

		case 1:
			mostrarTodos();
			break;

		case 2:
			buscarPorId();
			break;

		case 3:
			crearEmpleado();
			break;

		case 4:
			pl("Modificando datos");
			break;

		case 5:
			borrarEmpleado();
			break;

		case 0:
			pl("Gracias por utilizar la aplicación");
			break;
		default:
			errorPl("Elija una de las Opciones existentes");
		}

	}

	private static void buscarPorId() {
		pl(DAO.obtenerPorId(pedirLong("Introduce el id")));

	}

	private static void crearEmpleado() {
		String nif,nombre;
		BigDecimal sueldo;
		
		nif= pedirString("Introduce el NIF");
		nombre= pedirString("Introduce el Nombre");
		sueldo=pedirBigDecimal("Introduce el sueldo");
		
		DAO.insertar(new Empleado(0L, nif, nombre, LocalDate.of(1999, 3, 3), sueldo));
	}

	private static void mostrarTodos() {
		for (Empleado e : DAO.obtenerTodos()) {
			mostrarLinea(e);
		}

	}

	private static void mostrarLinea(Empleado e) {
		pl(e);

	}
	
	private static void borrarEmpleado() {
		mostrarTodos();
		DAO.borrar(pedirLong("Elige el Empleado que quieres borrar"));
	}
}
