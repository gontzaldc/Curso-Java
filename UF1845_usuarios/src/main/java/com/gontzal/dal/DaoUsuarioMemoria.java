package com.gontzal.dal;

import java.util.TreeMap;

import com.gontzal.modelos.Usuario;

public class DaoUsuarioMemoria implements DaoUsuario {

	private static final TreeMap<Long,Usuario> usuarios= new TreeMap<>(); 
	
	static {
		usuarios.put(1L, new Usuario(1L,"gontzal","gontzal@gdasda.sad","12345"));
		usuarios.put(2L, new Usuario(2L,"usuario2","usuario2@gdasda.sad","2222222"));
		usuarios.put(3L, new Usuario(3L,"usuario3","usuario3@gdasda.sad","3333333"));
	}
	
	//SINGLETON
	
	private DaoUsuarioMemoria() {
		
	}
	
	private static final DaoUsuarioMemoria INSTANCIA = new DaoUsuarioMemoria();
	
	public static DaoUsuarioMemoria getInstancia() {
		return INSTANCIA;
	}

	// FIN SINGLETON
	
	public Iterable<Usuario> obtenerTodos() {
		return usuarios.values();
	}

	public Usuario obtenerPorId(Long id) {
		return usuarios.get(id);
	}
	
	
	
}
