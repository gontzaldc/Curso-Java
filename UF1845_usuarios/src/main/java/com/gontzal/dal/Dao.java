package com.gontzal.dal;

import java.sql.SQLException;

public interface Dao<T> {

	default Iterable<T> obtenerTodos() throws SQLException {
		throw new DalException("NO IMPLEMENTADO");
	}

	default T obtenerPorId(Long id) {
		throw new DalException("NO IMPLEMENTADO");
	}

	default T insertar(T objeto) {
		throw new DalException("NO IMPLEMENTADO");
	}

	default T modificar(T objeto) {
		throw new DalException("NO IMPLEMENTADO");
	}

	default void borrar(Long id) {
		throw new DalException("NO IMPLEMENTADO");
	}

}
