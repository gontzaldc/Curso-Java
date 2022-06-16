package com.gontzal.dal;

import java.util.TreeMap;

import com.gontzal.modelos.Usuario;

public class DaoUsuarioMemoria implements DaoUsuario {

	private static final TreeMap<Long, Usuario> usuarios = new TreeMap<>();

	static {
		usuarios.put(1L, new Usuario(1L, "gontzal", "gontzal@gdasda.sad", "12345"));
		usuarios.put(2L, new Usuario(2L, "usuario2", "usuario2@gdasda.sad", "2222222"));
		usuarios.put(3L, new Usuario(3L, "usuario3", "usuario3@gdasda.sad", "3333333"));
	}

	// SINGLETON

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

	public Usuario insertar(Usuario usuario) {
		Long id = usuarios.size() > 0 ? usuarios.lastKey() + 1 : 1L;
		usuario.setId(id);
		return usuarios.put(id, usuario);
	}

	public Usuario modificar(Usuario usuario) {
		return usuarios.put(usuario.getId(), usuario);
	}

	public void borrar(Long id) {
		usuarios.remove(id);
	}

	@Override
	public Usuario BuscarPorEmail(String email) {


//		for (Usuario u : usuarios.values()) {
//			if (u.getEmail().equals(email)) {
//				return u;
//			}
//
//		}
//		return null;
		
		//más optimo
		return usuarios.values().parallelStream().filter(u->u.getEmail().equals(email)).findFirst().orElse(null);

	}

}
