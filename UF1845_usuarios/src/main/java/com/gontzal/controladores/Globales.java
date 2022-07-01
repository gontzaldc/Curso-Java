package com.gontzal.controladores;

import java.io.IOException;
import java.util.Properties;

import com.gontzal.dal.DalException;
import com.gontzal.dal.DaoFabrica;
import com.gontzal.dal.DaoLibro;
import com.gontzal.dal.DaoProducto;
import com.gontzal.dal.DaoReserva;
import com.gontzal.dal.DaoUsuario;

public class Globales {
	static final DaoUsuario DAO;
	static final DaoProducto DAOPRODUCTO;
	static final DaoLibro DAOLIBRO;
	static final DaoReserva DAORESERVA;
	
	static final String CONFIGURACION = "config.properties";
	
	static {

		try {
			Properties props = new Properties();
			props.load(Globales.class.getClassLoader().getResourceAsStream(CONFIGURACION));

			String tipo = props.getProperty("dal.tipodao");
			String url = props.getProperty("dal.url");
			String user = props.getProperty("dal.user");
			String pass = props.getProperty("dal.pass");
			String driver = props.getProperty("dal.driver");

			DaoFabrica fabrica = new DaoFabrica(tipo, url, user, pass,driver);
			DAO = fabrica.getDaoUsuario();
			DAOPRODUCTO = fabrica.getDaoProducto();
			DAOLIBRO = fabrica.getDaoLibro();
			DAORESERVA = fabrica.getDaoReserva();

		} catch (IOException e) {
			throw new DalException("No se ha podido obtener la configuración");
		}

	}

}
