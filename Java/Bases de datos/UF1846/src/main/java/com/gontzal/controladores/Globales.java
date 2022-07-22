package com.gontzal.controladores;

import java.io.IOException;
import java.util.Properties;

import com.gontzal.dal.*;

public class Globales {
	static final DaoLibro DAOLIBRO;
	static final DaoUsuario DAOUSUARIO;

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

			DaoFabrica fabrica = new DaoFabrica(tipo, url, user, pass, driver);
			DAOUSUARIO = fabrica.getDaoUsuario();
			DAOLIBRO = fabrica.getDaoLibro();
//			DAORESERVA = fabrica.getDaoReserva();

		} catch (IOException e) {
			throw new DalException("No se ha podido obtener la configuración");
		}

	}

}