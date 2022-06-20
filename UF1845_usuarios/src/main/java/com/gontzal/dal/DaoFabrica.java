package com.gontzal.dal;

public class DaoFabrica {

	private DaoUsuario daoUsuario;

	public DaoFabrica(String tipoDao) {

		switch (tipoDao) {
		case "memoria": {
			daoUsuario = DaoUsuarioMemoria.getInstancia();
			break;

		}
		default:
			throw new DalException("No conozco ese tipo" + tipoDao);
		}
	}

	public DaoUsuario getDaoUsuario() {
		return daoUsuario;
	}

}
