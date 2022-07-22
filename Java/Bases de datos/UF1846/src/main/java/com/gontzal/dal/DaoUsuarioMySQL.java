package com.gontzal.dal;

import java.sql.*;
import java.util.ArrayList;

import com.gontzal.modelos.Usuario;
import com.gontzal.modelos.Usuario.Roles;

class DaoUsuarioMySQL implements DaoUsuario {

	private String url, user, pass;

	private static final String SQL_SELECT = "SELECT id, nombre, email, password, rol FROM usuarios";
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE id = ?";
	private static final String SQL_SELECT_EMAIL = SQL_SELECT + " WHERE email = ?";
	private static final String SQL_INSERT = "INSERT INTO usuarios (nombre,email.password) VALUES(?,?,?)";
	private static final String SQL_UPDATE = "UPDATE usuarios SET nombre = ?, email = ?, password = ? WHERE id = ?";
	private static final String SQL_DELETE = "DELETE FROM usuarios WHERE id = ?";

	public DaoUsuarioMySQL(String url, String user, String pass, String driver) {
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
	public Iterable<Usuario> obtenerTodos() {
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pst = con.prepareStatement(SQL_SELECT);
				ResultSet rs = pst.executeQuery()) {

			ArrayList<Usuario> usuarios = new ArrayList<>();

			while (rs.next()) {
				Usuario usuario = new Usuario(rs.getLong("id"), rs.getString("nombre"), rs.getString("email"),
						rs.getString("password"), Roles.valueOf(rs.getString("rol")));
				usuarios.add(usuario);
			}

			return usuarios;

		} catch (SQLException e) {
			throw new DalException("No se han podido obtener los registros", e);
		}

	}

	@Override
	public Usuario obtenerPorId(Long id) {

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID);) {

			pst.setLong(1, id);

			try (ResultSet rs = pst.executeQuery()) {
				Usuario usuario = null;

				if (rs.next()) {
					usuario = new Usuario(rs.getLong("id"), rs.getString("nombre"), rs.getString("email"),
							rs.getString("password"), Roles.valueOf(rs.getString("rol")));
				}

				return usuario;
			}

		} catch (SQLException e) {
			throw new DalException("No se ha podido obtener el registro", e);
		}
	}

	@Override
	public Usuario insertar(Usuario usuario) {

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {

			pst.setString(1, usuario.getNombre());
			pst.setString(2, usuario.getEmail());
			pst.setString(3, usuario.getPassword());

			pst.executeQuery();

			ResultSet rs = pst.getGeneratedKeys();

			if (rs != null && rs.next()) {
				usuario.setId(rs.getLong(1));
			}

			return usuario;

		} catch (SQLException e) {
			throw new DalException("No se ha podido obtener el registro", e);
		}
	}

	@Override
	public Usuario modificar(Usuario usuario) {
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pst = con.prepareStatement(SQL_UPDATE);) {

			pst.setString(1, usuario.getNombre());
			pst.setString(2, usuario.getEmail());
			pst.setString(3, usuario.getPassword());
			pst.setLong(4, usuario.getId());

			if (pst.executeUpdate() != 1) {
				throw new DalException("No se ha encontrado el usuario a modificar");
			}

			return usuario;

		} catch (SQLException e) {
			throw new DalException("No se ha podido modificar el registro", e);
		}
	}

	@Override
	public void borrar(Long id) {
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pst = con.prepareStatement(SQL_DELETE);) {

			pst.setLong(1, id);

			if (pst.executeUpdate() != 1) {
				throw new DalException("No se ha encontrado el usuario a borrar");
			}

		} catch (SQLException e) {
			throw new DalException("No se ha podido obtener el registro", e);
		}
	}

	@Override
	public Usuario BuscarPorEmail(String email) {

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_EMAIL);) {

			pst.setString(1, email);

			try (ResultSet rs = pst.executeQuery()) {
				Usuario usuario = null;

				if (rs.next()) {
					usuario = new Usuario(rs.getLong("id"), rs.getString("nombre"), rs.getString("email"),
							rs.getString("password"), Roles.valueOf(rs.getString("rol")));
				}

				return usuario;
			}

		} catch (SQLException e) {
			throw new DalException("No se ha podido obtener el registro", e);
		}
	}

}
