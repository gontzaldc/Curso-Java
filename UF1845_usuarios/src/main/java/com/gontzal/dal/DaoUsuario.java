package com.gontzal.dal;

import com.gontzal.modelos.Usuario;

public interface DaoUsuario extends Dao<Usuario> {

	default Usuario BuscarPorEmail(String email) {
		throw new DalException("NO IMPLEMENTADO");
	}

}
