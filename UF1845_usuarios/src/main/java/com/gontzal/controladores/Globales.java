package com.gontzal.controladores;

import com.gontzal.dal.DaoFabrica;
import com.gontzal.dal.DaoLibro;
import com.gontzal.dal.DaoProducto;
import com.gontzal.dal.DaoReserva;
import com.gontzal.dal.DaoUsuario;

public class Globales {
	static final DaoUsuario DAO = new DaoFabrica("memoria").getDaoUsuario();
	static final DaoProducto DAOPRODUCTO = new DaoFabrica("memoria").getDaoProducto();
	static final DaoLibro DAOLIBRO = new DaoFabrica("memoria").getDaoLibro();
	static final DaoReserva DAORESERVA = new DaoFabrica("memoria").getDaoReserva();

}
