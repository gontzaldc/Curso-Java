package com.gontzal.controladores;

import com.gontzal.dal.DaoUsuario;
import com.gontzal.dal.DaoUsuarioMemoria;

public class Globales {
	static final DaoUsuario DAO = DaoUsuarioMemoria.getInstancia();

}
