package com.gontzal.dal;

import java.sql.*;
import java.util.ArrayList;

import com.gontzal.modelos.*;
import com.gontzal.modelos.Usuario.Roles;

class DaoReservaMySQL implements DaoReserva {

	private String url, user, pass;

	private static final String SQL_SELECT = "SELECT id, id_usuario, id_libro, fecha FROM reservas";


	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE id = ?";
	private static final String SQL_INSERT = "INSERT INTO reservas (fecha,usuarios_id,libros_id) VALUES(?,?,?)";
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

	@Override
	public Reserva insertar(Reserva reserva) {
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {

			pst.setString(1, reserva.getFecha().toString());
			pst.setLong(2, 2L);
			pst.setLong(3, reserva.getLibro().getId());

			pst.executeUpdate();

			ResultSet rs = pst.getGeneratedKeys();

			if (rs != null && rs.next()) {
				reserva.setId(rs.getLong(1));
			}

			return reserva;
		} catch (SQLException e) {
			throw new DalException("No se ha podido insertar", e);
		}
	}





}
