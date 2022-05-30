package com.gontzal.mf0492.uf1844.ejemplo.accesoadatos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.TreeMap;

import com.gontzal.mf0492.uf1844.ejemplo.entidades.Empleado;

public class DaoEmpleadoMemoria implements DaoEmpleado {

	private static final TreeMap<Long, Empleado> empleados = new TreeMap<>();

	static {
		empleados.put(1L, new Empleado(1L, "12345678Z", "Javier", LocalDate.of(2000, 1, 2), new BigDecimal("12345")));
		empleados.put(2L, new Empleado(2L, "22345678Z", "Nombre2", LocalDate.of(2001, 1, 2), new BigDecimal("22345")));
		empleados.put(3L, new Empleado(3L, "32345678Z", "Nombre3", LocalDate.of(2002, 1, 2), new BigDecimal("32345")));
	}

	// SINGLETON
	// Constructor en privado
	private DaoEmpleadoMemoria() {

	}

	private static final DaoEmpleadoMemoria INSTANCIA = new DaoEmpleadoMemoria();

	public static DaoEmpleadoMemoria getInstancia() {
		return INSTANCIA;
	}
	// FIN SINGLETON

	@Override
	public Iterable<Empleado> obtenerTodos() {
		return empleados.values();
	}

	@Override
	public Empleado obtenerPorId(Long id) {
		return empleados.get(id);
	}

	@Override
	public void insertar(Empleado empleado) {
		Long id= empleados.size()>0? empleados.lastKey()+1:1L;
		empleado.setId(id);
		empleados.put(empleado.getId(), empleado);

	}

	@Override
	public void modificar(Empleado empleado) {
		empleados.put(empleado.getId(), empleado);

	}

	@Override
	public void borrar(Long id) {
		empleados.remove(id);

	}

}
