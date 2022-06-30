package com.gontzal.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeMap;

import com.gontzal.modelos.Usuario;

public class DaoUsuarioMySQL implements DaoUsuario{

	private static final String URL = "jdbc:mysql://localhost:3306/uf1846m";
	private static final String USER = "root";
	private static final String PASS = "My#adm1n";
	
	private static final String SQL_SELECT = "SELECT id, email, password FROM usuarios";
	
	private static final TreeMap<Long, Usuario> usuarios = new TreeMap<>();
	

	
	
	private DaoUsuarioMySQL() {
		
	}
	
	private static final DaoUsuarioMySQL INSTANCIA= new DaoUsuarioMySQL();
	
	public static DaoUsuarioMySQL getInstancia() {
		return INSTANCIA;
	}
	
	
	
	@Override
	public Iterable<Usuario> obtenerTodos() {
		

		Usuario u = new Usuario();
		try {
			Connection con = DriverManager.getConnection(URL, USER, PASS);
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(SQL_SELECT);
		while (rs.next()) {
			u.setEmail(rs.getString(2));
			u.setcontrasena(rs.getString(3));
			usuarios.put(rs.getLong(1),u);
		}
		
		} catch (SQLException e) {
			throw new DalException("No se ha podido recibir nada de la bbdd");
		}
		
		return usuarios.values();
	}

}
