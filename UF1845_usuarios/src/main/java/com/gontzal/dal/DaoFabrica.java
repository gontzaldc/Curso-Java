package com.gontzal.dal;

public class DaoFabrica {

	private DaoUsuario daoUsuario;
	private DaoProducto daoProducto;

	public DaoFabrica(String tipoDao) {

		switch (tipoDao) {
		case "memoria": {
			daoUsuario = DaoUsuarioMemoria.getInstancia();
			daoProducto = new DaoProductoMemoria();
			break;

		}
		default:
			throw new DalException("No conozco ese tipo" + tipoDao);
		}
	}

	public DaoUsuario getDaoUsuario() {
		return daoUsuario;
	}

	public DaoProducto getDaoProducto() {
		return daoProducto;
	}

}
