package com.gontzal.dal;

import java.sql.*;

import com.gontzal.modelos.Usuario;

class DaoUsuarioMySQL implements DaoUsuario{

	private static final String URL = "jdbc:mysql://localhost:3306/uf1846m";
	private static final String USER = "root";
	private static final String PASS = "admin";
	
	private static final String SQL_SELECT = "SELECT id, email, password FROM usuarios";
	
	@Override
	public Iterable<Usuario> obtenerTodos() {
		// TODO Auto-generated method stub

//		Connection con;
//		
//		
//		try {
//			con = DriverManager.getConnection(URL, USER, PASS);
//		
//		Statement st = con.createStatement();
//		ResultSet rs = st.executeQuery(SQL_SELECT);
//		while (rs.next()) {
//			
//		}
//		
//		} catch (SQLException e) {
//			throw new DalException("No se ha podido recibir nada de la bbdd");
//		}

		return DaoUsuario.super.obtenerTodos();
	}

}
