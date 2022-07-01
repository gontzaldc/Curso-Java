package com.gontzal.dal;

import java.sql.*;
import java.util.ArrayList;

import com.gontzal.modelos.Libro;

class DaoLibroMySQL implements DaoLibro {

	private String url, user, pass;

	private static final String SQL_SELECT = "SELECT id, nombre, categoria, disponible FROM libros";
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE id = ?";
	private static final String SQL_INSERT = "INSERT INTO libros (nombre,categoria,disponible) VALUES(?,?,?)";
	private static final String SQL_UPDATE = "UPDATE libros SET nombre = ?, categoria = ?, disponible = ? WHERE id = ?";
	private static final String SQL_DELETE = "DELETE FROM libros WHERE id = ?";

	@Override
	public Iterable<Libro> obtenerTodos() {
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pst = con.prepareStatement(SQL_SELECT);
				ResultSet rs = pst.executeQuery()) {

			ArrayList<Libro> libros = new ArrayList<>();

			while (rs.next()) {
				Libro libro = new Libro(rs.getLong("id"), rs.getString("nombre"), rs.getString("categoria"),
						rs.getBoolean("disponible"));
				libros.add(libro);
			}

			return libros;

		} catch (SQLException e) {
			throw new DalException("No se han podido obtener los registros");
		}
	}

	@Override
	public Libro obtenerPorId(Long id) {
		
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID)) {
			
			pst.setLong(1, id);
			
			try (ResultSet rs = pst.executeQuery()) {
				
				Libro libro= null;
				
				if(rs.next()) {
					libro = new Libro(rs.getLong("id"),rs.getString("nombre"),rs.getString("categoria"),rs.getBoolean("disponible"));
				}
				
				return libro;
			}
			
		} catch (SQLException e) {
			throw new DalException("no se ha podido encontrar el registro",e);
		}
	}

	@Override
	public Libro insertar(Libro libro) {
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pst = con.prepareStatement(SQL_INSERT)) {
			
			pst.setString(1, libro.getNombre());
			pst.setString(2, libro.getCategoria());
			pst.setBoolean(3, libro.getDisponible());
			
			if(pst.executeUpdate()!=1) {
				throw new DalException("No se");
			}
			return libro;
			
		} catch (SQLException e) {
			throw new DalException("No se ha podido ingresar el registro",e);
		}
	}

	@Override
	public Libro modificar(Libro objeto) {
		// TODO Auto-generated method stub
		return DaoLibro.super.modificar(objeto);
	}

	@Override
	public void borrar(Long id) {
		// TODO Auto-generated method stub
		DaoLibro.super.borrar(id);
	}

	public DaoLibroMySQL(String url, String user, String pass, String driver) {
		this.url = url;
		this.user = user;
		this.pass = pass;

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new DalException("No se ha encontrado el driver de base de datos", e);
		}
	}

}
