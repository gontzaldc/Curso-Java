package com.gontzal.dal;

import com.gontzal.modelos.Libro;

public interface DaoLibro extends Dao<Libro>{

	
	// ¡¡¡NO HACE FALTA, YA HAY UN BUSCAR POR ID EN DAO!!!
	default Libro buscarPorId(Long id){
		throw new DalException("NO IMPLEMENTADO");
	}
}
