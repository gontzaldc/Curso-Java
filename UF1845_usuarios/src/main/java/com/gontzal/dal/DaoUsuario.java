package com.gontzal.dal;

import com.gontzal.modelos.Usuario;

public interface DaoUsuario extends Dao<Usuario> {

	Usuario BuscarPorEmail(String email);
}
