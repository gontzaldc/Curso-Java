package com.gontzal.dal;

import java.sql.*;
import java.util.ArrayList;

import com.gontzal.modelos.*;

class DaoReservaMySQL implements DaoReserva {

	private String url, user, pass;

	private static final String SQL_SELECT = "SELECT id, id_usuario, id_libro, fecha FROM reservas";
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE id = ?";
	private static final String SQL_INSERT = "INSERT INTO libros (nombre,categoria,disponible) VALUES(?,?,?)";
	private static final String SQL_UPDATE = "UPDATE libros SET nombre = ?, categoria = ?, disponible = ? WHERE id = ?";
	private static final String SQL_DELETE = "DELETE FROM libros WHERE id = ?";
	
	public DaoReservaMySQL(String url, String user, String pass, String driver) {
		this.url = url;
		this.user = user;
		this.pass = pass;

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new DalException("No se ha encontrado el driver de base de datos", e);
		}
	}
	
	@Override
	public Iterable<Reserva> obtenerPorEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
