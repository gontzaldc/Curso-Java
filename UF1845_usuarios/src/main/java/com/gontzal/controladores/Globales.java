package com.gontzal.controladores;

import com.gontzal.dal.DaoFabrica;
import com.gontzal.dal.DaoUsuario;

public class Globales {
	static final DaoUsuario DAO = new DaoFabrica("memoria").getDaoUsuario();

}
