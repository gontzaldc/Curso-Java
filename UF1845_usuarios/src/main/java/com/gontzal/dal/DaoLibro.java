package com.gontzal.dal;

import com.gontzal.modelos.Libro;

public interface DaoLibro extends Dao<Libro>{

	Libro buscarPorId(Long id);
}
