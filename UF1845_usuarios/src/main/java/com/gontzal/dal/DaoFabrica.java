package com.gontzal.dal;

public class DaoFabrica {

	private DaoUsuario daoUsuario;
	private DaoProducto daoProducto;
	private DaoLibro daoLibro;
	private DaoReserva daoReserva;

	public DaoFabrica(String tipoDao) {

		switch (tipoDao) {
		case "memoria": {
			daoUsuario = DaoUsuarioMemoria.getInstancia();
			daoProducto = new DaoProductoMemoria();
			daoLibro= new DaoLibroMemoria();
			daoReserva= new DaoReservaMemoria();
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
