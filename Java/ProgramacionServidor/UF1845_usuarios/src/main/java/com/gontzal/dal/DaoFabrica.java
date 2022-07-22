package com.gontzal.dal;

public class DaoFabrica {

	private DaoUsuario daoUsuario;
	private DaoProducto daoProducto;
	private DaoLibro daoLibro;
	private DaoReserva daoReserva;
	
	public DaoFabrica(String tipoDao) {
		this(tipoDao, null, null, null, null);
	}

	public DaoFabrica(String tipoDao, String url, String user, String pass,String driver) {

		switch (tipoDao) {
		case "memoria": {
			daoUsuario = DaoUsuarioMemoria.getInstancia();
			daoProducto = new DaoProductoMemoria();
			daoLibro = new DaoLibroMemoria();
			daoReserva = new DaoReservaMemoria();
			break;
		}
		case "mySql": {
			daoUsuario = new DaoUsuarioMySQL(url,user,pass,driver);
			daoLibro = new DaoLibroMySQL(url,user,pass,driver);
			daoReserva = new DaoReservaMySQL(url,user,pass,driver);
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

	public DaoLibro getDaoLibro() {
		return daoLibro;
	}

	public DaoReserva getDaoReserva() {
		return daoReserva;
	}

}
